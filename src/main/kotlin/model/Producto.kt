package org.example.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.*


@Entity
@Table(name = "producto")
data class Producto(
    @Column
    val categoria:String,
    @Column
    var nombre:String,
    @Column
    val descripcion:String,
    @Column
    val precioSinIva:Float,
    @Column
    var stock:Int,
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    val proveedor:Proveedor,
    ) {

    @Column
    val fechaAlta: Date = Date()
    @Column
    val precioIva:Float = precioSinIva * 1.21f
    @Id
    val id:String = generateId()




}