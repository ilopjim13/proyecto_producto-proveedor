package org.example.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "usuario")
data class Usuario(
    @Id
    var nombre:String,
    @Column(nullable = false, length = 20)
    var password:String)