package com.urubuInvestimentos.urubudopix.model

class AccountBuilder {
    private var id: Long = 0
    private var value: Double = 0.0
    private lateinit var user: User

    fun id(id: Long) = apply { this.id = id }
    fun value(value: Double) = apply { this.value = value }
    fun user(user: User) = apply { this.user = user }

    fun build(): Account {
        return Account(id, value, user)
    }
}
