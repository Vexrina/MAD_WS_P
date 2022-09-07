package com.example.shushufood.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ItemCounter(
    count: Int,
    onDecreaseClicked: () -> Unit,
    onIncreaseClicked: () -> Unit,
) {

    Row {
        Button(onClick = onDecreaseClicked) {
            Text(text = "-")
        }
        Text(
            text = count.toString()
        )
        Button(onClick = onIncreaseClicked) {
            Text(text = "+")
        }
    }
}