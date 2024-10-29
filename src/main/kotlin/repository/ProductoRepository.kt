package org.example.repository

import org.example.entityManagerFact.EntityManagerFact
import org.example.model.Producto

class ProductoRepository {

    fun insert(producto: Producto) {
        val em = EntityManagerFact.generate()
        em.transaction.begin()
        try {
            em.persist(producto)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
            em.close()
        }
        em.close()
    }

    fun select(id:String) : Producto? {
        val em = EntityManagerFact.generate()
        var producto: Producto? = null
        try {
            producto = em.find(Producto::class.java,id)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
            em.close()
        }

        em.close()
        return producto
    }

    fun selectWithStock():MutableList<Producto>  {
        val em = EntityManagerFact.generate()
        var lista:MutableList<Producto> = mutableListOf()

        em.transaction.begin()
        try {
            lista = em.createQuery("FROM Producto WHERE stock > 0", Producto::class.java).resultList
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
            em.close()
        }

        em.close()
        return lista
    }

    fun selectWithoutStock():MutableList<Producto>  {
        val em = EntityManagerFact.generate()
        var lista:MutableList<Producto> = mutableListOf()
        em.transaction.begin()
        try {
            lista = em.createQuery("FROM Producto WHERE stock = 0", Producto::class.java).resultList
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
            em.close()
        }
        em.close()
        return lista
    }

    fun updateName(id:String, nombreCambiado:String):Boolean {
        val em = EntityManagerFact.generate()
        val producto: Producto?
        var okey = false
        em.transaction.begin()
        try {
            producto = em.find(Producto::class.java,id)
            producto.nombre = nombreCambiado
            em.transaction.commit()
            okey = true
        } catch (e:Exception) {
            em.transaction.rollback()
            em.close()
        }
        em.close()
        return okey
    }

    fun updateStock(id:String, stock:Int):Boolean {
        val em = EntityManagerFact.generate()
        val producto: Producto?
        var okey = false

        em.transaction.begin()
        try {
            producto = em.find(Producto::class.java,id)
            producto.stock = stock
            em.transaction.commit()
            okey = true
        } catch (e:Exception) {
            em.transaction.rollback()
            em.close()
        }

        em.close()
        return okey
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
            em.close()
        }

        em.close()
        return eliminado
    }
}