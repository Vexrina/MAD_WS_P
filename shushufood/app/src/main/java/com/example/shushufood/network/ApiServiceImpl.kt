package com.example.shushufood.network

import com.example.shushufood.network.models.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {

    override suspend fun getProducts(query: String): List<MenuResponseModel> {
        val response = client.post {
            header("Bearer-Authorization", "")
            url(ApiRoutes.MENU_SEARCH)
            contentType(ContentType.Application.Json)
            setBody(MenuRequestModel(query))
        }
        val menuList = response.body<List<MenuResponseModel>>()

        return try {
            menuList

        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${ex.response.status.description}")
            emptyList()
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            println("Error: ${ex.response.status.description}")
            emptyList()
        } catch (ex: ServerResponseException) {
            // 5xx - response
            println("Error: ${ex.response.status.description}")
            emptyList()
        }
    }

    override suspend fun tryLogin(email: String, password: String): LoginResult {
        val response = client.post {
            url(ApiRoutes.LOGIN)
            contentType(ContentType.Application.Json)
            setBody(LoginRequestModel(email, password))
        }
        val token = response.body<String>()

        return when (response.status) {
            HttpStatusCode.OK -> LoginResult.Ok(token = token)
            HttpStatusCode.Conflict -> LoginResult.UserNotFound
            HttpStatusCode.BadRequest -> LoginResult.InvalidPassword
            else -> LoginResult.SomethingWentWrong
        }
    }

    override suspend fun tryRegister(
        email: String,
        password: String,
        phoneNumber: String,
        fullName: String
    ): RegisterResult {
//        TODO("Not yet implemented")
        val response = client.post {
            url(ApiRoutes.REGISTER)
            contentType(ContentType.Application.Json)
            setBody(RegisterRequestModel(
                fullName = fullName,
                email = email,
                password = password,
                phoneNumber = phoneNumber
            ))
        }

        return try {
            when (response.status) {
                HttpStatusCode.OK -> RegisterResult.Ok(token = response.body<RegisterResponseModel>().token)
                HttpStatusCode.BadRequest -> RegisterResult.EmailIsNoValid
                HttpStatusCode.Conflict -> RegisterResult.UserAlreadyExists
                else -> RegisterResult.SomethingWentWrong
            }
        } catch (e: Exception) {
            RegisterResult.SomethingWentWrong
        }
    }


// Admin application feature

//    override suspend fun createProducts(productRequest: MenuRequestModel): MenuResponseModel? {
//        val response = client.post(ApiRoutes.MENU + "/create") {
//            contentType(ContentType.Application.Json)
//            setBody(MenuRequestModel("TestBurger", 666.00, ))
//        }
//        return try {
//
//            client.post<MenuResponseModel> {
//                url(ApiRoutes.MENU)
//                body = productRequest
//            }
//        } catch (ex: RedirectResponseException) {
//            // 3xx - responses
//            println("Error: ${ex.response.status.description}")
//            null
//        } catch (ex: ClientRequestException) {
//            // 4xx - responses
//            println("Error: ${ex.response.status.description}")
//            null
//        } catch (ex: ServerResponseException) {
//            // 5xx - response
//            println("Error: ${ex.response.status.description}")
//            null
//        }
//    }
}