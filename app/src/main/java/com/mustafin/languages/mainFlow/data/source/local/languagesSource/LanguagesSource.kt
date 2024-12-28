package com.mustafin.languages.mainFlow.data.source.local.languagesSource

import com.mustafin.languages.R
import com.mustafin.languages.core.utils.languageUtils.LanguageModel
import com.mustafin.languages.core.utils.languageUtils.ShortLanguageModel

/* Класс со списком всех языков в приложении */
class LanguagesSource {
    private val languages = listOf(
        ShortLanguageModel(
            0,
            "Русский",
            R.drawable.russian
        ),
        ShortLanguageModel(
            1,
            "Татарский",
            R.drawable.tatar
        )
    )

    fun getLanguages(): List<ShortLanguageModel> {
        return languages
    }
}