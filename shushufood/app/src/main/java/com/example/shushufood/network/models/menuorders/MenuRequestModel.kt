package com.example.shushufood.network.models.menuorders

import kotlinx.serialization.Serializable

@Serializable
data class MenuRequestModel(
    val searchQuery: String
)