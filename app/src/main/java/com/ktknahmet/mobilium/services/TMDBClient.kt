package com.ktknahmet.mobilium.services


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.ktknahmet.mobilium.utils.AppConstants
import com.ktknahmet.mobilium.utils.IRxSchedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
class TMDBClient {

    @Provides
    @Singleton
    internal fun provideCoroutineApiService(@Named(AppConstants.COROUTINE_RETROFIT) restAdapter: Retrofit): TMDPInterface {
        return restAdapter.create(TMDPInterface::class.java)
    }

    @Provides
    @Singleton
    @Named(AppConstants.COROUTINE_RETROFIT)
    internal fun provideCoroutineRestAdapter(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        @Suppress("DEPRECATION") val httpBuilder = OkHttpClient.Builder()
            .callTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
        return httpBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideRxApiService(@Named(AppConstants.RX_RETROFIT) restAdapter: Retrofit): RxService {
        return restAdapter.create(RxService::class.java)
    }

    @Provides
    @Singleton
    @Named(AppConstants.RX_RETROFIT)
    internal fun provideRxRestAdapter(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideRxSchedulers(): IRxSchedulers {
        return object : IRxSchedulers {
            override fun main() = mainThread()
            override fun io() = Schedulers.io()
        }
    }
}

