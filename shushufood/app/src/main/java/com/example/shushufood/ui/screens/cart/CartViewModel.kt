package com.example.shushufood.ui.screens.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shushufood.common.Cart
import com.example.shushufood.common.EventHandler
import com.example.shushufood.network.ApiService
import com.example.shushufood.network.models.menuorders.MenuResponseModel
import com.example.shushufood.ui.screens.cart.models.CartEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor() : ViewModel(), EventHandler<CartEvent> {
//    private val _viewState: MutableLiveData<CartViewState> = MutableLiveData(CartViewState())
//    val viewState = _viewState

//    private var orderLines:  MutableLiveData<MutableList<OrderLine>> = MutableLiveData()


    override fun obtainEvent(event: CartEvent) {
        when (event) {
            is CartEvent.ItemAddClicked -> addItem(event.value)
            is CartEvent.DecreaseItemCount -> removeItem(event.item)
            is CartEvent.IncreaseItemCount -> addItem(event.item)
            is CartEvent.MakeOrderClicked -> makeOrder()
        }
    }

    val apiService by lazy {
        ApiService.create()
    }

    private fun addItem(menuItem: MenuResponseModel) {
        Cart.addItem(menuItem)
    }

    private fun removeItem(menuItem: MenuResponseModel) {
        Cart.removeItem(menuItem)
    }

    private fun makeOrder() {
        viewModelScope.launch(Dispatchers.IO) {
            val orderResult = apiService.tryMakeOrder(
                itemMap = Cart.cartItems.value!!
            )
        }
    }

}