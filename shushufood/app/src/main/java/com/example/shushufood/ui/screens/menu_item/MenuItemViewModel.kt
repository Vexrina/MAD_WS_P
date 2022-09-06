package com.example.shushufood.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shushufood.common.Cart
import com.example.shushufood.common.EventHandler
import com.example.shushufood.network.models.MenuResponseModel
import com.example.shushufood.ui.screens.menu_item.models.MenuItemEvent
import com.example.shushufood.ui.screens.menu_item.models.MenuItemViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuItemViewModel @Inject constructor(
) : ViewModel(), EventHandler<MenuItemEvent> {
    private val _viewState = MutableLiveData(MenuItemViewState())
    val viewState: LiveData<MenuItemViewState> = _viewState


    override fun obtainEvent(event: MenuItemEvent) {
        when (event) {
            MenuItemEvent.AddClicked -> TODO()
            MenuItemEvent.DecreaseClicked -> TODO()
            is MenuItemEvent.IncreaseClicked -> increaseCounter(event.value)
            MenuItemEvent.RemoveClicked -> TODO()
        }
    }

    private fun increaseCounter(menuItem: MenuResponseModel) {
        Cart.addItem(menuItem)
        _viewState.postValue(_viewState.value?.copy(itemsAdded = viewState.value!!.itemsAdded + 1))
    }

    private fun decreaseCounter() {

    }

    private fun addItem() {

    }

    private fun removeItem() {

    }
}