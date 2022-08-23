package com.example.shushufood.network.models

import com.example.shushufood.db.DatabaseMenuItem
import kotlinx.serialization.Serializable
import ru.shushufood.features.utils.BigDecimalSerializer
import java.math.BigDecimal

@Serializable
data class MenuResponseModel(
    val name: String,
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal,
    val image: ByteArray,
    val category: Int
)

fun List<MenuResponseModel>.asDatabaseModel(): List<DatabaseMenuItem> {
    return map {
        DatabaseMenuItem(
            name = it.name,
            price = it.price,
            image = it.image,
            category = it.category
        )
    }
}