package ru.shushufood.features.register

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.shushufood.cache.InMemoryCache
import ru.shushufood.cache.TokenCache
import ru.shushufood.features.login.LoginReceiveRemote
import ru.shushufood.features.login.LoginResponseRemote
import ru.shushufood.features.utils.isValidEmail
import java.util.*

fun Application.configureRegisterRouting() {

    routing {
        post("/register") {
            val registerController = RegisterController(call)
            registerController.registerNewUser()
        }
    }
}