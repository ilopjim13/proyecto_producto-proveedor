package org.example.repository

import org.example.entityManagerFact.EntityManagerFact
import org.example.model.Producto
import org.example.model.Usuario

class ProductoRepository {

    fun insert(producto: Producto) {
        val em = EntityManagerFact.generate()
        em.transaction.begin()

        try {
            em.persist(producto)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }

    fun select(id:String) : Producto? {
        val em = EntityManagerFact.generate()
        var producto: Producto? = null

        em.transaction.begin()
        try {
            producto = em.find(Producto::class.java,id)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
        return producto
    }

    fun updateName(id:String, nombreCambiado:String) {
        val em = EntityManagerFact.generate()
        val producto: Producto?

        em.transaction.begin()
        try {
            producto = em.find(Producto::class.java,id)
            producto.nombre = nombreCambiado
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }

    fun updateStock(id:String, stock:Int) {
        val em = EntityManagerFact.generate()
        val producto: Producto?

        em.transaction.begin()
        try {
            producto = em.find(Producto::class.java,id)
            producto.stock = stock
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }

    fun delete(id:String):Boolean {
        val em = EntityManagerFact.generate()
        val producto: Producto?
        var eliminado = false

        em.transaction.begin()
        try {
            producto = em.find(Producto::class.java,id)
            em.remove(producto)
            em.transaction.commit()
            eliminado = true
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
        return eliminado
    }

}