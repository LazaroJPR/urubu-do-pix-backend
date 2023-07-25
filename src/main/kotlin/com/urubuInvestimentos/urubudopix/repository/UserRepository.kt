package com.urubuInvestimentos.urubudopix.repository

import com.urubuInvestimentos.urubudopix.model.User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, String> {
    fun findByCPF(cpf: String): User?

    fun existsByCPF(cpf: String): Boolean

    fun deleteByCPF(cpf: String): Void
}
