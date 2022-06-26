package com.example.shushufood.common

interface EventHandler<E> {
    fun obtainEvent(event: E)
}