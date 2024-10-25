package org.example.console

class Console {

    fun mostrarMensaje(text:String, br:Boolean = true) {
        if (br) println(text)
        else print(text)
    }

}