package com.urubuInvestimentos.urubudopix.service

import com.urubuInvestimentos.urubudopix.model.UserEntity
import com.urubuInvestimentos.urubudopix.model.UserRequest
import com.urubuInvestimentos.urubudopix.model.UserResponse
import com.urubuInvestimentos.urubudopix.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
private val userRepository: UserRepository
) {
    fun createUser(userRequest: UserRequest): UserResponse {
        val user = UserEntity(userRequest.cpf,
                            userRequest.password,
                            userRequest.name,
                            userRequest.email,
                            userRequest.phone,
                            userRequest.birthdate,
                            userRequest.value)

        userRepository.save(user)
        return UserResponse(user.name, user.value)
    }

    fun getUser(cpf: String): UserEntity? =
        userRepository.findByCPF(cpf)

    fun getUserResponse(cpf: String): UserResponse? {
        val user = userRepository.findByCPF(cpf)
        if(user != null)
            return UserResponse(user.name, user.value)
        return null
        }

    fun getAllUsers(): List<UserResponse>{
        val list = userRepository.findAll().toCollection(ArrayList())
        if(list.isNotEmpty())
            return list.map { UserResponse(it.name, it.value)}
        return ArrayList()
    }


    fun updateUser(userRequest: UserRequest): UserResponse? {
        if(userRepository.existsByCPF(userRequest.cpf)){
            userRepository.save(UserEntity(
                userRequest.cpf,
                userRequest.password,
                userRequest.name,
                userRequest.email,
                userRequest.phone,
                userRequest.birthdate,
                userRequest.value))
            return UserResponse(userRequest.name, userRequest.value)
        }
        return null
    }

    fun patchValue(cpf: String, value: Double): UserResponse? {
        val user = getUser(cpf)

        if(user != null){
            user.value = value
            userRepository.save(user)
            return UserResponse(user.name, user.value)
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