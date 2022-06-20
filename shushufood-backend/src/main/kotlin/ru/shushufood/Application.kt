package ru.shushufood

import io.ktor.server.engine.*
import io.ktor.server.cio.*
import org.jetbrains.exposed.sql.Database
import ru.shushufood.features.login.configureLoginRouting
import ru.shushufood.features.menu.configureMenuRouting
import ru.shushufood.features.register.configureRegisterRouting
import ru.shushufood.plugins.*

fun main() {
    Database.connect(url = "jdbc:postgresql://localhost:5432/shushufood", driver = "org.postgresql.Driver",
    user = "postgres", password = "admin")
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureMenuRouting()
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureSerialization()
    }.start(wait = true)
}
