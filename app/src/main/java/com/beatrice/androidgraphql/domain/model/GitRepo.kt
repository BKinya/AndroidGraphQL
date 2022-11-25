package com.beatrice.androidgraphql.domain.model


data class GitRepo(
    val name: String,
    val owner: String,
    val description: String?,
    val primaryLanguage: String?
)
