package com.mustafin.languages.mainFlow.data.repositories.sessionInfoRepository

import com.mustafin.languages.core.utils.sessionUtils.SessionInfo
import com.mustafin.languages.mainFlow.data.source.local.sessionsInfoPrefs.SessionInfoPrefs
import javax.inject.Inject

class SessionInfoRepositoryImpl @Inject constructor(
    private val sessionInfoPrefs: SessionInfoPrefs
): SessionInfoRepository {
    override fun getSessionInfo(): SessionInfo {
        return sessionInfoPrefs.getSessionInfo()
    }

    override fun setSessionInfo(sessionInfo: SessionInfo) {
        sessionInfoPrefs.setSessionInfo(sessionInfo)
    }
}