package ru.shushufood.database.order

import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

object Orders : IdTable<Int>("orders") {
    override val id = Orders.integer("id").autoIncrement().entityId()
    private val status = Orders.integer("status")

    fun insertAndGetId(orderDTO: OrderDTO): Int {
        var id = transaction {
            Orders.insertAndGetId {
                it[status] = orderDTO.status
            }
        }
        return id.value
    }


}