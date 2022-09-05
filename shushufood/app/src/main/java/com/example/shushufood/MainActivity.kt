package com.example.shushufood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.example.shushufood.ui.screens.ApplicationScreen
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.ShushufoodTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


//    val db = Room.databaseBuilder(
//        applicationContext,
//        AppDatabase::class.java, "app_db"
//    ).build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ShushufoodTheme {
                val systemUiController = rememberSystemUiController()
                val primaryBackground = AppTheme.colors.primaryBackground

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = primaryBackground,
                        darkIcons = true
                    )
                }
                ApplicationScreen()
            }
        }
    }
}
