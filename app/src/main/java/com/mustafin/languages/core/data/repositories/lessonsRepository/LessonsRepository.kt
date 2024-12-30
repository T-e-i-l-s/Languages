package com.mustafin.languages.core.data.repositories.lessonsRepository

import com.mustafin.languages.core.utils.lessonUtils.LessonModel
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel

interface LessonsRepository {
    fun getLessonsByLanguageId(languageId: Int): List<ShortLessonModel>
    fun setLessonDone(lessonId: Int)
}