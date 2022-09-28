package com.example.shushufood.ui.screens.menu_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.example.shushufood.network.models.menuorders.MenuResponseModel
import com.example.shushufood.ui.components.ItemCounter
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.Inika
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
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 16.dp),
            fontFamily = Inika,
            color = AppTheme.colors.primaryTextColor
        )




        if (viewState.value?.getOrDefault(menuItem, 0) == 0) {
            Button(
                onClick = {
                    Cart.addItem(menuItem)
                    },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .height(60.dp)
                    .width(180.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primaryTextColor),

            ) {
                Text(
                    text = stringResource(id = R.string.add_item),
                    color = AppTheme.colors.primaryBackground,
                    fontSize = 24.sp,
                    fontFamily = Inika,
                )
            }
        } else {
            ItemCounter(
                count = viewState.value!!.getOrDefault(menuItem, 0),
                onDecreaseClicked = {
                    Cart.removeItem(menuItem)
                },
                onIncreaseClicked = {
                    Cart.addItem(menuItem)
                }
            )
        }
        Button(
            onClick = {
                Cart.removeItem(menuItem = menuItem, true)
                },
            modifier = Modifier
                .padding(top = 20.dp)
                .height(60.dp)
                .width(180.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primaryTextColor),
        ) {
            Text(
                text = stringResource(id = R.string.remove_items),
                color = AppTheme.colors.primaryBackground,
                fontSize = 24.sp,
                fontFamily = Inika,
            )
        }
    }

}


