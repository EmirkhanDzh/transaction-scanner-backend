package com.transactioncanner.entity

import com.transactioncanner.dto.UserDto
import com.transactioncanner.enums.Role

/**
 * Для отображения таблицы users из базы данных.
 */
data class User(
    /**
     * Идентификатор чата пользователя в Телеграме. Первичный ключ.
     */
    val id: Long,
    /**
     * Логин пользователя.
     */
    val username: String,
    /**
     * Пароль пользователя.
     */
    var password: String,

    var role: Role = Role.OPERATOR,
) {
    fun toDto() = UserDto(id, username, password, role)
}