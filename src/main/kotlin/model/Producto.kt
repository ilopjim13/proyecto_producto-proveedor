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
class Producto(
    @Column
    val categoria:String,
    @Column
    val nombre:String,
    @Column
    val descripcion:String,
    @Column
    val precioSinIva:Float,
    @Column
    val stock:Int,
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    val proveedor:Proveedor,
    ) : IElement {

    @Column
    val fechaAlta: Date = Date()
    @Column
    val precioIva:Float = precioSinIva * 1.21f
    @Id
    val id:String = generateId()


    private fun generateId():String {
        var idGenerate = ""
        categoria.forEachIndexed { index, c ->
            if (index < 3) idGenerate += c
        }
        nombre.forEachIndexed { index, c ->
            if (index < 3) idGenerate += c
        }
        proveedor.nombre.forEachIndexed { index, c ->
            if (index < 3) idGenerate += c
        }
        return idGenerate
    }

}