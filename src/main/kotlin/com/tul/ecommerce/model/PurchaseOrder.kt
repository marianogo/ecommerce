package com.tul.ecommerce.model

import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class PurchaseOrder(

    @Id val id:UUID = UUID.randomUUID(),

    var cliente: String = "",

    @OneToMany(mappedBy = "purchaseOrder", cascade = arrayOf(CascadeType.ALL))
    val items: List<ItemOrder> = mutableListOf()
)
