package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "proveedores")
data class Proveedor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?,
    @Column(name = "nombre")
    var nombre:String,
    @Column(name = "direccion")
    var direccion :String,
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "proveedor")
    val productos:List<Producto>
){
    override fun toString(): String {
        return "Id: $id, Nombre: $nombre, Dirección: $direccion, Productos: $productos"
    }
}