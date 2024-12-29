package com.mustafin.languages.lessonFlow.data.di

import com.mustafin.languages.lessonFlow.data.repositories.lessonContentRepository.LessonContentRepository
import com.mustafin.languages.lessonFlow.data.repositories.lessonContentRepository.LessonContentRepositoryImpl
import com.mustafin.languages.lessonFlow.data.source.local.lessonContentSource.LessonContentSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LessonFlowModule {
    // Data source
    @Provides
    @Singleton
    fun provideLessonContentSource(): LessonContentSource {
        return LessonContentSource()
    }

    // Repository
    @Provides
    @Singleton
    fun provideLessonContentRepository(lessonContentSource: LessonContentSource): LessonContentRepository {
        return LessonContentRepositoryImpl(lessonContentSource)
    }
}