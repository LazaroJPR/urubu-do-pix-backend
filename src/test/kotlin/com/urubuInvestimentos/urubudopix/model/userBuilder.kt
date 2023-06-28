package com.urubuInvestimentos.urubudopix.model

import java.time.LocalDate

class UserBuilder {
    private var cpf: String = ""
    private var password: String = ""
    private var name: String = ""
    private var email: String = ""
    private var phone: String = ""
    private var birthdate: LocalDate = LocalDate.now()
    private var account: Account? = null

    fun cpf(cpf: String) = apply { this.cpf = cpf }
    fun password(password: String) = apply { this.password = password }
    fun name(name: String) = apply { this.name = name }
    fun email(email: String) = apply { this.email = email }
    fun phone(phone: String) = apply { this.phone = phone }
    fun birthdate(birthdate: LocalDate) = apply { this.birthdate = birthdate }
    fun account(account: Account?) = apply { this.account = account }

    fun build(): User {
        return User(cpf, password, name, email, phone, birthdate, account)
    }
}
