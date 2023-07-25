package com.urubuInvestimentos.urubudopix.model

import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate

data class UserRequest(
    @CPF(message = "CPF inválido")
    val cpf: String= "",
    val password: String= "",
    val name: String = "",
    val email: String= "",
    val phone: String= "",
    val birthdate: LocalDate = LocalDate.now(),
    var value:  Double,
)