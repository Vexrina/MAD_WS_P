package com.example.shushufood.common

import androidx.compose.runtime.produceState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.shushufood.utils.models.MenuResponseModel
import com.example.shushufood.utils.network.ApiService
import kotlinx.coroutines.coroutineScope

object MenuRepository {

    private val apiService by lazy {
        ApiService.create()
    }

    suspend fun fetchMenu(): List<MenuResponseModel> {
        return apiService.getProducts("")
    }
}