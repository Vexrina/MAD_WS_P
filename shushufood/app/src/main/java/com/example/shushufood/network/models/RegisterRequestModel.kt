package com.example.shushufood.network.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequestModel(
    val fullName: String,
    val password: String,
    val email: String,
    val phoneNumber: String
)
