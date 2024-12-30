package com.mustafin.languages.core.di

import android.content.Context
import android.content.SharedPreferences
import com.mustafin.languages.SHARED_PREF_NAME
import com.mustafin.languages.core.data.repositories.lessonsRepository.LessonsRepository
import com.mustafin.languages.core.data.repositories.lessonsRepository.LessonsRepositoryImpl
import com.mustafin.languages.core.data.source.local.lessonsSource.LessonsSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSharedPrefs(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    // Data sources
    @Provides
    @Singleton
    fun provideLessonsSource(sharedPreferences: SharedPreferences): LessonsSource {
        return LessonsSource(sharedPreferences)
    }

    // Repositories
    @Provides
    @Singleton
    fun provideLessonsRepository(lessonsSource: LessonsSource): LessonsRepository {
        return LessonsRepositoryImpl(lessonsSource)
    }
}