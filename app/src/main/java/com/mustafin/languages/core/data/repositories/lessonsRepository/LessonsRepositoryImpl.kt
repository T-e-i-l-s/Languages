package com.mustafin.languages.core.data.repositories.lessonsRepository

import com.mustafin.languages.core.utils.lessonUtils.LessonModel
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel
import com.mustafin.languages.core.data.source.local.lessonsSource.LessonsSource
import javax.inject.Inject

/* Репозиторий для работы с информацией об уроках */
class LessonsRepositoryImpl @Inject constructor(
    private val lessonsSource: LessonsSource
): LessonsRepository {
    override fun getLessonsByLanguageId(languageId: Int): List<ShortLessonModel> {
        return lessonsSource.getLessonsByLanguageId(languageId)
    }

    override fun setLessonDone(lessonId: Int) {
        lessonsSource.setLessonDone(lessonId)
    }
}