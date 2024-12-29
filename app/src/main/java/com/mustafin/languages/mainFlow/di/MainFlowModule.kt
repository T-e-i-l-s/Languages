package com.mustafin.languages.mainFlow.di

import android.content.SharedPreferences
import com.mustafin.languages.mainFlow.data.repositories.languagesRepository.LanguagesRepository
import com.mustafin.languages.mainFlow.data.repositories.languagesRepository.LanguagesRepositoryImpl
import com.mustafin.languages.mainFlow.data.repositories.lessonsRepository.LessonsRepository
import com.mustafin.languages.mainFlow.data.repositories.lessonsRepository.LessonsRepositoryImpl
import com.mustafin.languages.mainFlow.data.repositories.sessionInfoRepository.SessionInfoRepository
import com.mustafin.languages.mainFlow.data.repositories.sessionInfoRepository.SessionInfoRepositoryImpl
import com.mustafin.languages.mainFlow.data.source.local.languagesSource.LanguagesSource
import com.mustafin.languages.mainFlow.data.source.local.lessonsSource.LessonsSource
import com.mustafin.languages.mainFlow.data.source.local.sessionsInfoPrefs.SessionInfoPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainFlowModule {
    // Data sources
    @Provides
    @Singleton
    fun provideSessionInfoPrefs(sharedPreferences: SharedPreferences): SessionInfoPrefs {
        return SessionInfoPrefs(sharedPreferences)
    }
    @Provides
    @Singleton
    fun provideLanguagesSource(): LanguagesSource {
        return LanguagesSource()
    }
    @Provides
    @Singleton
    fun provideLessonsSource(): LessonsSource {
        return LessonsSource()
    }


    // Repositories
    @Provides
    @Singleton
    fun provideSessionInfoRepository(sessionInfoPrefs: SessionInfoPrefs): SessionInfoRepository {
        return SessionInfoRepositoryImpl(sessionInfoPrefs)
    }
    @Provides
    @Singleton
    fun provideLanguagesRepository(languagesSource: LanguagesSource): LanguagesRepository {
        return LanguagesRepositoryImpl(languagesSource)
    }
    @Provides
    @Singleton
    fun provideLessonsRepository(lessonsSource: LessonsSource): LessonsRepository {
        return LessonsRepositoryImpl(lessonsSource)
    }
}