package com.example.shushufood.ui.screens.home.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shushufood.R
import com.example.shushufood.ui.theme.AppTheme

@Composable
fun FailedView(
    onRetryClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
    {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_failure),
            contentDescription = "sad smile icon",
            tint = AppTheme.colors.primaryTextColor,
            modifier = Modifier.size(128.dp)
        )

        Text(
            text = "Failed to load menu",
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            modifier = Modifier.padding(8.dp),
            onClick = onRetryClicked
        ) {
            Text(
                text = "Retry",
            )
        }
    }
}