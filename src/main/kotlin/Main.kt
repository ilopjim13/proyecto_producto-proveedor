package org.example

import org.example.console.Console
import org.example.entityManagerFact.EntityManagerFact
import org.example.login.Login
import org.example.model.Usuario
import org.example.repository.ProductoRepository
import org.example.repository.ProveedorRepository
import org.example.repository.UsuarioRepository


fun main() {
    val em = EntityManagerFact.generate()


    val ur = UsuarioRepository()
    val provRepo = ProveedorRepository()
    val prodRepo = ProductoRepository()

    val user = Usuario("pepe", "pepe")
    ur.insertUser(user)
    val consola = Console()


    val login = Login(consola, ur)

    login.login()

    println("BIEN HECHO CRACK")




}


