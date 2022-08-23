package com.example.shushufood.utils.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequestModel(
    val login: String,
    val password: String,
    val email: String,
    val phone_number: String
)
