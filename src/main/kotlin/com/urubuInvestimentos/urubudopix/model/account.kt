package com.urubuInvestimentos.urubudopix.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
data class Account(
    @Id
    @GeneratedValue
    val id: Long = 0,
    val value:  Double,

    @OneToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    val user: User
)
