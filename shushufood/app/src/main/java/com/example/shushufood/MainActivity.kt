package com.example.shushufood

import android.os.Bundle
import android.view.PixelCopy.request
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.produceState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shushufood.navigation.NavigationItem
import com.example.shushufood.ui.screens.*
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.ShushufoodTheme
import com.example.shushufood.utils.models.MenuResponseModel
import com.example.shushufood.utils.network.ApiService
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {





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
