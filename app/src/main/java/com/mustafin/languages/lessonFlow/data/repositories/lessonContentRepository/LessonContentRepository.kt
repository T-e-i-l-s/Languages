package com.mustafin.languages.lessonFlow.data.repositories.lessonContentRepository

import com.mustafin.languages.core.utils.lessonUtils.LessonModel

interface LessonContentRepository {
    fun getLessonContentById(id: Int): LessonModel 
}