package org.example.repository

import org.example.entityManagerFact.EntityManagerFact
import org.example.model.Usuario

class UsuarioRepository {

    fun insertUser(usuario: Usuario) {
        val em = EntityManagerFact.generate()
        em.transaction.begin()

        try {
            em.persist(usuario)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }

    fun selectUser(nombre:String) :Usuario? {
        val em = EntityManagerFact.generate()
        var user:Usuario? = null

        em.transaction.begin()
        try {
            user = em.find(Usuario::class.java,nombre)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
        return user
    }

    fun updateUserName(nombre:String, nombreCambiado:String) {
        val em = EntityManagerFact.generate()
        var user:Usuario? = null

        em.transaction.begin()
        try {
            user = em.find(Usuario::class.java,nombre)
            user.nombre = nombreCambiado
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }

    fun updateUserPass(nombre:String, pass:String) {
        val em = EntityManagerFact.generate()
        var user:Usuario? = null

        em.transaction.begin()
        try {
            user = em.find(Usuario::class.java,nombre)
            user.password = pass
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }
        em.close()
    }

    fun delete(nombre:String) {
        val em = EntityManagerFact.generate()
        var user:Usuario? = null

        em.transaction.begin()
        try {
            user = em.find(Usuario::class.java,nombre)
            em.remove(user)
            em.transaction.commit()
        } catch (e:Exception) {
            em.transaction.rollback()
        }

        em.close()
    }
}