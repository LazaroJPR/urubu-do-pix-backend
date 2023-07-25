package com.urubuInvestimentos.urubudopix.repository

import com.urubuInvestimentos.urubudopix.model.User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Long> {
}
