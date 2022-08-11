package com.example.shushufood.ui.screens.menu_search.models

import com.example.shushufood.ui.screens.login.models.LoginAction
import com.example.shushufood.ui.screens.login.models.LoginSubState

data class SearchViewState(

        val query: String = "",
        val searchResults: List<String> = emptyList(),
        val refreshing: Boolean = false,
        val message: String? = null

        )