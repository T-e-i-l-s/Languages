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
                    "Введение",
                    true
                ),
                ShortLessonModel(
                    1,
                    "Приветствие",
                    false
                ),
                ShortLessonModel(
                    2,
                    "Структура предложения",
                    false
                ),
                ShortLessonModel(
                    3,
                    "Диалог",
                    false
                ),
                ShortLessonModel(
                    4,
                    "Действие",
                    false
                ),
                ShortLessonModel(
                    5,
                    "Культура Татарстана",
                    false
                ),
            )
        ),
        LanguageModel(
            1,
            listOf(
                ShortLessonModel(
                    6,
                    "Блок 1",
                    true
                )
            )
        ),
        LanguageModel(
            2,
            listOf(
                ShortLessonModel(
                    7,
                    "Блок 1",
                    true
                )
            )
        ),
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