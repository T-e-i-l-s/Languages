package com.mustafin.languages.mainFlow.data.source.local

import com.mustafin.languages.R
import com.mustafin.languages.core.utils.langageUtils.LanguageModel

/* Класс со списком всех языков в приложении */
class LanguagesSource {
    private val languages = listOf(
        LanguageModel(
            0,
            "Русский",
            R.drawable.russian
        ),
        LanguageModel(
            0,
            "Татарский",
            R.drawable.tatar
        )
    )

    fun getLanguages(): List<LanguageModel> {
        return languages
    }
}