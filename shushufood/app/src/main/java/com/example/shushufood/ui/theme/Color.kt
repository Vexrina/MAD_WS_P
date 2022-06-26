package com.example.shushufood.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val headerTextColor: Color,
    val primaryTextColor: Color,
    val systemButtonsColor: Color,
    val eclipseIndicatorColor1: Color,
    val eclipseIndicatorColor2: Color,
)

val lightPalette = Colors(
    primaryBackground = Color(0xffF36CFF),
    secondaryBackground = Color(0xffF7AEFF),
    systemButtonsColor = Color(0xFF000000),
    primaryTextColor = Color(0xFF9923A6),
    headerTextColor = Color(0xFFF16CFF),
    eclipseIndicatorColor2 = Color(0xFFB76DBF),
    eclipseIndicatorColor1 = Color(0xFFF7AEFF)
)