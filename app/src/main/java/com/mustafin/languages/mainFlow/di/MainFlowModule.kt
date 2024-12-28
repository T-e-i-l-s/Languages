package com.mustafin.languages.mainFlow.di

import android.content.SharedPreferences
import com.mustafin.languages.mainFlow.data.repositories.languagesRepository.LanguagesRepository
import com.mustafin.languages.mainFlow.data.repositories.languagesRepository.LanguagesRepositoryImpl
import com.mustafin.languages.mainFlow.data.repositories.sessionInfoRepository.SessionInfoRepository
import com.mustafin.languages.mainFlow.data.repositories.sessionInfoRepository.SessionInfoRepositoryImpl
import com.mustafin.languages.mainFlow.data.source.local.languagesSource.LanguagesSource
import com.mustafin.languages.mainFlow.data.source.local.sessionsInfoPrefs.SessionInfoPrefs
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

    @Provides
    @Singleton
    fun provideLanguagesSource(): LanguagesSource {
        return LanguagesSource()
    }

    @Provides
    @Singleton
    fun provideLanguagesRepository(languagesSource: LanguagesSource): LanguagesRepository {
        return LanguagesRepositoryImpl(languagesSource)
    }
}