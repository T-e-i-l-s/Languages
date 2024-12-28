package com.mustafin.languages.mainFlow.data.source.local.languagesSource

import com.mustafin.languages.R
import com.mustafin.languages.core.utils.languageUtils.LanguageModel

/* Класс со списком всех языков в приложении */
class LanguagesSource {
    private val languages = listOf(
        LanguageModel(
            0,
            "Русский",
            R.drawable.russian
        ),
        LanguageModel(
            1,
            "Татарский",
            R.drawable.tatar
        )
    )

    fun getLanguages(): List<LanguageModel> {
        return languages
    }
}