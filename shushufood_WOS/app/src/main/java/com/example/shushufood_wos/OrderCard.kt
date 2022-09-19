package com.example.shushufood_wos

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.PointerIconDefaults.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.example.shushufood_wos.theme.WearAppTheme

@Composable
fun OrderCard(
    title: String,
    count: Int,
    //image_bmb: Bitmap,
){
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(30.dp)
            //.background(WearAppTheme})
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        )
        {
            //Image(
              //  bitmap = image_bmb.asImageBitmap(),
            //    contentDescription = "",
                //modifier = Modifier.fillMaxSize()
          //  )
            Spacer(
                modifier = Modifier.width(8.dp)
            )
            Column{
                Text(
                    text = title,
                    fontSize = 10.sp
                )
                Text(
                    text = "$count pieces",
                    fontSize = 10.sp
                )
            }
        }
    }

}