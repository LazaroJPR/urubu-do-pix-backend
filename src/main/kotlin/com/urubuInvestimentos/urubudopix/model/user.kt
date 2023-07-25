package com.urubuInvestimentos.urubudopix.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
 data class User(
    @Id
    val cpf: String= "",
    val password: String= "",
    val name: String = "",
    val email: String= "",
    val phone: String= "",
    val birthdate: LocalDate = LocalDate.now(),
    val value:  Double,
)

