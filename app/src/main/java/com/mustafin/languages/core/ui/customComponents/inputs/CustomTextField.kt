package com.mustafin.languages.core.ui.customComponents.inputs

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.mustafin.languages.R

/* Функция с кастомной реализацией поля ввода */
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    readOnly: Boolean = false,
) {
    var isFocused by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = colorResource(id = R.color.content),
                style = MaterialTheme.typography.labelMedium
            )
        },
        isError = isError,

        textStyle = MaterialTheme.typography.labelMedium,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = colorResource(id = R.color.gray),
            focusedTextColor = colorResource(id = R.color.content),
            errorTextColor = colorResource(id = R.color.content),
            cursorColor = colorResource(id = R.color.additional),
            focusedContainerColor = colorResource(id = R.color.secondary_background),
            unfocusedContainerColor = colorResource(id = R.color.secondary_background),
            errorContainerColor = colorResource(id = R.color.secondary_background),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedPlaceholderColor = colorResource(id = R.color.gray),
            focusedPlaceholderColor = colorResource(id = R.color.gray),
            errorPlaceholderColor = colorResource(id = R.color.gray)
        ),

        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { isFocused = it.isFocused }
            .border(
                2.dp,
                when {
                    isError -> colorResource(id = R.color.red)
                    isFocused -> colorResource(id = R.color.additional)
                    else -> Color.Transparent
                },
                shape = RoundedCornerShape(8.dp)
            ),

        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        readOnly = readOnly
    )
}

@Preview
@Composable
private fun CustomTextFieldPreview() {
    val mockText = LoremIpsum(2).values.first()

    // Пустое поле ввода
    CustomTextField(
        value = "",
        onValueChange = {},
        placeholder = mockText
    )

    // Поле ввода со текстом
    CustomTextField(
        value = mockText,
        onValueChange = {},
        placeholder = mockText
    )
}