package com.mustafin.languages.core.data.source.local.lessonsSource

import android.content.SharedPreferences
import com.mustafin.languages.core.utils.languageUtils.LanguageModel
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel
import javax.inject.Inject

/* Класс со списком уроков */
class LessonsSource @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    private val languagesFullInfo = listOf(
        LanguageModel(
            0,
            listOf(
                ShortLessonModel(
                    0,
                    "Введение"
                ),
                ShortLessonModel(
                    1,
                    "Приветствие"
                ),
                ShortLessonModel(
                    2,
                    "Структура предложения"
                ),
                ShortLessonModel(
                    3,
                    "Диалог"
                ),
                ShortLessonModel(
                    5,
                    "Культура Татарстана"
                ),
            )
        ),
        LanguageModel(
            1,
            listOf()
        ),
        LanguageModel(
            2,
            listOf()
        ),
    )

    fun getLessonsByLanguageId(requiredLanguageId: Int): List<ShortLessonModel> {
        languagesFullInfo.forEach {
            if (it.id == requiredLanguageId) {
                return it.lessons.map { lesson ->
                    lesson.done = sharedPreferences.getBoolean("lesson_${lesson.id}", false)
                    lesson
                }
            }
        }
        throw Exception("No such language")
    }

    fun setLessonDone(lessonId: Int) {
        sharedPreferences.edit().putBoolean("lesson_${lessonId}", true).apply()
    }
}