package ru.shushufood.database.users

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

object Users: Table() {
    private val login = Users.varchar("login",25)
    private val password = Users.varchar("password",25)
    private val email = Users.varchar("email",25)
    private val phone_number = Users.varchar("phone_number",11)

    fun insert(userDTO: UserDTO){
        transaction {
            Users.insert {
                it[login] = userDTO.login
                it[password] = userDTO.password
                it[email] = userDTO.email ?: ""
                it[phone_number] = userDTO.phone_number
            }
        }
    }
    fun fetchUser(login: String): UserDTO?{
        return try{
            transaction {
                val userModel = Users.select{Users.login.eq(login)}.single()
                UserDTO(
                    login = userModel[Users.login],
                    password = userModel[password],
                    email = userModel[email],
                    phone_number = userModel[phone_number]
                )
            }
        } catch (e: Exception) {
            null
        }
    }
}