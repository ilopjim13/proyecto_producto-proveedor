package org.example.repository

import org.example.entityManagerFact.EntityManagerFact
import org.example.model.Producto
import org.example.model.Proveedor

class ProveedorRepository {

    fun insert(prov: Proveedor) {
        val em = EntityManagerFact.generate()
        em.transaction.begin()

        try {
            em.persist(prov)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }

    fun select(id:Int) : Proveedor? {
        val em = EntityManagerFact.generate()
        var prov: Proveedor? = null

        em.transaction.begin()
        try {
            prov = em.find(Proveedor::class.java,id)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
        return prov
    }

    fun selectAll():MutableList<Proveedor>  {
        val em = EntityManagerFact.generate()
        var lista:MutableList<Proveedor> = mutableListOf()

        em.transaction.begin()
        try {
            lista = em.createQuery("FROM Departamento", Proveedor::class.java).resultList
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
        return lista
    }

    fun updateName(id:Int, nombreCambiado:String) {
        val em = EntityManagerFact.generate()
        val prov: Proveedor?

        em.transaction.begin()
        try {
            prov = em.find(Proveedor::class.java,id)
            prov.nombre = nombreCambiado
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }

    fun updateDir(id:Int, dir:String) {
        val em = EntityManagerFact.generate()
        val prov: Proveedor?

        em.transaction.begin()
        try {
            prov = em.find(Proveedor::class.java,id)
            prov.direccion = dir
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }

    fun delete(id:String) {
        val em = EntityManagerFact.generate()
        val producto: Producto?

        em.transaction.begin()
        try {
            producto = em.find(Producto::class.java,id)
            em.remove(producto)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }

}