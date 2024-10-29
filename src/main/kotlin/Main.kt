package org.example

import org.example.console.Console
import org.example.entityManagerFact.EntityManagerFact
import org.example.login.Login
import org.example.menu.Menu
import org.example.model.Producto
import org.example.model.Proveedor
import org.example.model.Usuario
import org.example.repository.ProductoRepository
import org.example.repository.ProveedorRepository
import org.example.repository.UsuarioRepository
import org.example.service.ProductoService
import org.example.service.ProveedorService
import org.example.service.UsuarioService


fun main() {
    // Instanciamos los repositorios de cada clase
    val ur = UsuarioRepository()
    val provRepo = ProveedorRepository()
    val prodRepo = ProductoRepository()

    // Intanciamos los servicios, la capa intermedia que llamará a los repositorios
    val provServ = ProveedorService(provRepo)
    val prodService = ProductoService(prodRepo)
    val us = UsuarioService(ur)

    // Cargamos la base de datos
    loadDataBase(provServ, prodService)

    //Instanciamos la consola la que nos permitirá gestionar todas las entradas y salidas por pantalla.
    val consola = Console()

    // Creamos un usuario admin en la base de datos y lo instanciamos para que se pueda logear.
    val user = Usuario("admin", "admin")
    us.insert(user)

    // Se instanccia el login el cual usaremos para logearnos en la app y lo ejecutamos
    val login = Login(consola, us)

    login.login()

    // Una vez logeados instanciamos el menu y lo ejecutamos.
    val menu = Menu(consola,provServ,prodService)

    menu.menu()
}


fun loadDataBase(provService: ProveedorService, prodService: ProductoService) {
    val prov1 = Proveedor(null,"ElectroMart", "Calle Gran Vía 5", mutableListOf())
    val prov2 = Proveedor(null,"Casa Decor", "Av. del Arte 10", mutableListOf())
    val prov3 = Proveedor(null,"Moda Chic", "Calle de la Moda 22", mutableListOf())
    val prov4 = Proveedor(null,"Deportes Pro", "Plaza del Deporte 9", mutableListOf())
    val prov5 = Proveedor(null,"Librería Central", "Calle de los Libros 16", mutableListOf())
    listOf(prov5, prov4, prov3, prov2, prov1).forEach { provService.insert(it) }

    val prod1 = Producto("Electrónica", "Smartphone X", "Último modelo de smartphone", 799.99f, 150, prov1)
    val prod2 = Producto("Hogar", "Aspiradora 3000", "Aspiradora de alta potencia", 120.50f, 80, prov2)
    val prod3 = Producto("Ropa", "Chaqueta de Cuero", "Chaqueta de cuero auténtico", 249.99f, 30, prov3)
    val prod4 = Producto("Deportes", "Bicicleta de Montaña", "Bicicleta con suspensión completa", 999.00f, 20, prov4)
    val prod5 = Producto("Libros", "El Quijote", "Edición especial del clásico", 19.99f, 100, prov5)
    listOf(prod5, prod4, prod3, prod2, prod1).forEach { prodService.insert(it) }



}


