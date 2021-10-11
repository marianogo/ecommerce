package com.tul.ecommerce.service


import com.tul.ecommerce.dto.ItemOrderStatus
import com.tul.ecommerce.exception.PurchaseOrderNotExistException
import com.tul.ecommerce.model.ItemOrder
import com.tul.ecommerce.model.PurchaseOrder
import com.tul.ecommerce.repository.OrderItemRepository
import com.tul.ecommerce.repository.PurchaseOrderRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Predicate

@Service
class OrderService(private val purchaseOrderRepository: PurchaseOrderRepository,
                   private val orderItemRepository: OrderItemRepository
) {

    fun findAll(): List<PurchaseOrder> = purchaseOrderRepository.findAll()

    fun save(order: PurchaseOrder): PurchaseOrder {
        return purchaseOrderRepository.save(order)
    }

    fun checkout(orderId: UUID): PurchaseOrder{
        var purchaseOrderSaved = purchaseOrderRepository.findById(orderId).get()

        //Sum of all item price
        var totalAmountItems: Float = purchaseOrderSaved.items.fold(0.0F) { acc, itemOrder ->
            val precioItem = itemOrder.product.price
            val qtyItem = itemOrder.cantidad
            if(itemOrder.product.discount) {
                acc + ((precioItem / 2F) * qtyItem)
            }else{
                acc + (precioItem * qtyItem)
            }
        }

        purchaseOrderSaved.totalAmount = totalAmountItems

        // to state completed
        purchaseOrderSaved.items.forEach { it.statusOrder = ItemOrderStatus.COMPLETED }

        return purchaseOrderRepository.save(purchaseOrderSaved)
    }

    fun delete(orderId: UUID) {
         purchaseOrderRepository.deleteById(orderId)
    }

    fun getAllOrderItems(orderId: UUID):MutableList<ItemOrder>{
        return purchaseOrderRepository.findById(orderId).get().items
    }

    fun saveOrderItem(orderId: UUID,itemOrder: ItemOrder):PurchaseOrder{

        var purchaseOrder = purchaseOrderRepository.findById(orderId).get()
        purchaseOrder.items.add(itemOrder)
        itemOrder.purchaseOrder = purchaseOrder
        purchaseOrderRepository.save(purchaseOrder)
        orderItemRepository.save(itemOrder)

        return purchaseOrder

    }

    fun updateOrderItem(orderId: UUID,orderItemId: UUID, itemOrder: ItemOrder): PurchaseOrder{

        var purchaseOrderSaved = purchaseOrderRepository.findById(orderId).get()
        var orderItemSaved = orderItemRepository.findById(orderItemId).get()
        orderItemSaved.cantidad = itemOrder.cantidad
        orderItemRepository.save(orderItemSaved)

        return purchaseOrderRepository.save(purchaseOrderSaved)
    }

    fun deleteOrderItem(orderId: UUID,orderItemId: UUID){

        var purchaseOrderSaved = purchaseOrderRepository.findById(orderId).get()
        val itemOrderSaved = orderItemRepository.findById(orderItemId).get()
        purchaseOrderSaved.items.remove(itemOrderSaved)

        purchaseOrderRepository.save(purchaseOrderSaved)

    }
}

