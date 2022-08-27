package com.example.shushufood.ui.screens.cart.models

import com.example.shushufood.network.models.MenuResponseModel

sealed class CartEvent {
    data class  ItemAddClicked(val value: MenuResponseModel): CartEvent()
}