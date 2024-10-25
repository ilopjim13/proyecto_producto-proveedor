package org.example.login

import org.example.console.Console
import org.example.repository.UsuarioRepository

class Login(private val consola: Console, private val userRepository: UsuarioRepository) {


    fun login() {
        var log = false
        while (!log) {
            val (nombre, pass) = pedirCredenciales()
            val usuario = userRepository.selectUser(nombre)

            if (usuario?.nombre == nombre && usuario.password == pass) log = true
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