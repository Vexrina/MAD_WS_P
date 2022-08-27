package com.example.shushufood.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shushufood.db.MenuDao
import com.example.shushufood.db.asDomainModel
import com.example.shushufood.network.ApiService
import com.example.shushufood.network.models.MenuResponseModel
import com.example.shushufood.network.models.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MenuRepository(private val database: MenuDao) {

    private val apiService by lazy {
        ApiService.create()
    }

    val menuItems: LiveData<List<MenuResponseModel>> = Transformations.map(database.getMenu()){
        it.asDomainModel()
    }

    fun menuItemByName(name: String): MenuResponseModel? {
        return menuItems.value?.firstOrNull {
            it.name == name
        }
    }

    suspend fun fetchMenu() {
        withContext(Dispatchers.IO) {
            val menu = apiService.getProducts("")

            database.insertAll(
                menu.asDatabaseModel()
            )
        }
    }
}