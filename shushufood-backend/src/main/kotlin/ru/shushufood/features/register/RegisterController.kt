package ru.shushufood.features.register

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.jetbrains.exposed.exceptions.ExposedSQLException
import ru.shushufood.database.tokens.TokenDTO
import ru.shushufood.database.tokens.Tokens
import ru.shushufood.database.users.UserDTO
import ru.shushufood.database.users.Users
import ru.shushufood.features.utils.isValidEmail
import java.util.*

class RegisterController(val call: ApplicationCall) {
    suspend fun registerNewUser() {
        val registerReceiveRemote = call.receive<RegisterReceiveRemote>()
        if (!registerReceiveRemote.email.isValidEmail()) {
            call.respond(HttpStatusCode.BadRequest, "Email is not valid")
        }


        val userDTO = Users.fetchUser(registerReceiveRemote.fullName)
        if (userDTO != null) {
            call.respond(HttpStatusCode.Conflict, "User already exist")
        } else {
            val token = UUID.randomUUID().toString()

            try {
                Users.insert(
                    UserDTO(
                        login = registerReceiveRemote.fullName,
                        password = registerReceiveRemote.password,
                        email = registerReceiveRemote.email,
                        phone_number = registerReceiveRemote.phoneNumber
                    )
                )
            } catch (e: ExposedSQLException) {
                call.respond(HttpStatusCode.Conflict, "User already exist")
            }


            Tokens.insert(
                TokenDTO(
                    rowId = UUID.randomUUID().toString(), login = registerReceiveRemote.fullName, token = token
                )
            )

            call.respond(RegisterResponseRemote(token = token))
        }
    }
}