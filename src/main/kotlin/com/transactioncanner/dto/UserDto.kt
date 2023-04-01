package com.transactioncanner.dto

import com.transactioncanner.entity.User
import com.transactioncanner.enums.Role

/**
 * DTO пользователя.
 */
data class UserDto(

    var id: Long,
    /**
     * Логин пользователя.
     */
    var username: String,
    /**
     * Пароль пользователя.
     */
    var password: String,

    var role: Role = Role.OPERATOR,
) {
    fun toEntity() = User(id, username, password, role)
}