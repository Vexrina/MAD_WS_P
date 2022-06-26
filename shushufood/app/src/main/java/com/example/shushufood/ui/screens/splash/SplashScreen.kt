package com.example.shushufood.ui.screens.splash

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.shushufood.navigation.NavigationTree

@Composable
fun SplashScreen(navController: NavController){

    LaunchedEffect(key1 = Unit, block ={
        navController.navigate(NavigationTree.Login.name)
    })
}