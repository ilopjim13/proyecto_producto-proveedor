package org.example.console

import org.example.model.Proveedor
import org.example.service.ProveedorService

class Console {

    fun mostrarMensaje(text:String, br:Boolean = true) {
        if (br) println(text)
        else print(text)
    }

    fun pedirString(texto: String):String {
        mostrarMensaje(texto, false)
        val string = readln()
        return string
    }

    fun pedirProveedor(provServ:ProveedorService): Proveedor {
        var id:Long
        var prov: Proveedor?
        do {
            mostrarMensaje("Introduce el ID del proveedor: ",false)
            id = readln().toLongOrNull() ?: -1
            prov = provServ.checkID(id)
            if (id < 0 || prov == null) mostrarMensaje("ERROR - ID incorrecto.")
        }  while (prov == null)
        return prov
    }

    fun pedirPrecio():Float {
        var num:Float
        do {
            mostrarMensaje("Introduce el precio sin IVA: ",false)
            num = readln().toFloatOrNull() ?: -1.0f
            if (num < 0) mostrarMensaje("ERROR - Precio incorrecto.")
        }  while (num < 0)
        return num
    }

    fun pedirNum(texto:String, error:String):Int {
        var num:Int
        do {
            mostrarMensaje("Introduce el stock: ",false)
            num = readln().toIntOrNull() ?: -1
            if (num < 0) mostrarMensaje("ERROR - Stock incorrecto.")
        }  while (num < 0)
        return num
    }

    fun pedirOpcion(opciones:Int):Int {

        var opcion:Int

        do {
            mostrarMensaje(">> Selecciona una opción: ", false)
            opcion = readln().toIntOrNull() ?: -1
            if (opcion !in (1..opciones)) mostrarMensaje("Error - opción incorrecta.")
        } while (opcion !in (1..opciones))

        return opcion

    }


}