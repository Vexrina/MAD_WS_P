package ru.shushufood.cache

import ru.shushufood.features.register.RegisterReceiveRemote

data class TokenCache(
    val login: String,
    val token: String
)

object InMemoryCache {
    val userList: MutableList<RegisterReceiveRemote> = mutableListOf()
    val token: MutableList<TokenCache> = mutableListOf()
}