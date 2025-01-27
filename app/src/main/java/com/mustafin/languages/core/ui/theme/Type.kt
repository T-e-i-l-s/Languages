package com.mustafin.languages.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mustafin.languages.R

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.geologica)),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp
    ),

    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.geologica)),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),

    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.geologica)),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),

    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.geologica)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),

    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.geologica)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )
)
