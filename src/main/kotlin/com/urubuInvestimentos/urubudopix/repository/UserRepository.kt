package com.urubuInvestimentos.urubudopix.repository

import com.urubuInvestimentos.urubudopix.model.UserEntity
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<UserEntity, String> {
    fun findByCPF(cpf: String): UserEntity?

    fun existsByCPF(cpf: String): Boolean

    fun deleteByCPF(cpf: String): Void
}
