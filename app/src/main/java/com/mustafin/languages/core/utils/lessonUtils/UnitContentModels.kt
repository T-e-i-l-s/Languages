package com.mustafin.languages.core.utils.lessonUtils

/* Абстракция для содержимого модуля */
interface UnitContentModel

/* Модель содержимого модуля с информацией */
data class InformationUnitModel(
    val title: String,
    val text: String,
    val buttonText: String
): UnitContentModel

/* Модель содержимого модуля с тестом */
data class QuizUnitModel(
    val question: String,
    val variants: List<String>,
    val correctVariantIndex: Int
): UnitContentModel