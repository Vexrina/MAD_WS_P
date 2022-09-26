package ru.shushufood.features.menu

import kotlinx.serialization.Serializable
import ru.shushufood.features.utils.BigDecimalSerializer
import java.math.BigDecimal


@Serializable
data class FetchMenuResponse(
    val menu: List<MenuResponse>
)

@Serializable
data class MenuResponse(
    val name: String,
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal,
    val image: ByteArray,
    val category: Int
)