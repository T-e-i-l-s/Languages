package com.mustafin.languages.mainFlow.data.repositories.lessonsRepository

import com.mustafin.languages.core.utils.lessonUtils.LessonModel
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel

interface LessonsRepository {
    fun getLessonsByLanguageId(languageId: Int): List<ShortLessonModel>
    fun getLessonById(lessonId: Int): LessonModel
}