package org.example.console

class Console {

    fun showText(text:String, br:Boolean = true) {
        if (br) println(text)
        else print(text)
    }

}