package com.example.shushufood_wos.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.shushufood_wos.LoginScreen
import com.example.shushufood_wos.MainScreen
import com.example.shushufood_wos.NavigationTree
import com.example.shushufood_wos.SplashScreen
import com.example.shushufood_wos.screens.loginsUtils.LoginViewModel


@Composable
fun ApplicationScreen() {
    val navController = rememberSwipeDismissableNavController()
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = NavigationTree.Login.name
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