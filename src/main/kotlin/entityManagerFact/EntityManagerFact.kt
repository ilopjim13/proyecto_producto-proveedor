package org.example.entityManagerFact

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

object EntityManagerFact {
    private val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("myunidadsql")

    fun generate():EntityManager {
        return emf.createEntityManager()
    }
}