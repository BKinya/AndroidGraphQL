package com.beatrice.androidgraphql.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.beatrice.androidgraphql.GetLatestTrendingRepositoriesInLastWeekQuery
import com.beatrice.androidgraphql.data.network.apolloClient
import com.beatrice.androidgraphql.domain.MainRepository
import com.beatrice.androidgraphql.domain.model.GitRepo
import com.beatrice.androidgraphql.type.SearchType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import logcat.logcat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainRepositoryImpl() : MainRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getLatestTrendingRepositoriesInLastWeek(): Flow<List<GitRepo?>?> = flow {
        val lastWeekDate = LocalDate.now().minusDays(7)
        val formattedDateText =
            DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(lastWeekDate)

        val queryCall = GetLatestTrendingRepositoriesInLastWeekQuery(
            first = 15,
            query = "created:>$formattedDateText sort:stars-desc",
            type = SearchType.REPOSITORY
        )
        val response = apolloClient.query(query = queryCall).execute()
        logcat("TEST") { "size => ${response.data?.search?.edges?.size}" }
        val repoes: List<GitRepo?>? = response.data?.search?.edges?.let { result ->
            result.map { edge ->
                logcat("TEST"){"prepping result"}
                edge?.let {
                    val repo = it.node?.onRepository
                    repo?.let { repo ->
                        GitRepo(
                            name = repo.name,
                            description = repo.description,
                            owner = repo.owner.login,
                            primaryLanguage = repo.primaryLanguage?.name
                        )
                    }
                }
            }
        }

        emit(repoes)

    }
}