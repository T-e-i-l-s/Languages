package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.mustafin.languages.core.ui.navigation.LessonCompletedScreen
import com.mustafin.languages.core.utils.lessonUtils.LessonModel
import com.mustafin.languages.core.utils.lessonUtils.LessonUnitType
import com.mustafin.languages.lessonFlow.data.repositories.lessonContentRepository.LessonContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/* Вью модель экрана прохождения урока */
@HiltViewModel
class LessonScreenViewModel @Inject constructor(
    private val lessonContentRepository: LessonContentRepository
) : ViewModel() {
    private val _lesson = MutableStateFlow<LessonModel?>(null)
    val lesson: StateFlow<LessonModel?> = _lesson

    private val _currentUnitIndex = MutableStateFlow(0)
    val currentUnitIndex: StateFlow<Int> = _currentUnitIndex

    private val _contentVisible = MutableStateFlow(true)
    val contentVisible: StateFlow<Boolean> = _contentVisible

    fun loadLessonData(lessonId: Int) {
        viewModelScope.launch {
            _lesson.value = lessonContentRepository.getLessonContentById(lessonId)
        }
    }

    fun openNextUnit(navController: NavController, resetSelection: () -> Unit = {}) {
        _lesson.value?.let { lesson ->
            viewModelScope.launch {
                if (lesson.stages[_currentUnitIndex.value].type == LessonUnitType.QUIZ) {
                    delay(200)
                } else {
                    delay(300)
                }

                _contentVisible.value = false

                if (_currentUnitIndex.value < lesson.stages.size - 1) {
                    delay(500)
                    resetSelection()
                    _currentUnitIndex.value++
                    _contentVisible.value = true
                } else {
                    navController.navigate(LessonCompletedScreen)
                }
            }
        }
    }
}