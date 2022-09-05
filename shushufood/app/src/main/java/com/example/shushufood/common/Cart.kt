package com.example.shushufood.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.shushufood.network.models.MenuResponseModel
import java.math.BigDecimal


data class OrderLine(
    val item: MenuResponseModel, var count: Int
)

object Cart {
    private val _cartItems: MutableLiveData<MutableMap<MenuResponseModel, Int>> = MutableLiveData(mutableMapOf())
    val cartItems: LiveData<MutableMap<MenuResponseModel, Int>> = _cartItems

    private val _cartTotalPrice: MutableLiveData<BigDecimal> = MutableLiveData()
    val cartTotalPrice : LiveData<BigDecimal> = _cartTotalPrice

    private val cartListAndTotalPriceMerge = MediatorLiveData<Int>().addSource(_cartItems, )


    fun addItem(menuItem: MenuResponseModel) {
        if (_cartItems.value?.containsKey(menuItem) == false) {
            val newCartItems = _cartItems.value?.toMutableMap()
            newCartItems?.put(menuItem, 1)
            _cartItems.postValue(newCartItems)
        } else {
            _cartItems.postValue(_cartItems.value?.map { (key, value) ->
                if (key == menuItem) {
                    Pair(key, value + 1)
                } else {
                    Pair(key, value)
                }
            }?.toMap()?.toMutableMap())
        }


//        _cartItems.value?.merge(menuItem, 1) { oldValue, value ->
//            oldValue+value
//        }
    }

    fun removeItem(menuItem: MenuResponseModel, removeCompletely: Boolean = false) {
        if (removeCompletely) {
            _cartItems.postValue(_cartItems.value?.filter {
                it.key != menuItem
            }?.toMutableMap())
        } else {
            _cartItems.postValue(_cartItems.value?.map {(key, value) ->
                if (key == menuItem) {
                    Pair(key, value - 1)
                } else {
                    Pair(key, value)
                }
            }?.toMap()?.toMutableMap())
//            _cartItems.value!![menuItem] = _cartItems.value!!.get(menuItem)!! - 1
        }
    }
    fun totalPrice(): BigDecimal {
        var sum = BigDecimal(0)

        _cartItems.value?.forEach {
            sum += it.key.price * BigDecimal(it.value)
        }

        return sum
    }

    fun updateTotalPrice() {
        _cartTotalPrice.postValue(totalPrice())
    }


}