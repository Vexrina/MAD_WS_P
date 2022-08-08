package com.example.shushufood.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.shushufood.BottomNavigationBar
import com.example.shushufood.Navigation
import com.example.shushufood.TopBar
import com.example.shushufood.ui.theme.AppTheme

@Composable
fun MainScreen(username: String){
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = AppTheme.colors.systemButtonsColor
    ) // Set background color to avoid the white flashing when you switch between screens

}