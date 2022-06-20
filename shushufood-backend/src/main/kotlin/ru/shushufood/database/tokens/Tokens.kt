package ru.shushufood.database.tokens

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

object Tokens: Table() {
    private val id = Tokens.varchar("id", 50)
    private val login = Tokens.varchar("login",25)
    private val token = Tokens.varchar("token",50)

    fun insert(tokenDTO: TokenDTO){
        transaction {
            Tokens.insert {
                it[login] = tokenDTO.login
                it[id] = tokenDTO.rowId
                it[token] = tokenDTO.token
            }
        }
    }

}
