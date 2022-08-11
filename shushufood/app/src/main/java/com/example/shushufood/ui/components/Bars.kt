package com.example.shushufood.ui.components

import android.widget.SearchView
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shushufood.navigation.NavigationItem
import com.example.shushufood.ui.screens.CartScreen
import com.example.shushufood.ui.screens.HomeScreen
import com.example.shushufood.ui.screens.ProfileScreen
import com.example.shushufood.ui.screens.RecentScreen
import com.example.shushufood.ui.theme.AppTheme


@Composable
fun TopBar(content: @Composable RowScope.() -> Unit){
    TopAppBar(
        backgroundColor = AppTheme.colors.primaryBackground,
        contentColor = Color.White,
        content = content
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Cart,
        NavigationItem.Recent,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = AppTheme.colors.primaryBackground,
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Recent.route) {
            RecentScreen()
        }
        composable(NavigationItem.Cart.route) {
            CartScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun SearchView(state: MutableLiveData<TextFieldValue>){

}