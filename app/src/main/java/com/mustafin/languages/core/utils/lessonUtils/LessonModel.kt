package com.mustafin.languages.core.utils.lessonUtils

/* Полная информация о уроке */
data class LessonModel(
    val id: Int,
    val name: String,
    val done: Boolean,
    val stages: List<LessonUnitModel>
)
