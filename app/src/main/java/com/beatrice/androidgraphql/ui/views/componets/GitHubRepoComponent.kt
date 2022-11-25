package com.beatrice.androidgraphql.ui.views.componets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatrice.androidgraphql.domain.model.GitRepo

@Composable
fun GitHubRepoComponent(repo: GitRepo) {
    Card(
        modifier = Modifier.fillMaxWidth().height(200.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = repo.name,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace,
                )
            )
            Text(
                text = repo.description ?: "",
                style = TextStyle(
                    fontSize = 18.sp,
                )
            )

            Text(
                text = "${repo.owner} | ${repo.primaryLanguage}",
                style = TextStyle(
                    fontSize = 17.sp,
                    fontStyle = FontStyle.Italic
                )
            )
        }

    }
}

@Preview
@Composable
fun GitHubRepoComponentPreview() {
    Surface(color = Color.White) {
        GitHubRepoComponent(testRepo)
    }

}

val testRepo = GitRepo(
    name = "ABC",
    owner = "ABC",
    description = "ABC",
    primaryLanguage = "ABC"
)