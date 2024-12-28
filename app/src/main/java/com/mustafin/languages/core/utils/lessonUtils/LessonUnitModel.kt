package com.mustafin.languages.core.utils.lessonUtils

/* Информация об одном из модулей урока */
data class LessonUnitModel(
    val type: LessonUnitType,
    val content: UnitContentModel
)