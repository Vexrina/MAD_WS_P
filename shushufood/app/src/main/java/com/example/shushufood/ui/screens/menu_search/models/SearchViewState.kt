package com.example.shushufood.ui.screens.menu_search.models

enum class SearchSubState{
        Start, Finish, Clear
}



data class SearchViewState(
        val searchSubState: SearchSubState = SearchSubState.Start,
        val query: String = "",
        val searchResults: List<String> = emptyList(),
        val refreshing: Boolean = false,
        val message: String? = null

        )