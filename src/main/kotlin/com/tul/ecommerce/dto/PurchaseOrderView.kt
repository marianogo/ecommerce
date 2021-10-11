package com.tul.ecommerce.dto

import java.util.*

class PurchaseOrderView (val id:UUID,val cliente:String,val items:MutableList<ItemOrderView>)

class ItemOrderView(val id: UUID,val producto:ProductoView,val cantidad:Int,val statusOrder: ItemOrderStatus)

class ProductoView (val id:UUID,val nombre:String,val sku:String ,val descripcion:String,val precio:Number,val descuento:Boolean)
