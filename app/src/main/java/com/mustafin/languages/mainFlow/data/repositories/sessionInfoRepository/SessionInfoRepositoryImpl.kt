package com.mustafin.languages.mainFlow.data.repositories.sessionInfoRepository

import com.mustafin.languages.mainFlow.data.source.local.sessionsInfoPrefs.SessionInfoPrefs
import javax.inject.Inject

class SessionInfoRepositoryImpl @Inject constructor(
    private val sessionInfoPrefs: SessionInfoPrefs
): SessionInfoRepository {
    override fun getSessionLanguage(): Int {
        return sessionInfoPrefs.getSessionLanguage()
    }

    override fun setSessionLanguage(languageId: Int) {
        sessionInfoPrefs.setSessionLanguage(languageId)
    }
}