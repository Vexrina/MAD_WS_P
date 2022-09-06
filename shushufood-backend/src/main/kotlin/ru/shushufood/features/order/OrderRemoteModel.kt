package ru.shushufood.features.order

import kotlinx.serialization.Serializable


@Serializable
data class ItemInfo(
    val item_name: String,
    val item_category: Int,
    val quantity: Int
)

@Serializable
data class OrderReceiveModel(
    val itemList: List<ItemInfo>
)

@Serializable
data class OrderResponseModel(
    val id: Int,
    val status: Int
)