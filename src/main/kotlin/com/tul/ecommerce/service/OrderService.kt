package com.tul.ecommerce.service


import com.tul.ecommerce.model.PurchaseOrder
import com.tul.ecommerce.repository.PurchaseOrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(private val purchaseOrderRepository: PurchaseOrderRepository) {

    fun findAll(): List<PurchaseOrder> = purchaseOrderRepository.findAll()

    fun save(order: PurchaseOrder): PurchaseOrder {


        return purchaseOrderRepository.save(order)
    }
}
