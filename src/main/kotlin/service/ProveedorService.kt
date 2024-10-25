package org.example.service

import org.example.model.Proveedor
import org.example.repository.ProveedorRepository

class ProveedorService(private val pr: ProveedorRepository) {

    fun comprobarID(id: Int):Proveedor? {
        return pr.select(id)
    }

    fun insert() {

    }
}