package com.mustafin.languages.mainFlow.data.repositories.languagesRepository

import com.mustafin.languages.core.utils.languageUtils.ShortLanguageModel

interface LanguagesRepository {
    fun getLanguages(): List<ShortLanguageModel>
    fun getLanguageById(id: Int): ShortLanguageModel
}