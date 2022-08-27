package com.example.shushufood.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shushufood.common.EventHandler
import com.example.shushufood.ui.screens.menu_item.models.MenuItemEvent
import com.example.shushufood.ui.screens.menu_item.models.MenuItemViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuItemViewModel @Inject constructor(
): ViewModel(), EventHandler<MenuItemEvent> {
    private val _viewState = MutableLiveData(MenuItemViewState())
    val viewState: LiveData<MenuItemViewState> = _viewState




    override fun obtainEvent(event: MenuItemEvent) {
        when(event){
            MenuItemEvent.AddClicked -> TODO()
            MenuItemEvent.DecreaseClicked -> TODO()
            MenuItemEvent.IncreaseClicked -> TODO()
            MenuItemEvent.RemoveClicked -> TODO()
        }
    }

    private fun increaseCounter() {

    }

    private fun decreaseCounter() {

    }
    private fun addItem() {

    }
    private fun removeItem() {

    }
}