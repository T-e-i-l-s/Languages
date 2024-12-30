package com.mustafin.languages.mainFlow.ui.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel
import com.mustafin.languages.core.data.repositories.lessonsRepository.LessonsRepository
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
    private val lessonsRepository: LessonsRepository
) : ViewModel() {
    private val _selectedLanguageId = MutableStateFlow<Int?>(null)
    val selectedLanguageId: StateFlow<Int?> = _selectedLanguageId

    private val _lessons = MutableStateFlow(emptyList<ShortLessonModel>())
    val lessons: StateFlow<List<ShortLessonModel>> = _lessons

    init {
        viewModelScope.launch {
            _selectedLanguageId.value = sessionInfoRepository.getSessionLanguage()
            loadLessons()
        }
    }

    fun updateSessionLanguage(languageId: Int) {
        viewModelScope.launch {
            sessionInfoRepository.setSessionLanguage(languageId)
            _selectedLanguageId.value = languageId
            loadLessons()
        }
    }

    private fun loadLessons() {
        _selectedLanguageId.value?.let {
            _lessons.value = lessonsRepository.getLessonsByLanguageId(it)
        }
    }
}