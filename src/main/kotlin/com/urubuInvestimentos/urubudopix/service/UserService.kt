package com.urubuInvestimentos.urubudopix.service

import com.urubuInvestimentos.urubudopix.model.User
import com.urubuInvestimentos.urubudopix.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
private val userRepository: UserRepository
) {

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    fun getUser(cpf: String): User? =
        userRepository.findByCPF(cpf)

    fun updateUser(user: User): User? {
        if(userRepository.existsByCPF(user.cpf)){
            return userRepository.save(user)
        }
        return null
    }

    fun patchValue(cpf: String, value: Double): User? {
        val user = getUser(cpf)

        if(user != null){
            user.value = value
            return user
        }
        return null
    }

    fun deleteUser(cpf: String): Boolean {
        if(userRepository.existsByCPF(cpf)){
            userRepository.deleteByCPF(cpf)
            return true
        }
        return false
    }
}