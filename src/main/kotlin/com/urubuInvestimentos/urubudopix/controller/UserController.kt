package com.urubuInvestimentos.urubudopix.controller

import com.urubuInvestimentos.urubudopix.service.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
)