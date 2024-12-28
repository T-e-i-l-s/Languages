package com.mustafin.languages.mainFlow.data.repositories.languagesRepository

import com.mustafin.languages.core.utils.languageUtils.LanguageModel

interface LanguagesRepository {
    fun getLanguages(): List<LanguageModel>
}