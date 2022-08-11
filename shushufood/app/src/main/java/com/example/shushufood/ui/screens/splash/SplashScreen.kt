package com.example.shushufood.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shushufood.R
import com.example.shushufood.navigation.NavigationTree

@Composable
fun SplashScreen(navController: NavController){
        Image(
            painter = painterResource(R.drawable.splash),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
    //Thread.sleep(3000)
   LaunchedEffect(key1 = Unit, block ={
        navController.navigate(NavigationTree.Login.name)//Main to Login when finish
    })
}
