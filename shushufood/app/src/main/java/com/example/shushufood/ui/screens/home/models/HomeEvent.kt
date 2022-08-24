package com.example.shushufood.ui.screens.home.models

sealed class HomeEvent {
    object SearchClearClicked : HomeEvent()
    object RetryMenuLoadingClicked : HomeEvent()
    data class MenuItemClicked(val value: String) : HomeEvent()
    data class SearchChanged(val value: String) : HomeEvent()
}