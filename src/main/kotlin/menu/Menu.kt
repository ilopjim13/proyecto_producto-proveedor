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

            opcion = consola.pedirOpcion(10)

            ejecutarMenu(opcion)

        } while (opcion != 10)
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
        consola.mostrarMensaje("Introduce el nombre del producto: ", false)
        val nombre = readln()
        consola.mostrarMensaje("Introduce la categoria del producto: ", false)
        val cat = readln()
        consola.mostrarMensaje("Introduce la descripción: ", false)
        val desc = readln()
        val precio:Float = consola.pedirPrecio()
        val stock:Int = consola.pedirNum("Introduce el stock: ", "ERROR - ID incorrecto.")

        val proveedor: Proveedor = consola.pedirProveedor(provServ)

        val producto = Producto(cat, nombre, desc, precio, stock, proveedor)

        prodServ.insert(producto)

    }

    private fun bajaProducto() {
        val id:String = consola.pedirString("Introduce el ID del producto: ")
        if (prodServ.delete(id)) consola.mostrarMensaje("El producto se ha eliminado correctamente.")
        else consola.mostrarMensaje("No existe el producto.")
    }

    private fun modificarNombreProd() {
        val id = consola.pedirString("Introduce el ID del producto: ")
        if (prodServ.checkID(id) != null) {
            val nombre = consola.pedirString("Introduce el nombre del producto: ")
            if (prodServ.updateName(id, nombre)) consola.mostrarMensaje("El nombre se ha cambiado correctamente.")
            else consola.mostrarMensaje("No se ha podido cambiar el nombre del producto")
        } else consola.mostrarMensaje("El id introducido no exite")
    }

    private fun modificarStockProd() {
        val id = consola.pedirString("Introduce el ID del producto: ")
        if (prodServ.checkID(id) != null) {
            val stock = consola.pedirNum("Introduce el Stock a cambiar: ", "ERROR - EL número del stock debe ser correcto.")
            if (prodServ.updateStock(id, stock)) consola.mostrarMensaje("El stock se ha cambiado correctamente.")
            else consola.mostrarMensaje("No se ha podido cambiar el stock del producto")
        } else consola.mostrarMensaje("El id introducido no exite")
    }

    private fun obtenerProd() {
        val id = consola.pedirString("Introduce el ID del producto a mostrar:  ")
        val prod = prodServ.checkID(id)
        if (prod != null) consola.mostrarMensaje(prod.toString())
        else consola.mostrarMensaje("El producto buscado no existe.")
    }

    private fun conStock() {
        val lista = prodServ.selectWithStock()
        lista.forEach { consola.mostrarMensaje(it.toString()) }
    }

    private fun sinStock() {
        val lista = prodServ.selectWithOutStock()
        lista.forEach { consola.mostrarMensaje(it.toString()) }
    }

    private fun mostrarProvProd(){
        val id = consola.pedirString("Introduce el ID del producto para mostrar su proveedor: ")
        val producto = prodServ.checkID(id)
        if (producto != null) {
            val proveedor = producto.proveedor.id?.let { provServ.checkID(it) }
            consola.mostrarMensaje(proveedor.toString())
        } else consola.mostrarMensaje("El ID del producto introducido es erróneo.")
    }

    private fun mostrarProvedores() {
        val lista = provServ.selectAll()
        lista.forEach { consola.mostrarMensaje(it.toString()) }
    }


}