package ru.shushufood.database.menu

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import ru.shushufood.features.menu.CreateMenuRequest
import ru.shushufood.features.menu.CreateMenuResponse
import ru.shushufood.features.utils.BigDecimalSerializer
import java.math.BigDecimal

@Serializable
data class MenuDTO
    (
    var name: String,
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal,
    val image: ByteArray,
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