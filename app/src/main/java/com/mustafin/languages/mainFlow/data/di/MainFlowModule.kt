package com.mustafin.languages.mainFlow.data.di

import android.content.SharedPreferences
import com.mustafin.languages.mainFlow.data.repositories.SessionInfoRepository
import com.mustafin.languages.mainFlow.data.repositories.SessionInfoRepositoryImpl
import com.mustafin.languages.mainFlow.data.source.local.SessionInfoPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainFlowModule {
    @Provides
    @Singleton
    fun provideSessionInfoPrefs(sharedPreferences: SharedPreferences): SessionInfoPrefs {
        return SessionInfoPrefs(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideSessionInfoRepository(): SessionInfoRepository {
        return SessionInfoRepositoryImpl()
    }
}