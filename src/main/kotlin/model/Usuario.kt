package org.example.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.jetbrains.annotations.Nullable

@Entity
@Table(name = "usuario")
class Usuario(
    @Id
    val nombre:String,
    @Column(nullable = false, length = 20)
    val password:String) : IElement {
}