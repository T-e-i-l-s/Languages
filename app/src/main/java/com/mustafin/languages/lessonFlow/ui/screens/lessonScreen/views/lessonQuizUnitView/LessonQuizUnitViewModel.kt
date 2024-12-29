package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen.views.lessonQuizUnitView

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/* Вью модель блока теста */
class LessonQuizUnitViewModel: ViewModel() {
    private val _selectedAnswerIndex = MutableStateFlow<Int?>(null)
    val selectedAnswerIndex: StateFlow<Int?> = _selectedAnswerIndex

    fun selectAnswer(index: Int) {
        _selectedAnswerIndex.value = index
    }
}