package ru.shushufood.features.menu

import io.ktor.server.application.*
import io.ktor.server.routing.*


fun Application.configureMenuRouting() {

    routing {
        post("/menu/search") {
            MenuController(call).performSearch()

        }

        post("/menu/create") {
            MenuController(call).createMenu()
        }
    }
}