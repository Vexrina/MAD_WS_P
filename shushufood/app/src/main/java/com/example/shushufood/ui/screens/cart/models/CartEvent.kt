package com.example.shushufood.ui.screens.cart.models

import com.example.shushufood.network.models.menuorders.MenuResponseModel

sealed class CartEvent {
    data class ItemAddClicked(val value: MenuResponseModel) : CartEvent()

    data class IncreaseItemCount(val item: MenuResponseModel) : CartEvent()
    data class DecreaseItemCount(val item: MenuResponseModel) : CartEvent()
    object MakeOrderClicked : CartEvent()
}