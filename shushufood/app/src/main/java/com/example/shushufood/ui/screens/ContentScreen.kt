package com.example.shushufood.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shushufood.ui.components.MenuCard
import com.example.shushufood.ui.components.TextSearch
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.utils.ByteArrayToBmp
import com.example.shushufood.utils.models.MenuResponseModel
import com.example.shushufood.utils.network.ApiService
import kotlinx.coroutines.launch


private val apiService by lazy {
    ApiService.create()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {//searchViewModel: SearchViewModel) {
    var queryInput by rememberSaveable() { mutableStateOf("") }

//    var products = produceState(
//        initialValue = emptyList<MenuResponseModel>(),
//        producer = {
//            value = apiService.getProducts(queryInput)
//        }
//    )
//
    var products by rememberSaveable() { mutableStateOf<List<MenuResponseModel>?>(value = null)}

//    val viewState = searchViewModel.viewState.observeAsState(SearchViewState())
    // with(viewState.value){
    Column {
        TextSearch(
            query = queryInput,
            onQueryChange = {
                queryInput = it
                            },
            placeholder = "Поиск по меню...",
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(all = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .fillMaxSize()
        )
        {
            products?.let {
                items(it) { product ->
                    MenuCard(
                        title = product.name,
                        image_bmp = ByteArrayToBmp(product.image),
                        price = product.price
                    )
                }
            }
        }
        LaunchedEffect(queryInput){
            products = apiService.getProducts(queryInput)
        }
    }
}

@Composable
fun CartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.primaryBackground)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Cart Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun RecentScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.primaryBackground)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "RecentScreen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.primaryBackground)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "ProfileScreen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}
