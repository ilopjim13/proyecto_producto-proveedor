package org.example.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "proveedores")
class Proveedor(
    @Id
    val id:Long,
    @Column(name = "nombre")
    val nombre:String,
    @Column(name = "direccion")
    val direccion :String,
    @OneToMany(mappedBy = "proveedor")
    val productos:List<Producto>
) : IElement {
}