package com.example.shushufood.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shushufood.R
import com.example.shushufood.network.models.MenuResponseModel
import com.example.shushufood.ui.screens.cart.CartViewModel
import com.example.shushufood.utils.byteArrayToBmp

@Composable
fun MenuItemScreen(
    menuItem: MenuResponseModel,
    cartViewModel: CartViewModel
) {

    val context = LocalContext.current
//    val viewState = menuItemViewModel.viewState.observeAsState(MenuItemViewState())

//    with(viewState.value) {
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

        Button(onClick = {
            Toast.makeText(context, "${menuItem.name} added to your cart", Toast.LENGTH_SHORT)

        }) {
            Text(
                text = stringResource(id = R.string.add_item)
            )
        }
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = stringResource(id = R.string.remove_items))
//        }
//        }
    }
}

