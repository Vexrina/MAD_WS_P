package com.example.shushufood.ui.screens.login.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shushufood.R
import com.example.shushufood.ui.components.TextInput
import com.example.shushufood.ui.components.TextVisuals
import com.example.shushufood.ui.screens.login.models.LoginViewState
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.Inika

@Composable
fun SignInView(
    viewState: LoginViewState,
    onLoginFieldChange: (String) -> Unit,
    onPasswordFieldChange: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit,
    onForgetClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    Column(modifier = Modifier.fillMaxSize()) {
        TextInput(
            modifier = Modifier.padding(top = 20.dp),
            header = stringResource(id = R.string.email_hint),
            textFieldValue = viewState.emailValue,
            enabled = !viewState.isProgress,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            onTextFieldChange = {
                if (!viewState.isProgress) onLoginFieldChange.invoke(it)
            },
        )
        TextInput(
            modifier = Modifier.padding(top = 10.dp),
            header = stringResource(id = R.string.password_hint),
            textFieldValue = viewState.passwordValue,
            onTextFieldChange = {
                if (!viewState.isProgress) onPasswordFieldChange.invoke(it)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            secureText = true,
            textVisuals = TextVisuals.Password,
            enabled = !viewState.isProgress
        )
        Row(
            modifier = Modifier.padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                enabled = !viewState.isProgress,
                checked = viewState.rememberMeChecked,
                onCheckedChange = onCheckedChange,
                colors = CheckboxDefaults.colors(
                    checkedColor = AppTheme.colors.actionTextColor,
                )
            )

            Spacer(modifier = Modifier.width(0.dp))

            Text(text = stringResource(id = R.string.remember_check_title), fontFamily = Inika)

            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = if (viewState.isProgress) Modifier else Modifier.clickable(onClick = onForgetClick),
                fontFamily = Inika,
                text = stringResource(id = R.string.sign_in_forget),
            )
        }

        Button(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(58.dp),
            onClick = {
                if (!viewState.isProgress)
                    onLoginClick.invoke()
            },
            shape = RoundedCornerShape(size = 20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AppTheme.colors.primaryTextColor
            )
        ) {
            if (viewState.isProgress) {
                CircularProgressIndicator(
                    strokeWidth = 2.dp,
                    color = AppTheme.colors.actionTextColor
                )
            } else {
                Text(
                    text = stringResource(id = R.string.action_login),
                    fontWeight = FontWeight.Medium,
                    color = AppTheme.colors.primaryBackground,
                    style = TextStyle(fontSize = 35.sp),
                    fontFamily = Inika,
                )
            }
        }
    }
}