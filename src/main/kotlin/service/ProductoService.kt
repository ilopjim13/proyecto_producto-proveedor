package org.example.service

import org.example.model.Producto
import org.example.repository.ProductoRepository

class ProductoService(private val pr: ProductoRepository) {


    fun insert(prod: Producto) {
        pr.insert(prod)
    }

    fun delete(id:String):Boolean {
        return pr.delete(id)
    }

    fun checkID(id: String):Producto? {
        return pr.select(id)
    }

    fun updateName(id:String, name:String):Boolean {
        return pr.updateName(id, name)
    }

    fun updateStock(id:String, stock:Int):Boolean {
        return pr.updateStock(id, stock)
    }

    fun selectWithStock():MutableList<Producto> {
        return pr.selectWithStock()
    }

    fun selectWithOutStock():MutableList<Producto> {
        return pr.selectWithoutStock()
    }

}