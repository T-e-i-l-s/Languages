package com.mustafin.languages.mainFlow.data.source.local.lessonsSource

import com.mustafin.languages.core.utils.languageUtils.LanguageModel
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel

/* Класс со списком уроков */
class LessonsSource {
    private val languagesFullInfo = listOf(
        LanguageModel(
            0,
            listOf(
                ShortLessonModel(
                    0,
                    "Блок 1. Введение.",
                    true
                ),
                ShortLessonModel(
                    0,
                    "Блок 1. Реальные примеры.",
                    false
                ),
                ShortLessonModel(
                    0,
                    "Блок 1. Проверь себя.",
                    false
                )
            )
        ),
        LanguageModel(
            1,
            listOf(
                ShortLessonModel(
                    0,
                    "Блок 1. Татарский язык.",
                    true
                ),
                ShortLessonModel(
                    0,
                    "Блок 1. Знакомство.",
                    false
                )
            )
        )
    )

    fun getLessonsByLanguageId(requiredLanguageId: Int): List<ShortLessonModel> {
        for (languageInfo in languagesFullInfo) {
            if (languageInfo.id == requiredLanguageId) {
                return languageInfo.lessons
            }
        }
        throw Exception("No such language")
    }
}