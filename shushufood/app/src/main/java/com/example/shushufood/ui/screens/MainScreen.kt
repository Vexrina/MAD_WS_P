package com.example.shushufood.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.rememberNavController
import com.example.shushufood.ui.components.BottomNavigationBar
import com.example.shushufood.ui.components.Navigation
import com.example.shushufood.ui.components.TextSearch
import com.example.shushufood.ui.components.TopBar
import com.example.shushufood.ui.screens.login.models.LoginViewState
import com.example.shushufood.ui.screens.menu_search.models.SearchView
import com.example.shushufood.ui.screens.menu_search.models.SearchViewState
import com.example.shushufood.ui.theme.AppTheme

@Composable
fun MainScreen(username: String){
    val navController = rememberNavController()
    //var viewState by remember { mutableStateOf(SearchViewState()) }
    Scaffold(

//        topBar = { TopBar{
//                Row{
//
//                }
//
//            }
//                 },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.

            Box(modifier = Modifier.padding(padding)) {

                Navigation(navController = navController)
            }
        },
        backgroundColor = AppTheme.colors.primaryBackground
    ) // Set background color to avoid the white flashing when you switch between screens

}