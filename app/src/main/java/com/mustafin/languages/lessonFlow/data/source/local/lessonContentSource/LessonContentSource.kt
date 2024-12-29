package com.mustafin.languages.lessonFlow.data.source.local.lessonContentSource

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.mustafin.languages.core.utils.lessonUtils.InformationUnitModel
import com.mustafin.languages.core.utils.lessonUtils.LessonModel
import com.mustafin.languages.core.utils.lessonUtils.LessonUnitModel
import com.mustafin.languages.core.utils.lessonUtils.LessonUnitType
import com.mustafin.languages.core.utils.lessonUtils.QuizUnitModel

/* Класс для получения данных о содержимом уроков */
class LessonContentSource {
    private val lessons = listOf(
        LessonModel(
            0,
            "Блок 1. Введение.",
            true,
            listOf(
                LessonUnitModel(
                    LessonUnitType.INFORMATION,
                    InformationUnitModel(
                        LoremIpsum(2).values.first(),
                        LoremIpsum(25).values.first(),
                        LoremIpsum(1).values.first(),
                    )
                ),
                LessonUnitModel(
                    LessonUnitType.QUIZ,
                    QuizUnitModel(
                        LoremIpsum(4).values.first(),
                        listOf(
                            LoremIpsum(1).values.first(),
                            LoremIpsum(1).values.first(),
                            LoremIpsum(1).values.first()
                        ),
                        0
                    )
                )
            )
        )
    )

    fun getLessonContentById(id: Int): LessonModel {
        lessons.forEach {
            if (it.id == id) return it
        }
        throw Exception("No such lesson")
    }
}