package com.example.shushufood.network.models.menuorders

sealed class OrderResult {
    data class Ok(val orderResponseModel: OrderResponseModel) : OrderResult()
    object SomethingWentWrong : OrderResult()
}