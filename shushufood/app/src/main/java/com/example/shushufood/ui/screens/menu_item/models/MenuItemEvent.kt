package com.example.shushufood.ui.screens.menu_item.models

import com.example.shushufood.network.models.menuorders.MenuResponseModel

sealed class MenuItemEvent {
    object DecreaseClicked : MenuItemEvent()
    data class IncreaseClicked(val value: MenuResponseModel) : MenuItemEvent()
    object RemoveClicked : MenuItemEvent()
    object AddClicked : MenuItemEvent()
}