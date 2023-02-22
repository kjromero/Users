package com.kenny.users.di.modules

import com.kenny.users.di.qualifers.RetrofitBasic
import com.kenny.users.domain.services.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object NetworkServiceModule {

    @Provides
    fun provideUsersService(@RetrofitBasic retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }
}