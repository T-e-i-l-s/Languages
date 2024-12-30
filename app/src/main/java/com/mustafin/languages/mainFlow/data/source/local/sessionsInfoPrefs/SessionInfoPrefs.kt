package com.mustafin.languages.mainFlow.data.source.local.sessionsInfoPrefs

import android.content.SharedPreferences
import androidx.core.content.edit
import com.mustafin.languages.core.utils.sessionUtils.SessionInfo
import javax.inject.Inject

/* Класс для хранения данных о сессии(язык, который изучал пользователь) */
class SessionInfoPrefs @Inject constructor(
    private val sharedPrefs: SharedPreferences
) {
    companion object {
        const val LANGUAGE_KEY = "session_language_id"
    }

    private var languageId: Int
        get() = sharedPrefs.getInt(LANGUAGE_KEY, 0)
        set(value) = sharedPrefs.edit { putInt(LANGUAGE_KEY, value) }

    fun getSessionLanguage(): Int {
        return languageId
    }

    fun setSessionLanguage(newLanguageId: Int) {
        languageId = newLanguageId
    }
}