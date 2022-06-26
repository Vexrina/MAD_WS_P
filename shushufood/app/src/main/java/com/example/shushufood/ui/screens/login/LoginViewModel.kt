package com.example.shushufood.ui.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shushufood.common.EventHandler
import com.example.shushufood.ui.screens.login.models.LoginEvent
import com.example.shushufood.ui.screens.login.models.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(), EventHandler<LoginEvent>{
    private val _viewState = MutableLiveData(LoginViewState())
    val viewState: LiveData<LoginViewState> = _viewState

    override fun obtainEvent(event: LoginEvent) {

    }

}