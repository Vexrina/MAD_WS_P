package com.example.shushufood.utils.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponseModel(
    val token: String
)
