package com.tul.ecommerce.model

import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class PurchaseOrder(

    @Id val id:UUID = UUID.randomUUID(),

    @OneToMany(mappedBy = "purchaseOrder", cascade = arrayOf(CascadeType.ALL),orphanRemoval = true)
    var items: MutableList<ItemOrder> = mutableListOf(),

    var totalAmount:Float = 0.0F,

    val client: String = ""

)
