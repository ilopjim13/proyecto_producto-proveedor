package org.example.service

import org.example.model.Usuario
import org.example.repository.UsuarioRepository

class UsuarioService(private val userRepository:UsuarioRepository) {

    fun checkUser(nombre:String, pass: String) :Boolean {
        val usuario = userRepository.selectUser(nombre)
        return (usuario?.nombre == nombre && usuario.password == pass)
    }

    fun insert(user:Usuario){
        userRepository.insertUser(user)
    }
}