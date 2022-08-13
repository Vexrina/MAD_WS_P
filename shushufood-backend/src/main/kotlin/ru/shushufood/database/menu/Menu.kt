package ru.shushufood.database.menu


import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll


        object Menu: Table() {
            private val name = Menu.varchar("name", 25)
            private val price = decimal("price", precision = 6, scale = 2)
            private val image = Menu.binary("image")
            private val category = Menu.integer("category")


            fun insert(menuDTO: MenuDTO){
        transaction {
            Menu.insert {
                it[name] = menuDTO.name
                it[price] = menuDTO.price
                it[image] = menuDTO.image
                it[category] = menuDTO.category
            }
        }
    }

    fun fetchFullMenu(): List<MenuDTO>{
        return try{
            transaction {
                Menu.selectAll().toList().map{
                    MenuDTO(
                        name = it[name],
                        price = it[price],
                        image = it[image],
                        category = it[category]
                    )
                }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
