package org.example.menu

import org.example.console.Console
import org.example.model.Producto
import org.example.model.Proveedor
import org.example.service.ProductoService
import org.example.service.ProveedorService

class Menu(private val consola:Console, private val provServ: ProveedorService, private val prodServ:ProductoService) {

    fun menu() {
        var opcion:Int
        do {
            mostrarMenu()

            opcion = pedirOpcion(10)

        } while (opcion != 9)
    }


    private fun mostrarMenu() {
        consola.mostrarMensaje("Control del Stock\n")
        consola.mostrarMensaje("1. Alta de producto")
        consola.mostrarMensaje("2. Baja de producto")
        consola.mostrarMensaje("3. Modificar nombre de producto")
        consola.mostrarMensaje("4. Modificar stock de producto")
        consola.mostrarMensaje("5. Obtener producto")
        consola.mostrarMensaje("6. Obtener productos con stock")
        consola.mostrarMensaje("7. Obtener productos sin stock")
        consola.mostrarMensaje("8. Mostrar proveedor del producto")
        consola.mostrarMensaje("9. Mostrar todos los proveedores")
        consola.mostrarMensaje("10. Salir")

    }

    private fun ejecutarMenu(opcion:Int) {
        when (opcion) {
            1 -> altaProducto()
            2 -> bajaProducto()
            3 -> modificarNombreProd()
            4 -> modificarStockProd()
            5 -> obtenerProd()
            6 -> conStock()
            7 -> sinStock()
            8 -> mostrarProvProd()
            9 -> mostrarProvedores()
        }
    }

    private fun altaProducto() {
        consola.mostrarMensaje("Introduce el nombre del producto: ")
        val nombre = readln()
        consola.mostrarMensaje("Introduce la categoria del producto: ")
        val cat = readln()
        consola.mostrarMensaje("Introduce la descripción: ")
        val desc = readln()
        val precio:Float = pedirPrecio()
        consola.mostrarMensaje("Introduce el stock: ")
        val stock:Int = pedirNum("Introduce el stock: ", "ERROR - ID incorrecto.")

        val proveedor: Proveedor = pedirProveedor()

        val producto = Producto(cat, nombre, desc, precio, stock, proveedor)

        prodServ.insert(producto)

    }

    private fun bajaProducto() {
        val id:String = pedirID()
        if (prodServ.delete(id)) consola.mostrarMensaje("El producto se ha eliminado correctamente.")
        else consola.mostrarMensaje()

    }

    private fun pedirID():String {
        consola.mostrarMensaje("Introduce el ID del producto: ")
        val id = readln()
        return id
    }

    private fun pedirProveedor():Proveedor {
        var id:Int
        var prov: Proveedor?
        do {
            consola.mostrarMensaje("Introduce el ID del producto: ",false)
            id = readln().toIntOrNull() ?: -1
            prov = provServ.comprobarID(id)
            if (id < 0 || prov == null) consola.mostrarMensaje("ERROR - ID incorrecto.")
        }  while (prov == null)
        return prov
    }

    private fun pedirPrecio():Float {
        var num:Float
        do {
            consola.mostrarMensaje("Introduce el precio sin IVA: ",false)
            num = readln().toFloatOrNull() ?: -1.0f
            if (num < 0) consola.mostrarMensaje("ERROR - Precio incorrecto.")
        }  while (num < 0)
        return num
    }

    private fun pedirNum(texto:String, error:String):Int {
        var num:Int
        do {
            consola.mostrarMensaje("Introduce el stock: ",false)
            num = readln().toIntOrNull() ?: -1
            if (num < 0) consola.mostrarMensaje("ERROR - Stock incorrecto.")
        }  while (num < 0)
        return num
    }

    private fun pedirOpcion(opciones:Int):Int {

        var opcion:Int

        do {
            consola.mostrarMensaje(">> Selecciona una opción: ", false)
             opcion = readln().toIntOrNull() ?: -1
            if (opcion !in (1..opciones)) consola.mostrarMensaje("Error - opción incorrecta.")
        } while (opcion !in (1..opciones))

        return opcion

    }


}