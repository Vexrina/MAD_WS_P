package com.example.shushufood.ui.screens.login

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shushufood.R
import com.example.shushufood.ui.screens.login.models.LoginEvent
import com.example.shushufood.ui.screens.login.models.LoginSubState
import com.example.shushufood.ui.screens.login.models.LoginViewState
import com.example.shushufood.ui.screens.login.views.ForgotView
import com.example.shushufood.ui.screens.login.views.SignInView
import com.example.shushufood.ui.screens.login.views.SignUpView
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.AppTheme.colors
import androidx.compose.material.Text as Text


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel
) {
    val viewState = loginViewModel.viewState.observeAsState(LoginViewState())
    with(viewState.value) {
        LazyColumn(
            modifier = Modifier
                .background(AppTheme.colors.primaryBackground)
                .fillMaxSize(),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            item {
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.logo),
                    "",
                    modifier = Modifier
                        .heightIn(min = 200.dp, max = 250.dp)
                        .padding(top = 20.dp)
                        .widthIn(min = 100.dp, max = 400.dp)
                        .fillMaxSize()
                )
                Text(
                    text = "Shushu Food!", style = TextStyle(
                        AppTheme.colors.primaryTextColor,
                        fontSize = 40.sp
                    ), textAlign = TextAlign.Center, fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(start = 65.dp)
                )
            }
            item {
                    Text(
                        text = when (loginSubState) {
                            LoginSubState.SignIn -> stringResource(id = R.string.sign_in_title)
                            LoginSubState.SignUp -> stringResource(id = R.string.sign_up_title)
                            LoginSubState.Forgot -> stringResource(id = R.string.forgot_title)
                        }, style = TextStyle(
                            color = AppTheme.colors.primaryTextColor,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp
                        )
                    )
                }
            item{
                Row(modifier = Modifier.padding(top = 12.dp)){
                    Text(
                        text = when (loginSubState) {
                            LoginSubState.SignIn -> stringResource(id = R.string.sign_in_subtitle)
                            LoginSubState.SignUp -> stringResource(id = R.string.sign_up_subtitle)
                            LoginSubState.Forgot -> stringResource(id = R.string.forgot_subtitle)
                        },
                        style = TextStyle(
                            color = AppTheme.colors.primaryTextColor,
                            fontStyle = FontStyle.Italic
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    if (loginSubState != LoginSubState.Forgot) {
                        Text(
                            modifier = Modifier.clickable {
                                loginViewModel.obtainEvent(LoginEvent.ActionClicked)
                            },
                            text = when (loginSubState) {
                                LoginSubState.SignIn -> stringResource(id = R.string.sign_in_action)
                                LoginSubState.SignUp -> stringResource(id = R.string.sign_up_action)
                                else -> ""
                            },
                            style = TextStyle(
                                color = AppTheme.colors.actionTextColor,
                                fontStyle = FontStyle.Italic
                            )
                        )
                    }


                }
            }
            item{
                when(loginSubState){
                    LoginSubState.SignIn -> SignInView(
                        viewState = this@with,
                        onTextFieldChange = {
                            loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                        }
                    )
                    LoginSubState.SignUp -> SignUpView()
                    LoginSubState.Forgot -> ForgotView()
                }
            }
        }
    }
}