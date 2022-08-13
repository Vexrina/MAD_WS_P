package com.example.shushufood.ui.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shushufood.R
import com.example.shushufood.ui.theme.AppTheme
import java.math.BigDecimal

@Composable
fun MenuCard(title: String, image_bmp: Bitmap, price: BigDecimal) {
    Box(modifier = Modifier
        .width(156.dp)
        .height(166.dp)
        .background(AppTheme.colors.headerTextColor)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.height(105.dp).width(140.dp).padding(top = 8.dp)
            ) {
                Image(
                    bitmap = image_bmp.asImageBitmap(),
                    "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Text(
                text = title,
                fontSize = 18.sp
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            Text(
                text = "$price",
                fontSize = 14.sp
            )
        }
    }
}