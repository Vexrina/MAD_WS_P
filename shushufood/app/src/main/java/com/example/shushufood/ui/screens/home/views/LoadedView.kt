package com.example.shushufood.ui.screens.home.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shushufood.network.models.MenuResponseModel
import com.example.shushufood.ui.components.MenuCard
import com.example.shushufood.ui.screens.home.models.HomeViewState
import com.example.shushufood.utils.byteArrayToBmp

@Composable
fun LoadedView(
    viewState: HomeViewState,
    products: List<MenuResponseModel>?
) {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(all = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .fillMaxSize()
    )
    {
        products?.let {
            items(it.filter { product ->
                product.name.contains(viewState.searchValue, ignoreCase = true) }
            ) { product ->
                MenuCard(
                    title = product.name,
                    image_bmp = byteArrayToBmp(product.image),
                    price = product.price
                )
            }
        }
    }
}