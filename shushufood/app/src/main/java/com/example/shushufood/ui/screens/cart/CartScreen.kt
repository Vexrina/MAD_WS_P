package com.example.shushufood.ui.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shushufood.R
import com.example.shushufood.common.Cart
import com.example.shushufood.ui.screens.cart.models.CartEvent
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.Inika
import com.example.shushufood.utils.byteArrayToBmp
import java.math.BigDecimal

@Composable
fun CartScreen(
    cartViewModel: CartViewModel,
//    cartProducts: Map<MenuResponseModel, Int>?
) {

    val cartState = Cart.cartItems.observeAsState()


    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            cartState.value?.toList()?.sortedBy { it.first.category }?.toMap()?.forEach {
                item {
                    Row(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .weight(1f)
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Image(
                                bitmap = byteArrayToBmp(it.key.image).asImageBitmap(),
                                modifier = Modifier
                                    .padding(start = 20.dp),
                                contentDescription = null

                            )
                            Text(
                                text = it.key.name,
                                color = AppTheme.colors.primaryTextColor,
                                fontFamily = Inika,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 20.dp)
                            )
                            Text(
                                text = it.key.price.toString(),
                                color = AppTheme.colors.primaryTextColor,
                                fontFamily = Inika,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 4.dp)
                            )
                        }
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = stringResource(id = R.string.quantity) + "${it.value}",
                                color = AppTheme.colors.primaryTextColor,
                                fontFamily = Inika,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(
                                        end = 20.dp, start = 28.dp
                                    )
                            )
                            Text(
                                text = stringResource(id = R.string.price) + "${BigDecimal(it.value) * it.key.price}",
                                color = AppTheme.colors.primaryTextColor,
                                fontFamily = Inika,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(
                                        end = 20.dp, start = 28.dp
                                    )
                            )
                            Row {
                                Button(
                                    onClick = {
                                        cartViewModel.obtainEvent(
                                            CartEvent.DecreaseItemCount(
                                                it.key
                                            )
                                        )
                                    },
                                    modifier = Modifier
                                        .padding(start = 20.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = AppTheme.colors.primaryTextColor
                                    )
                                ) {
                                    Text(
                                        text = "-",
                                        fontSize = 16.sp,
                                        fontFamily = Inika,
                                        fontWeight = Bold,
                                        color = AppTheme.colors.primaryBackground
                                    )
                                }
                                Button(
                                    onClick = {
                                        cartViewModel.obtainEvent(
                                            CartEvent.IncreaseItemCount(
                                                it.key
                                            )
                                        )
                                    },
                                    modifier = Modifier
                                        .padding(end = 24.dp, start = 16.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = AppTheme.colors.primaryTextColor
                                    )
                                ) {
                                    Text(
                                        text = "+",
                                        fontSize = 16.sp,
                                        fontFamily = Inika,
                                        fontWeight = Bold,
                                        color = AppTheme.colors.primaryBackground
                                    )
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
                .align(Alignment.CenterHorizontally)
            //    .border(BorderStroke(2.dp, SolidColor(Color.Black)))
            ,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.paycheck_summ) + cartState.value?.toList()
                        ?.map {
                            it.first.price * BigDecimal(it.second)
                        }?.sum(),
                    color = AppTheme.colors.primaryTextColor,
                    fontSize = 24.sp,
                    fontFamily = Inika,
                    fontWeight = Bold,
                )
            }
            Box(
                modifier = Modifier
                    .clickable { cartViewModel.obtainEvent(CartEvent.MakeOrderClicked) }
                    .weight(1f)
                    .fillMaxHeight()
                    .background(color = AppTheme.colors.primaryTextColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.make_order),
                    color = AppTheme.colors.primaryBackground,
                    fontSize = 24.sp,
                    fontFamily = Inika,
                    fontWeight = Bold,
                )
            }
        }
    }
}

private fun List<BigDecimal>.sum(): BigDecimal {
    var sum = BigDecimal(0)
    this.forEach {
        sum += it
    }
    return sum
}

