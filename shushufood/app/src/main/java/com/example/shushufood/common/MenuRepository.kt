package com.example.shushufood.common

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shushufood.db.AppDatabase
import com.example.shushufood.db.asDomainModel
import com.example.shushufood.network.ApiService
import com.example.shushufood.network.models.menuorders.MenuResponseModel
import com.example.shushufood.network.models.menuorders.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


object MenuRepository {

    private val apiService by lazy {
        ApiService.create()
    }

    private lateinit var database: AppDatabase

    lateinit var menuItems: LiveData<List<MenuResponseModel>>

    fun menuItemByName(name: String): MenuResponseModel {
        return menuItems.value!!.first {
            it.name == name
        }
    }

    suspend fun fetchMenu() {
        withContext(Dispatchers.IO) {
            val menu = apiService.getProducts("")

            database.menuDao().insertAll(
                menu.asDatabaseModel()
            )
        }
    }

    operator fun invoke(context: Context): MenuRepository {
        //...
        database = AppDatabase.getInstance(context)
        menuItems = Transformations.map(database.menuDao().getMenu()) {
            it.asDomainModel()
        }

        return this
    }
}