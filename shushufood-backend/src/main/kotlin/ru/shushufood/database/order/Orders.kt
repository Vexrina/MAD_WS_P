package ru.shushufood.database.order

import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

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

    fun updateStatus(orderId: Int): Int {

        return try {
            transaction {
                val orderModel = Orders.select(Orders.id eq orderId).single()

                Orders.update(where = { Orders.id eq orderId }) {
                    with(SqlExpressionBuilder) {
                        it.update(Orders.status, Orders.status + 1)
                    }
                }
                Orders.select(Orders.id eq orderId).single()[Orders.status]
            }
        } catch (e: Exception) {
            -1
        }
    }


}