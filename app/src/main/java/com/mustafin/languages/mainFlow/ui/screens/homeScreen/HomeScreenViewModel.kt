package com.mustafin.languages.mainFlow.ui.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafin.languages.core.utils.LoadingState
import com.mustafin.languages.core.utils.languageUtils.ShortLanguageModel
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel
import com.mustafin.languages.mainFlow.data.repositories.languagesRepository.LanguagesRepository
import com.mustafin.languages.mainFlow.data.repositories.lessonsRepository.LessonsRepository
import com.mustafin.languages.mainFlow.data.repositories.sessionInfoRepository.SessionInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/* Вью модель главного экрана */
@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val sessionInfoRepository: SessionInfoRepository,
    private val languagesRepository: LanguagesRepository,
    private val lessonsRepository: LessonsRepository
) : ViewModel() {
    private val _languageId = MutableStateFlow<Int?>(null)
    private val _language = MutableStateFlow<ShortLanguageModel?>(null)
    val language: StateFlow<ShortLanguageModel?> = _language

    private val _lessons = MutableStateFlow(emptyList<ShortLessonModel>())
    val lessons: StateFlow<List<ShortLessonModel>> = _lessons

    init {
        viewModelScope.launch {
            // Получаем информацию о последней сессии пользователя
            val sessionInfo = sessionInfoRepository.getSessionInfo()
            _languageId.value = sessionInfo.languageId

            val currentLanguageId = requireNotNull(sessionInfo.languageId) {
                return@launch
            }

            // Загружаем основной контент
            _language.value = languagesRepository.getLanguageById(currentLanguageId)
            _lessons.value = lessonsRepository.getLessonsByLanguageId(currentLanguageId)
        }
    }
}