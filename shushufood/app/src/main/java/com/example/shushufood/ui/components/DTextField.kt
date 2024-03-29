package com.example.shushufood.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.Inika
import com.example.shushufood.utils.PhoneNumberVisualTransformation

enum class TextVisuals {
    Text, Password, PhoneNumber
}

@Composable
fun DTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    enabled: Boolean = true,
//    secureText: Boolean = false,
    textVisuals: TextVisuals = TextVisuals.Text,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,

) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        placeholder = {
            Text(
                text = placeholder, fontFamily = Inika,
                style = TextStyle(
                    color = AppTheme.colors.primaryTextColor,
                    fontSize = 12.sp
                )

            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = AppTheme.colors.eclipseIndicatorColor1,
            errorIndicatorColor = AppTheme.colors.secondaryBackground,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        visualTransformation = when (textVisuals) {
            TextVisuals.Text -> VisualTransformation.None
            TextVisuals.Password -> PasswordVisualTransformation()
            TextVisuals.PhoneNumber -> PhoneNumberVisualTransformation()
        }
    )
}