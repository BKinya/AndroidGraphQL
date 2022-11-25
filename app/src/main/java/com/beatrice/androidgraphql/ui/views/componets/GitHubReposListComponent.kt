package com.beatrice.androidgraphql.ui.views.componets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatrice.androidgraphql.domain.model.GitRepo

@Composable
fun GitHubReposListComponent(repoList: List<GitRepo?>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(11.dp)
    ) {
        item {
            Text(
                text = "Latest Repositories",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace
                )
            )
        }
        items(repoList) { repo ->
            repo?.let {
                GitHubRepoComponent(repo = repo)
            }
        }
    }

}