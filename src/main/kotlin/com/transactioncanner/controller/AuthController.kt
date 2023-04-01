package com.transactioncanner.controller

import com.transactioncanner.dto.UserDto
import com.transactioncanner.security.JwtProvider
import com.transactioncanner.service.UserService
import org.springframework.web.bind.annotation.*

/**
 * Контроллер для аутентификации и регистрации.
 */
@RestController
@RequestMapping("/auth")
    class AuthController(private val userService: UserService, private val jwtProvider: JwtProvider) {
    /**
     * Регистрация пользователя.
     */
    @PostMapping("sign-up")
    fun addUser(@RequestBody user: UserDto): UserDto {
        val savedUser = userService.addUser(user.toEntity()).toDto()
        savedUser.password = ""
        return savedUser
    }

    /**
     * Проверяет пароль пользователя, если пароли совпадают, возвращает токен, если нет, то бросает исключение.
     */
    @PostMapping("/sign-in")
    fun login(@RequestBody user: UserDto): String {
        val savedUser = userService.login(user.toEntity()).toDto()

        return jwtProvider.generateToken(savedUser.username)
    }
}