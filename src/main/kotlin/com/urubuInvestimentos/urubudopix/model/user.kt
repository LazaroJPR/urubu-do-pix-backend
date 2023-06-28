package com.urubuInvestimentos.urubudopix.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
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

    @OneToOne(mappedBy = "user")
    val account: Account? = null
)
