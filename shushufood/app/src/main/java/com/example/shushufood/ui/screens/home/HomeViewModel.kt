package com.example.shushufood.ui.screens.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shushufood.common.EventHandler
import com.example.shushufood.common.MenuRepository
import com.example.shushufood.network.models.menuorders.MenuResponseModel
import com.example.shushufood.ui.screens.home.models.HomeEvent
import com.example.shushufood.ui.screens.home.models.HomeSubState
import com.example.shushufood.ui.screens.home.models.HomeViewState
import com.example.shushufood.ui.screens.home.models.ItemClickAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application), EventHandler<HomeEvent> {
    private val _viewState = MutableLiveData(HomeViewState())
    val viewState: LiveData<HomeViewState> = _viewState

    private val repository: MenuRepository
    var menuItems: LiveData<List<MenuResponseModel>>

    init {
//        val menuDao = AppDatabase.getInstance(application).menuDao()
//        menuRepository = MenuRepository(menuDao)
        repository = MenuRepository(application)
        menuItems = MenuRepository.menuItems
        refreshMenuFromRepository()
    }

    override fun obtainEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.ItemActionInvoked -> itemActionInvoked()
            HomeEvent.SearchClearClicked -> clearSearch()
            HomeEvent.RetryMenuLoadingClicked -> refreshMenuFromRepository()
            is HomeEvent.SearchChanged -> searchChanged(event.value)
            is HomeEvent.MenuItemClicked -> menuItemClicked(event.value)
        }
    }

    private fun itemActionInvoked() {
        _viewState.postValue(_viewState.value?.copy(itemClickAction = ItemClickAction.None))
    }

    private fun clearSearch() {
        _viewState.postValue(_viewState.value?.copy(searchValue = ""))
    }

    private fun searchChanged(value: String) {
        _viewState.postValue(_viewState.value?.copy(searchValue = value))
    }

    private fun menuItemClicked(value: String) {
        _viewState.postValue(
            _viewState.value?.copy(
                itemClickAction = ItemClickAction.OpenItemPicker(
                    value
                )
            )
        )

    }

    private fun refreshMenuFromRepository() {
        viewModelScope.launch {
            try {
                _viewState.postValue(_viewState.value?.copy(homeSubState = HomeSubState.Loading))
                repository.fetchMenu()
                _viewState.postValue(_viewState.value?.copy(homeSubState = HomeSubState.Loaded))


            } catch (networkError: IOException) {
                if (menuItems.value?.isNotEmpty() == true) {
                    _viewState.postValue(_viewState.value?.copy(homeSubState = HomeSubState.Loaded))
                }
                _viewState.postValue(_viewState.value?.copy(homeSubState = HomeSubState.Failed))
            }
        }
    }

}