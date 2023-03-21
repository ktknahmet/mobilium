package com.ktknahmet.mobilium.utils

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val bearerToken ="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxZGNkNWVmNzFlM2VhNjlhZj" +
                "U5MmNjZDJjMDBjYzQwNyIsInN1YiI6IjY0MTRiM2EyZTljMGRjMDBhNDBhZDAzNCIsInNjb" +
                "3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.-GBQop5IGxCY7ZF_0qL3K5aktCVhCL7KqYbhCRtqkIE"

        requestBuilder.addHeader("Authorization", "Bearer $bearerToken")


        return chain.proceed(requestBuilder.build())
    }
}