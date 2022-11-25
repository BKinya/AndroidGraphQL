package com.beatrice.androidgraphql.ui.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beatrice.androidgraphql.data.repository.MainRepositoryImpl
import com.beatrice.androidgraphql.domain.model.GitRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import logcat.logcat

@RequiresApi(Build.VERSION_CODES.O)
class MainViewModel : ViewModel() {
    private val _repos = MutableStateFlow<List<GitRepo?>>(emptyList())
    val repos: StateFlow<List<GitRepo?>> get() = _repos



    @RequiresApi(Build.VERSION_CODES.O)
    fun getLatest() {
        viewModelScope.launch {
            val repository = MainRepositoryImpl()
            repository.getLatestTrendingRepositoriesInLastWeek().collectLatest {
                logcat("GitHub_Repos ") { "size VM => ${it?.size}}" }
                it?.let {
                    _repos.value = it
                }
            }
        }
    }
}