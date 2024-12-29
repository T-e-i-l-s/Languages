package com.mustafin.languages.lessonFlow.data.repositories.lessonContentRepository

import com.mustafin.languages.core.utils.lessonUtils.LessonModel
import com.mustafin.languages.lessonFlow.data.source.local.lessonContentSource.LessonContentSource
import javax.inject.Inject

/* Репозиторий для работы с содержимым урока */
class LessonContentRepositoryImpl @Inject constructor(
    private val lessonContentSource: LessonContentSource
): LessonContentRepository {
    override fun getLessonContentById(id: Int): LessonModel {
        return lessonContentSource.getLessonContentById(id)
    }
}