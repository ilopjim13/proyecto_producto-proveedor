package org.example.repository

import org.example.model.IElement

interface IRepository {

    fun insert(element:IElement)
    fun select(id:Int)
    fun update(id:Int)
    fun delete(element: IElement)

}