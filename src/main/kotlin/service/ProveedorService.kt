package org.example.service

import org.example.model.Proveedor
import org.example.repository.ProveedorRepository

class ProveedorService(private val pr: ProveedorRepository) {

    fun checkID(id: Long):Proveedor? {
        return pr.select(id)
    }

    fun insert(proveedor:Proveedor){
        pr.insert(proveedor)
    }

    fun selectAll(): MutableList<Proveedor> {
        return pr.selectAll()
    }
}