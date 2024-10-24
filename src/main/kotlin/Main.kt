package org.example

import org.example.entityManagerFact.EntityManagerFact
import org.example.model.Usuario

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val em = EntityManagerFact.generate()

    val usuario = Usuario("pepe", "pepe")

    em.transaction.begin()
    em.persist(usuario)
    em.transaction.commit()
    em.close()


}


