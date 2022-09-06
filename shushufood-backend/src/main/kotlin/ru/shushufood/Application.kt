package ru.shushufood

import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database
import ru.shushufood.features.login.configureLoginRouting
import ru.shushufood.features.menu.configureMenuRouting
import ru.shushufood.features.order.configureOrderRouting
import ru.shushufood.features.register.configureRegisterRouting
import ru.shushufood.plugins.configureRouting
import ru.shushufood.plugins.configureSerialization

fun main() {
    Database.connect(url = "jdbc:postgresql://localhost:5432/shushufood", driver = "org.postgresql.Driver",
    user = "postgres", password = "admin")
    embeddedServer(CIO, port = 8080, host = "localhost") {
        configureMenuRouting()
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureSerialization()
        configureOrderRouting()
    }.start(wait = true)
}
