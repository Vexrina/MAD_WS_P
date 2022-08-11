package com.example.shushufood.ui.screens.menu_search.models

sealed class SearchEvent {
    data class QueryChanged(val value: String) : SearchEvent()
}
