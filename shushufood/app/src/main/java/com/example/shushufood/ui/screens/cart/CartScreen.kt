package com.example.shushufood.ui.screens.cart

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.shushufood.R

@Composable
fun CartScreen(
    cartViewmodel: CartViewModel
){


    Column() {
        LazyColumn(modifier = Modifier.fillMaxSize()){}

        Row(modifier = Modifier.fillMaxWidth()) {
            Box() {
                Text(
                    text = stringResource(id = R.string.paycheck_summ) + cartViewmodel.getTotalPrice()
                )
            }
            Box(modifier = Modifier.clickable { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.make_order)
                )
            }
        }
    }
}