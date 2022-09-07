package com.example.shushufood.ui.screens.menu_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shushufood.R
import com.example.shushufood.common.Cart
import com.example.shushufood.network.models.MenuResponseModel
import com.example.shushufood.ui.components.ItemCounter
import com.example.shushufood.utils.byteArrayToBmp


@Composable
fun MenuItemScreen(
    menuItem: MenuResponseModel
) {

    val viewState = Cart.cartItems.observeAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Image(
            bitmap = byteArrayToBmp(menuItem.image).asImageBitmap(),
            contentDescription = "product image"
        )
        Text(
            text = menuItem.name,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 8.dp)
        )




        if (viewState.value?.getOrDefault(menuItem, 0) == 0) {
            Button(onClick = {
                Cart.addItem(menuItem)
            }) {
                Text(
                    text = stringResource(id = R.string.add_item)
                )
            }
        } else {
            ItemCounter(
                count = viewState.value!!.getOrDefault(menuItem, 0),
                onDecreaseClicked = {
                    Cart.removeItem(menuItem)
//                    quantity -= 1
                },
                onIncreaseClicked = {
                    Cart.addItem(menuItem)
//                    quantity += 1
                }
            )
        }
        Button(onClick = {
            Cart.removeItem(menuItem = menuItem, true)
//            quantity = 0
        }) {
            Text(text = stringResource(id = R.string.remove_items))
        }
    }
//    LaunchedEffect(key1 = true) {
//        quantity = Cart.cartItems.value?.getOrDefault(menuItem, 0)!!
//    }

}


