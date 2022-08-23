package com.example.shushufood.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shushufood.R
import com.example.shushufood.navigation.NavigationTree
import com.example.shushufood.ui.screens.login.models.LoginAction
import com.example.shushufood.ui.screens.login.models.LoginEvent
import com.example.shushufood.ui.screens.login.models.LoginSubState
import com.example.shushufood.ui.screens.login.models.LoginViewState
import com.example.shushufood.ui.screens.login.views.ForgotView
import com.example.shushufood.ui.screens.login.views.SignInView
import com.example.shushufood.ui.screens.login.views.SignUpView
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.Inika
import com.example.shushufood.utils.network.ApiService
import androidx.compose.material.Text as Text

private val apiService by lazy {
    ApiService.create()
}

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    navController: NavController
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
                    ), textAlign = TextAlign.Center,
                    fontFamily = Inika,
                    modifier = Modifier.padding(start = 65.dp)
                )
            }
            item {
                    Text(
                        text = when (loginSubState) {
                            LoginSubState.SignIn -> stringResource(id = R.string.sign_in_title)
                            LoginSubState.SignUp -> stringResource(id = R.string.sign_up_title)
                            LoginSubState.Forgot -> stringResource(id = R.string.forgot_title)
                        }
                        ,
                        fontFamily = Inika,
                        style = TextStyle(
                        color = AppTheme.colors.primaryTextColor,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp
                        )
                    )
                }
            item{
                Row(modifier = Modifier.padding(top = 0.dp)){
                    Text(
                        text = when (loginSubState) {
                            LoginSubState.SignIn -> stringResource(id = R.string.sign_in_subtitle)
                            LoginSubState.SignUp -> stringResource(id = R.string.sign_up_subtitle)
                            LoginSubState.Forgot -> stringResource(id = R.string.forgot_subtitle)
                        },
                        fontFamily = Inika,
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
                            fontFamily = Inika,
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
                        onLoginFieldChange = {
                            loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                        },
                        onPasswordFieldChange = {
                            loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it))
                        },
                        onCheckedChange = {
                            loginViewModel.obtainEvent(LoginEvent.CheckboxClicked(it))
                        },
                        onForgetClick = {
                            loginViewModel.obtainEvent(LoginEvent.ForgetClicked)
                        },
                        onLoginClick = {
                            loginViewModel.obtainEvent(LoginEvent.LoginClicked)
                        },
                    )
                    LoginSubState.SignUp -> SignUpView(
                        viewState = this@with,
                        onEmailFieldChange = {
                            loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                        },
                        onPasswordFieldChange = {
                            loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it))
                        },
                        onFullNameFieldChange =  {
                            loginViewModel.obtainEvent(LoginEvent.FullNameChanged(it))
                        },
                        onPhoneNumberFieldChange =  {
                            loginViewModel.obtainEvent(LoginEvent.PhoneNumberChanged(it))
                        },
                        onRegisterClick = {
                            loginViewModel.obtainEvent(LoginEvent.LoginClicked)
                        },
                    )
                    LoginSubState.Forgot -> ForgotView()
                }
            }
        }
    }
    LaunchedEffect(key1 = viewState.value.loginAction){
        when (val action = viewState.value.loginAction){
            is LoginAction.OpenDashBoard -> {
                navController.navigate("${NavigationTree.Main.name}/${action.username}"){
                    popUpTo(NavigationTree.Login.name)
                }
            }
        }
    }
    DisposableEffect(key1 = Unit, effect ={
        onDispose {
            loginViewModel.obtainEvent(LoginEvent.LoginClicked)
        }
    } )

}