package com.kenny.users.di.modules

import com.kenny.users.di.qualifers.BasePath
import com.kenny.users.di.qualifers.RetrofitBasic
import com.kenny.users.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    @BasePath
    fun providesBasePath(): String {
        return BASE_URL
    }

    @Provides
    @Singleton
    @RetrofitBasic
    fun providesRetrofitBasic(
        @BasePath basePath: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(basePath)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}