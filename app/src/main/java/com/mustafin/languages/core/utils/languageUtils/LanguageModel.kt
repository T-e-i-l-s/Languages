package com.mustafin.languages.core.utils.languageUtils

import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel

/* Основная информация о языке, который доступен в приложении */
data class LanguageModel(
    val id: Int,
    val lessons: List<ShortLessonModel>
)
