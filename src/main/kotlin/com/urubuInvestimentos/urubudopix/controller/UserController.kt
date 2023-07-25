package com.urubuInvestimentos.urubudopix.controller

import com.urubuInvestimentos.urubudopix.model.UserRequest
import com.urubuInvestimentos.urubudopix.model.UserResponse
import com.urubuInvestimentos.urubudopix.service.UserService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
){

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserResponse>> {
        return ResponseEntity.ok(userService.getAllUsers())
    }

    @GetMapping("/{cpf}")
    fun getUserByCpf(@PathVariable cpf: String): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.getUserResponse(cpf))
    }

    @PostMapping
    fun createUser(@RequestBody @Valid user: UserRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.createUser(user))
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteUser(@PathVariable cpf: String) {
        userService.deleteUser(cpf)
    }

    @PatchMapping("/{cpf}/value/{value}")
    fun updateValue(@PathVariable cpf: String,
                   @PathVariable @NotNull value:  Double
                    ): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.patchValue(cpf, value))
    }

    @PutMapping
    fun updateUser(@RequestBody @Valid user: UserRequest
                    ): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.updateUser(user))
    }

}