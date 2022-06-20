package ru.shushufood.database.menu

import kotlinx.serialization.Serializable
import ru.shushufood.features.menu.CreateMenuRequest
import ru.shushufood.features.menu.CreateMenuResponse
import java.util.*

data class MenuDTO
    (
    var name: String,
    val price: Int,
    val image: String,
    val category: Int
)

fun CreateMenuRequest.mapToMenuDTO(): MenuDTO =
    MenuDTO(
        name = name,
        price = price,
        image = image,
        category = category
    )

fun MenuDTO.mapToCreateMenuResponse(): CreateMenuResponse =
    CreateMenuResponse(
        name = name,
        price = price,
        image = image,
        category = category
    )