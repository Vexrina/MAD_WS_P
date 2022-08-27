package com.example.shushufood.ui.screens.menu_item.models

sealed class MenuItemEvent {
    object DecreaseClicked : MenuItemEvent()
    object IncreaseClicked : MenuItemEvent()
    object RemoveClicked: MenuItemEvent()
    object AddClicked: MenuItemEvent()
}