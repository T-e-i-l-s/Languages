package com.mustafin.languages.lessonFlow.ui.screens.lessonCompletedScreen.views

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mustafin.languages.R

/* View галочки на экране завершения урока */
@Composable
fun LessonCompletedCheckView() {
    var checkContainerSizeValue by remember { mutableStateOf(40.dp) }
    val checkContainerSize by animateDpAsState(
        targetValue = checkContainerSizeValue,
        label = "",
        animationSpec = tween(1500)
    )

    var checkSizeValue by remember { mutableStateOf(20.dp) }
    val checkSize by animateDpAsState(
        targetValue = checkSizeValue,
        label = "",
        animationSpec = tween(2500)
    )

    LaunchedEffect(Unit) {
        checkContainerSizeValue = 100.dp
        checkSizeValue = 75.dp
    }

    Box(
        modifier = Modifier
            .size(checkContainerSize)
            .clip(CircleShape)
            .background(colorResource(id = R.color.additional))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.check_icon),
            contentDescription = null,
            tint = colorResource(id = R.color.white),
            modifier = Modifier
                .align(Alignment.Center)
                .size(checkSize)
        )
    }
}
