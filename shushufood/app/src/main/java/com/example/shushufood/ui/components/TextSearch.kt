package com.example.shushufood.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon

import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import com.example.shushufood.R
import com.example.shushufood.ui.theme.AppTheme
import com.example.shushufood.ui.theme.Inika

@Composable
fun TextSearch(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String,
){
    TextField(
        value =query,
        onValueChange = onQueryChange,
        placeholder = {
            Text(
                text = placeholder,
                fontFamily = Inika,
                style = TextStyle(
                    color = AppTheme.colors.primaryTextColor,
                    fontSize = 16.sp
                )

            )
        },
        modifier = modifier,
        shape = RoundedCornerShape(100 ),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search",
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 16.dp),
                tint = AppTheme.colors.searchIconColor,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = AppTheme.colors.searchBarColor,
            textColor = AppTheme.colors.primaryTextColor
        )
    )
}