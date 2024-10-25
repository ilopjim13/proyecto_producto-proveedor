package org.example.service

import org.example.model.Producto
import org.example.model.Proveedor
import org.example.repository.ProductoRepository

class ProductoService(val pr: ProductoRepository) {

    fun generateId(categoria:String, nombre:String, proveedor: Proveedor):String {
        return categoria.take(3) + nombre.take(3) + proveedor.nombre.take(3)
    }

    fun insert(prod: Producto) {
        pr.insert(prod)
    }

}