package com.beatrice.androidgraphql.domain

import com.beatrice.androidgraphql.domain.model.GitRepo
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getLatestTrendingRepositoriesInLastWeek(): Flow<List<GitRepo?>?>
}