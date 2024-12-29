package com.mustafin.languages.mainFlow.data.repositories.languagesRepository

import com.mustafin.languages.core.utils.languageUtils.ShortLanguageModel
import com.mustafin.languages.mainFlow.data.source.local.languagesSource.LanguagesSource
import javax.inject.Inject

/* Репозиторий для работы с данными о языках */
class LanguagesRepositoryImpl @Inject constructor(
    private val languagesSource: LanguagesSource
): LanguagesRepository {
    override fun getLanguages(): List<ShortLanguageModel> {
        return languagesSource.getLanguages()
    }

    override fun getLanguageById(id: Int): ShortLanguageModel {
        return languagesSource.getLanguageById(id)
    }
}