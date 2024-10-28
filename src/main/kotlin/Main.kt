package org.example

import org.example.console.Console
import org.example.entityManagerFact.EntityManagerFact
import org.example.login.Login
import org.example.menu.Menu
import org.example.model.Usuario
import org.example.repository.ProductoRepository
import org.example.repository.ProveedorRepository
import org.example.repository.UsuarioRepository
import org.example.service.ProductoService
import org.example.service.ProveedorService
import org.example.service.UsuarioService


fun main() {
    val em = EntityManagerFact.generate()


    val ur = UsuarioRepository()
    val provRepo = ProveedorRepository()
    val prodRepo = ProductoRepository()

    val provServ = ProveedorService(provRepo)
    val prodService = ProductoService(prodRepo)

    val us = UsuarioService(ur)

    val user = Usuario("admin", "admin")
    ur.insertUser(user)
    val consola = Console()


    val login = Login(consola, us)

    login.login()

    val menu = Menu(consola,provServ,prodService)

   menu.menu()




}


