package com.mustafin.languages.mainFlow.data.repositories.languagesRepository

import com.mustafin.languages.core.utils.langageUtils.LanguageModel
import com.mustafin.languages.mainFlow.data.source.local.LanguagesSource
import javax.inject.Inject

class LanguagesRepositoryImpl @Inject constructor(
    private val languagesSource: LanguagesSource
): LanguagesRepository {
    override fun getLanguages(): List<LanguageModel> {
        return languagesSource.getLanguages()
    }
}