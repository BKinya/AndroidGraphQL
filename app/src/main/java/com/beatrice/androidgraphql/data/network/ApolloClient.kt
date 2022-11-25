package com.beatrice.androidgraphql.data.network

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.util.concurrent.TimeUnit

val GITHUB_GRAPHQL_ENDPOINT = "https://api.github.com/graphql"

val httpClient: OkHttpClient by lazy {
    OkHttpClient.Builder()
        .writeTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .addNetworkInterceptor(NetworkInterceptor())
        .build()
}


val apolloClient: ApolloClient by lazy {
    ApolloClient.builder()
        .serverUrl(GITHUB_GRAPHQL_ENDPOINT)
        .okHttpClient(httpClient)
        .build()
}

class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder().header("Authorization", "Bearer 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").build()
        )
    }
}

