package com.example.shushufood_wos.utils

interface EventHandler<E>{
    fun obtainEvent(event: E)
}