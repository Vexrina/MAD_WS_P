package com.example.shushufood.network

import com.example.shushufood.network.models.LoginResult
import com.example.shushufood.network.models.MenuResponseModel
import com.example.shushufood.network.models.OrderResult
import com.example.shushufood.network.models.RegisterResult
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

interface ApiService {
    suspend fun getProducts(query: String): List<MenuResponseModel>

    suspend fun tryLogin(
        email: String,
        password: String
    ): LoginResult

    suspend fun tryRegister(
        email: String,
        password: String,
        phoneNumber: String,
        fullName: String
    ): RegisterResult

    suspend fun tryMakeOrder(
        itemMap: Map<MenuResponseModel, Int>
    ): OrderResult

//  Admin application feature
//    suspend fun createProducts(productRequest: MenuRequestModel): MenuResponseModel?

    companion object {
        fun create(): ApiService {
            return ApiServiceImpl(
                client = HttpClient(Android) {
                    // Logging
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    // JSON
                    install(ContentNegotiation) {
                        json()
                        //or serializer = KotlinxSerializer()
                    }
                    // Timeout
                    install(HttpTimeout) {
                        requestTimeoutMillis = 15000L
                        connectTimeoutMillis = 15000L
                        socketTimeoutMillis = 15000L
                    }
                    // Apply to all requests
                    defaultRequest {
                        // Parameter("api_key", "some_api_key")
                        // Content Type
//                        if (method != HttpMethod.Get)
//                        contentType(ContentType.Application.Json)
                        accept(ContentType.Application.Json)
                    }
                }
            )
        }

        private val json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
    }
}