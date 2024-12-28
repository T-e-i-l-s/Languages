package com.mustafin.languages.mainFlow.data.repositories.languagesRepository

import com.mustafin.languages.core.utils.languageUtils.LanguageModel
import com.mustafin.languages.core.utils.languageUtils.ShortLanguageModel
import com.mustafin.languages.mainFlow.data.source.local.languagesSource.LanguagesSource
import javax.inject.Inject

class LanguagesRepositoryImpl @Inject constructor(
    private val languagesSource: LanguagesSource
): LanguagesRepository {
    override fun getLanguages(): List<ShortLanguageModel> {
        return languagesSource.getLanguages()
    }
}