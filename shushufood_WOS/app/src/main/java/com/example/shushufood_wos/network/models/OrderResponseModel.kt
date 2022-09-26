package com.example.shushufood_wos.network.models

import kotlinx.serialization.Serializable

@Serializable
data class OrderResponseModel(
    val id: Int,
    val status: Int
)

@Serializable
data class OrderListModel(
    val orderList: List<OrderResponseModel>
)