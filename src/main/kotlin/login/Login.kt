package org.example.login

import org.example.console.Console
import org.example.repository.UsuarioRepository
import org.example.service.UsuarioService

class Login(private val consola: Console, private val userService: UsuarioService) {


    fun login() {
        var log = false
        while (!log) {
            val (nombre, pass) = pedirCredenciales()

            if (userService.comprobarUsuario(nombre, pass)) log = true
            else consola.mostrarMensaje("**ERROR** El nombre o la contraseña es inconrrecta.")
        }
    }

    private fun pedirCredenciales(): Pair<String, String> {
        consola.mostrarMensaje("Introduce tu nombre de usuario: ", false)
        val nombre = readln()
        consola.mostrarMensaje("Introduce la contraseña: ", false)
        val pass = readln()
        return Pair(nombre, pass)
    }


}