package com.tul.ecommerce.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob
import javax.validation.constraints.NotBlank

@Entity
data class Product(

    @Id val id: UUID = UUID.randomUUID(),

    @field:NotBlank(message = "{product_name.required}")
    var name: String = "",
    @field:NotBlank(message = "{product_sku.required}")
    var sku: String = "",
    @Lob
    var description: String = "",
    var price: Float = 0.0f,
    var discount: Boolean = false

)
