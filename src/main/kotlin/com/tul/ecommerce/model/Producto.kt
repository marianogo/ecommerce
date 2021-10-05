package com.tul.ecommerce.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob

@Entity
data class Producto(

    @Id val id: UUID = UUID.randomUUID(),

    var nombre: String = "",
    var sku: String = "",
    @Lob
    var descripcion: String = "",
    var precio: Number = 0.0f,
    var descuento: Boolean = false

)
