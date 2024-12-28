package com.mustafin.languages.mainFlow.data.repositories

import com.mustafin.languages.core.utils.sessionUtils.SessionInfo

interface SessionInfoRepository {
    fun getSessionInfo(): SessionInfo
    fun setSessionInfo(sessionInfo: SessionInfo)
}