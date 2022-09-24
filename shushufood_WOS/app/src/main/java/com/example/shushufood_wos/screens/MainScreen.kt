package com.example.shushufood_wos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.*
import com.example.shushufood_wos.theme.WearAppColorPalette

@Composable
fun MainScreen(username: String) {
    val listState = rememberScalingLazyListState()
    Scaffold(
        timeText = {
            if (!listState.isScrollInProgress) {
                TimeText()
            }
        },
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        },
        positionIndicator = {
            PositionIndicator(
                scalingLazyListState = listState
            )

        },
        modifier = Modifier
            .background(WearAppColorPalette.primary)

    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 0),
            state = listState
        ) {
            item { OrderCard(title = "title", count = 1) }
            item { OrderCard(title = "title", count = 1) }
            item { OrderCard(title = "title", count = 1) }
        }
    }
}