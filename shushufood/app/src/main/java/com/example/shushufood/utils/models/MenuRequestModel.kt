package com.example.shushufood.utils.models

import kotlinx.serialization.Serializable
import ru.shushufood.features.utils.BigDecimalSerializer
import java.math.BigDecimal

@Serializable
data class MenuRequestModel(
    val searchQuery: String
)