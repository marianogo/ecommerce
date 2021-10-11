package com.tul.ecommerce.model


class ProductForm(

    var name: String = "",
    var sku: String = "",
    var description: String = "",
    var price: Float = 0.0F,
    var discount: Boolean = false
)

fun ProductForm.toPersonRecord() = Product(

    sku = sku,
    name = name,
    description = description,
    price = price,
    discount = discount

)
