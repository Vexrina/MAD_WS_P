package com.example.shushufood_wos.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.wear.compose.material.Text
import com.example.shushufood_wos.theme.WearAppColorPalette

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    header: String,
    textFieldValue: String,
    textVisuals : TextVisuals = TextVisuals.Text,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enabled: Boolean = true,
    onTextFieldChange: (String) -> Unit
) {
    Column(modifier = modifier)
    {
        Text(
            text = header,
            color = WearAppColorPalette.primaryVariant,
            fontWeight = FontWeight.Medium
        )
        DTextField(
            enabled = enabled,
            modifier = Modifier,
            value = textFieldValue,
            textVisuals = textVisuals,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            onValueChange = onTextFieldChange,
            placeholder = header,
        )
    }
}