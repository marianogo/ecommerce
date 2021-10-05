package com.tul.ecommerce.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class ItemOrder (

    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    val producto: Producto = Producto(),

    val cantidad: Int = 0,

    val precio: BigDecimal = BigDecimal(0),

    @ManyToOne
    val purchaseOrder: PurchaseOrder = PurchaseOrder()
)
