package ru.shushufood.database.order

@kotlinx.serialization.Serializable
data class OrderDTO(
    val id: Int?,
    val status: Int
)