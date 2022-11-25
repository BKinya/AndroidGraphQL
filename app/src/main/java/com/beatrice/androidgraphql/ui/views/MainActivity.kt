package com.beatrice.androidgraphql.ui.views

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.beatrice.androidgraphql.ui.theme.AndroidGraphQLTheme
import com.beatrice.androidgraphql.ui.views.componets.GitHubReposListComponent

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidGraphQLTheme {
                val mainViewModel: MainViewModel = viewModel()
                LaunchedEffect(true){
                    mainViewModel.getLatest()
                }
                val repos = mainViewModel.repos.collectAsState().value
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GitHubReposListComponent(repoList = repos)
                }
            }
        }
    }
}



