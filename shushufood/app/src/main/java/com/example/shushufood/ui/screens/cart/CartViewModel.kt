package com.example.shushufood.ui.screens.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shushufood.common.EventHandler
import com.example.shushufood.network.models.MenuResponseModel
import com.example.shushufood.ui.screens.cart.models.CartEvent
import com.example.shushufood.ui.screens.menu_item.models.MenuItemViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigDecimal
import javax.inject.Inject

data class OrderLine(
    val item: MenuResponseModel,
    val count: Int
)

@HiltViewModel
class CartViewModel @Inject constructor(
): ViewModel(), EventHandler<CartEvent> {
    private val _viewState = MutableLiveData(MenuItemViewState())
    val viewState: LiveData<MenuItemViewState> = _viewState

    private var orderLines:  MutableLiveData<MutableList<OrderLine>> = MutableLiveData()



    override fun obtainEvent(event: CartEvent) {
        when(event){
            is CartEvent.ItemAddClicked -> addItem(event.value)
        }
    }

    private fun addItem(menuItem: MenuResponseModel) {
        if (orderLines.value?.filter {
                it.item == menuItem
            } == null) {
            orderLines.value?.add(OrderLine(menuItem, 1))
        }
    }

    fun getTotalPrice(): BigDecimal {
        TODO()
    }
}