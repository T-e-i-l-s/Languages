package com.mustafin.languages.mainFlow.data.repositories.sessionInfoRepository

interface SessionInfoRepository {
    fun getSessionLanguage(): Int
    fun setSessionLanguage(languageId: Int)
}