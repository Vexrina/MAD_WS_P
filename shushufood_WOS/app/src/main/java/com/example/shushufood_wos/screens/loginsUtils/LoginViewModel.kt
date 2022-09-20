package com.example.shushufood_wos.screens.loginsUtils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shushufood_wos.utils.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel(), EventHandler<LoginEvent> {
    private val _viewState: MutableLiveData<LoginViewState> = MutableLiveData(LoginViewState())
    val viewState: LiveData<LoginViewState> = _viewState

    override fun obtainEvent(event: LoginEvent) {
        when (event){
            is LoginEvent.EmailChanged -> emailChanged(event.value)
            LoginEvent.LoginClicked -> loginClicked()
            is LoginEvent.PasswordChanged -> passwordChanged(event.value)
        }
    }
    private fun emailChanged(value: String){
        _viewState.postValue(_viewState.value?.copy(emailValue=value))
    }
    private fun passwordChanged(value: String){
        _viewState.postValue(_viewState.value?.copy(passwordValue=value))
    }
    private fun loginClicked(){
        viewModelScope.launch(Dispatchers.IO) {
            _viewState.postValue(_viewState.value?.copy(isProgress = true))
            delay(100)
            _viewState.postValue(
                _viewState.value?.copy(
                    isProgress = false,
                    loginAction = LoginAction.OpenDashBoard("qwerty")
                )
            )
        }
    }

}