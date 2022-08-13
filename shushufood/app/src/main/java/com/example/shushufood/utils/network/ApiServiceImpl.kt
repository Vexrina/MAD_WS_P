package com.example.shushufood.utils.network

import com.example.shushufood.utils.models.MenuRequestModel
import com.example.shushufood.utils.models.MenuResponseModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.builtins.serializer

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