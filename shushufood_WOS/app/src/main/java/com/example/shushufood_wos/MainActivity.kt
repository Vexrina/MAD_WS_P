package com.example.shushufood_wos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.shushufood_wos.screens.loginsUtils.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    val navController = rememberSwipeDismissableNavController()
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = "${NavigationTree.Splash.name}"
    ) {
        composable(NavigationTree.Splash.name) { SplashScreen(navController) }
        composable(NavigationTree.Login.name) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(loginViewModel = loginViewModel, navController = navController)
        }
        composable(NavigationTree.Main.name) {
            MainScreen()
        }
    }
}
//
//@Composable
//fun WearApp() {
//    WearAppTheme {
//
//    }
//}

