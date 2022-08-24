package com.example.shushufood.ui.screens.home.models

enum class HomeSubState{
    Loading, Failed, Loaded
}

data class HomeViewState (
    val homeSubState: HomeSubState = HomeSubState.Loading,
    val searchValue: String = "",
)