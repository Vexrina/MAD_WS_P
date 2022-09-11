package ru.shushufood.features.order

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.shushufood.database.order.OrderDTO
import ru.shushufood.database.order.OrderStatus
import ru.shushufood.database.order.Orders
import ru.shushufood.database.order_positions.OrderPositions
import ru.shushufood.database.order_positions.OrderPositionsDTO

class OrderController(private val call: ApplicationCall) {
    suspend fun makeOrder() {
        val receive = call.receive<OrderReceiveModel>()
        val order_id = Orders.insertAndGetId(
            OrderDTO(
                id = null,
                status = OrderStatus.ACCEPTED
            )
        )

        receive.itemList.forEach {
            OrderPositions.insert(
                OrderPositionsDTO(
                    order_id = order_id,
                    menu_name = it.item_name,
                    menu_category = it.item_category,
                    quantity = it.quantity
                )
            )
        }

        call.respond(
            OrderResponseModel(
                id = order_id,
                status = OrderStatus.ACCEPTED
            )
        )

    }

    suspend fun updateOrderStatus() {
        val receive = call.receive<OrderIdModel>()
        val order_id = receive.orderId


        call.respond(
            OrderResponseModel(
                id = order_id,
                status = Orders.updateStatus(order_id)
            )
        )
    }
}