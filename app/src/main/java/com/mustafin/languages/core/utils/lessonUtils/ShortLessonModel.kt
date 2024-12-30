package com.mustafin.languages.core.utils.lessonUtils

/* Полная информация о уроке */
data class ShortLessonModel(
    val id: Int,
    val name: String,
    var done: Boolean = false
)
