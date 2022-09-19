package com.example.shushufood_wos

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import com.example.shushufood_wos.theme.WearAppColorPalette
import com.example.shushufood_wos.theme.WearAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    WearAppTheme {
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
                .background(WearAppColorPalette.error)

        ) {
            val contentModifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            val iconModifier = Modifier.size(24.dp).wrapContentSize(align = Alignment.Center)
            ScalingLazyColumn(
                modifier = Modifier.fillMaxSize(),
                autoCentering = AutoCenteringParams(itemIndex = 0),
                state = listState
            ) {
                item { OrderCard(title = "title", count = 1) }
                item { OrderCard(title = "title", count = 1) }
                item { OrderCard(title = "title", count = 1) }
//                item { TextExample(contentModifier) }
//                item { CardExample(contentModifier, iconModifier) }
//
//                /* ********************* Part 2: Wear unique composables ********************* */
//                item { ChipExample(contentModifier, iconModifier) }
//                item { ToggleChipExample(contentModifier) }
            }
        }
    }
}

