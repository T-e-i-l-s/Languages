package com.mustafin.languages.lessonFlow.ui.screens.lessonCompletedScreen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mustafin.languages.R
import com.mustafin.languages.core.ui.navigation.HomeScreen
import com.mustafin.languages.lessonFlow.ui.screens.lessonCompletedScreen.views.LessonCompletedCheckView

/* Экран, который открывается после завершения урока */
@Composable
fun LessonCompletedScreenView(navController: NavController) {
    var gradientShiftValue by remember { mutableFloatStateOf(-5f) }
    val gradientShift by animateFloatAsState(
        targetValue = gradientShiftValue,
        animationSpec = tween(1500), label = ""
    )

    var tapToContinueTextOpacityValue by remember { mutableFloatStateOf(0f) }
    val tapToContinueTextOpacity by animateFloatAsState(
        targetValue = tapToContinueTextOpacityValue,
        animationSpec = tween(3000), label = ""
    )

    LaunchedEffect(Unit) {
        gradientShiftValue = 0f
        tapToContinueTextOpacityValue = 1f
    }

    Box(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                navController.navigate(HomeScreen)
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            colorResource(id = R.color.additional).copy(alpha = 0.7f),
                            colorResource(id = R.color.background)
                        ),
                        startY = gradientShift * 1000
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LessonCompletedCheckView()

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(id = R.string.lesson_completed),
                style = MaterialTheme.typography.titleMedium,
                color = colorResource(id = R.color.content)
            )

            Spacer(modifier = Modifier.height(12.dp))

        }

        Text(
            text = stringResource(id = R.string.tap_to_continue),
            style = MaterialTheme.typography.labelSmall,
            color = colorResource(id = R.color.gray),
            modifier = Modifier
                .navigationBarsPadding()
                .padding(bottom = 24.dp)
                .align(Alignment.BottomCenter)
                .alpha(tapToContinueTextOpacity)
        )
    }
}