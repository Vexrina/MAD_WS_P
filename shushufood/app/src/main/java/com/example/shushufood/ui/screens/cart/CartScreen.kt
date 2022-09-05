package com.example.shushufood.ui.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shushufood.R
import com.example.shushufood.common.Cart
import com.example.shushufood.ui.screens.cart.models.CartEvent
import com.example.shushufood.utils.byteArrayToBmp
import java.math.BigDecimal

@Composable
fun CartScreen(
    cartViewModel: CartViewModel,
//    cartProducts: Map<MenuResponseModel, Int>?
) {

    val viewState = Cart.cartItems.observeAsState()


    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            viewState.value?.forEach {
                item {
                    Row(
                        modifier = Modifier.fillParentMaxWidth().weight(1f)
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Image(
                                bitmap = byteArrayToBmp(it.key.image).asImageBitmap(),
                                contentDescription = null
                            )
                            Text(text = it.key.name)
                            Text(text = it.key.price.toString())
                        }
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = stringResource(id = R.string.quantity) + "${it.value}")
                            Text(text = stringResource(id = R.string.price) + "${BigDecimal(it.value) * it.key.price}")
                            Row {
                                Button(onClick = {
                                    cartViewModel.obtainEvent(
                                        CartEvent.DecreaseItemCount(
                                            it.key
                                        )
                                    )
                                }) {
                                    Text(text = "-")
                                }
                                Button(onClick = {
                                    cartViewModel.obtainEvent(
                                        CartEvent.IncreaseItemCount(
                                            it.key
                                        )
                                    )
                                }) {
                                    Text(text = "+")
                                }
                            }
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.paycheck_summ) + Cart.cartTotalPrice,
                )
            }
            Box(
                modifier = Modifier
                    .clickable { /*TODO*/ }
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.make_order),
                )
            }
        }
    }
}

