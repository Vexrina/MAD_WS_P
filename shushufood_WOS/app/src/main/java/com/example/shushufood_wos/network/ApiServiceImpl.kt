package com.example.shushufood_wos.network

//import com.example.shushufood.network.models.*
//import com.example.shushufood.network.ApiService
import com.example.shushufood_wos.network.models.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {

    override suspend fun tryLogin(email: String, password: String): LoginResult {
        val response = client.post {
            url(ApiRoutes.LOGIN)
            contentType(ContentType.Application.Json)
            setBody(LoginRequestModel(email, password))
        }
//        val token = response.body<String>()

        return when (response.status) {
            HttpStatusCode.OK -> LoginResult.Ok(token = response.body<LoginResponseModel>().token)
            HttpStatusCode.Conflict -> LoginResult.UserNotFound
            HttpStatusCode.BadRequest -> LoginResult.InvalidPassword
            else -> LoginResult.SomethingWentWrong
        }
    }
}