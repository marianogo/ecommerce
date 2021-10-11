package com.tul.ecommerce.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.tul.ecommerce.dto.ItemOrderStatus
import java.util.*
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class ItemOrder (

    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    var product: Product = Product(),

    var cantidad: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    var purchaseOrder: PurchaseOrder = PurchaseOrder(),

    var statusOrder : ItemOrderStatus = ItemOrderStatus.PENDING
)
