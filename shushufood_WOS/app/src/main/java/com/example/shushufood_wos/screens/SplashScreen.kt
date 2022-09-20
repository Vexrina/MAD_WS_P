package com.example.shushufood_wos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController) {
    Image(
        painter = painterResource(R.drawable.wos_logo),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    //Thread.sleep(3000)
    LaunchedEffect(key1 = Unit, block = {
        navController.navigate(NavigationTree.Main.name)
    })
}