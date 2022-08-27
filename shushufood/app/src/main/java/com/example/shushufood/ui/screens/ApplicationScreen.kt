package com.example.shushufood.ui.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shushufood.navigation.NavigationTree
import com.example.shushufood.ui.screens.home.MenuItemScreen
import com.example.shushufood.ui.screens.login.LoginScreen
import com.example.shushufood.ui.screens.login.LoginViewModel
import com.example.shushufood.ui.screens.splash.SplashScreen

@Composable
fun ApplicationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTree.Splash.name) {
        composable(NavigationTree.Splash.name) { SplashScreen(navController) }
        composable(NavigationTree.Login.name) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(loginViewModel = loginViewModel, navController = navController)
        }
        composable("${NavigationTree.Main.name}/{username}") { backStackEntry ->
            MainScreen(backStackEntry.arguments?.getString("username").orEmpty())

        }
        composable(
            route = "${NavigationTree.MenuItem.name}/{menuItem_name}",
            arguments = listOf(
                navArgument("menuItem_name") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("menuItem_name").orEmpty()
            MenuItemScreen(menuItem =, cartViewModel =)
        }
    }

}