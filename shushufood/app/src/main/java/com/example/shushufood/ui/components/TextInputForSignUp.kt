package com.example.shushufood.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.Inika

@Composable
fun TextInputForSignUp(
    modifier: Modifier = Modifier,
    header: String,
    textFieldValue: String,
//    secureText: Boolean = false,
    enabled: Boolean = true,
    onTextFieldChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    textVisuals: TextVisuals = TextVisuals.Text,
    ) {
    Column(modifier = modifier)
    {
        Text(
            text = header,
            fontFamily = Inika,
            color = AppTheme.colors.primaryTextColor,
            fontWeight = FontWeight.Medium
        )
        DTextField(
            enabled = enabled,
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth()
                .height(50.dp),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            value = textFieldValue,
            onValueChange = onTextFieldChange,
            placeholder = header,
//            secureText = secureText,
            textVisuals = textVisuals
        )
    }
}