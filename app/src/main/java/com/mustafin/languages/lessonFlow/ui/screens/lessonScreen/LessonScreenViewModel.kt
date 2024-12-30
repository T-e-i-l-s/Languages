package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.mustafin.languages.core.ui.navigation.LessonCompletedScreen
import com.mustafin.languages.core.utils.lessonUtils.LessonModel
import com.mustafin.languages.core.utils.lessonUtils.LessonUnitType
import com.mustafin.languages.core.utils.quizUtils.AnswerStatus
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
    companion object {
        const val DELAY_BETWEEN_UNITS = 600L
        const val DELAY_TO_SHOW_ANSWER = 900L
    }

    private val _lesson = MutableStateFlow<LessonModel?>(null)
    val lesson: StateFlow<LessonModel?> = _lesson

    private val _currentUnitIndex = MutableStateFlow(0)
    val currentUnitIndex: StateFlow<Int> = _currentUnitIndex

    private val _contentVisible = MutableStateFlow(true)
    val contentVisible: StateFlow<Boolean> = _contentVisible

    private val _quizAnswerStatus = MutableStateFlow(AnswerStatus.DEFAULT)
    val quizAnswerStatus: StateFlow<AnswerStatus> = _quizAnswerStatus

    fun loadLessonData(lessonId: Int) {
        viewModelScope.launch {
            _lesson.value = lessonContentRepository.getLessonContentById(lessonId)
        }
    }

    fun openNextUnit(navController: NavController) {
        _lesson.value?.let { lesson ->
            viewModelScope.launch {
                _contentVisible.value = false // Скрываем текущий юнит
                if (_currentUnitIndex.value < lesson.stages.size - 1) {
                    delay(DELAY_BETWEEN_UNITS) // Ждем скрытия
                    _currentUnitIndex.value++
                    _contentVisible.value = true // Показываем новый юнит
                } else {
                    navController.navigate(LessonCompletedScreen)
                }
            }
        }
    }

    fun onQuizAnswered(
        navController: NavController,
        isCorrect: Boolean
    ) {
        viewModelScope.launch {
            // Отображаем пользователю верен ли его ответ через интерфейс
            if (isCorrect) {
                _quizAnswerStatus.value = AnswerStatus.CORRECT
            } else {
                _quizAnswerStatus.value = AnswerStatus.INCORRECT
            }
            delay(DELAY_TO_SHOW_ANSWER)

            // Возвращаем интерфейс в стандартный вид и переключаем юнит
            _quizAnswerStatus.value = AnswerStatus.DEFAULT
            openNextUnit(navController)
        }
    }
}