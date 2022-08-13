package com.example.shushufood.utils.models

import kotlinx.serialization.SerialInfo
import kotlinx.serialization.Serializable
import ru.shushufood.features.utils.BigDecimalSerializer
import java.math.BigDecimal

@Serializable
data class MenuResponseModel(
    val name: String,
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal,
    val image: ByteArray,
    val category: Int
)