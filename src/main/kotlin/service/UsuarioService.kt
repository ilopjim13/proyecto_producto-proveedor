package org.example.service

import org.example.repository.UsuarioRepository

class UsuarioService(private val userRepository:UsuarioRepository) {

    fun comprobarUsuario(nombre:String, pass: String) :Boolean {
        val usuario = userRepository.selectUser(nombre)
        return (usuario?.nombre == nombre && usuario.password == pass)
    }
}