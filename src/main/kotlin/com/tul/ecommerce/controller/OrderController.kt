package com.tul.ecommerce.controller


import com.tul.ecommerce.model.ItemOrder
import com.tul.ecommerce.model.PurchaseOrder
import com.tul.ecommerce.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService){

    @GetMapping("/{orderId}/checkout")
    fun checkout(@PathVariable orderId: UUID): ResponseEntity<PurchaseOrder>{
        return ResponseEntity(orderService.checkout(orderId),HttpStatus.OK)
    }

    @GetMapping()
    fun getAllOrders(): ResponseEntity<List<PurchaseOrder>>{
       return ResponseEntity(orderService.findAll(),HttpStatus.OK)
    }

    @PostMapping()
    fun postOrder(@RequestBody order:PurchaseOrder):ResponseEntity<PurchaseOrder>{
        return ResponseEntity(orderService.save(order),HttpStatus.CREATED)
    }

    @DeleteMapping("/{orderId}")
    fun deleteOrder(@PathVariable orderId: UUID){
        orderService.delete(orderId)
    }

    @GetMapping("/{orderId}/orderItems")
    fun getAllOrderItems(@PathVariable orderId: UUID):ResponseEntity<MutableList<ItemOrder>>{
        return ResponseEntity(orderService.getAllOrderItems(orderId),HttpStatus.OK)
    }

    @PostMapping("/{orderId}/orderItems")
    fun saveOrderItem(@PathVariable orderId: UUID,@RequestBody itemOrder: ItemOrder):ResponseEntity<PurchaseOrder>{
        return ResponseEntity(orderService.saveOrderItem(orderId,itemOrder),HttpStatus.CREATED)
    }

    @PutMapping("/{orderId}/orderItems/{orderItemId}")
    fun updateOrderItem(@PathVariable orderId: UUID,@PathVariable orderItemId: UUID,@RequestBody itemOrder: ItemOrder):ResponseEntity<PurchaseOrder>{
        return ResponseEntity(orderService.updateOrderItem(orderId,orderItemId,itemOrder), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/{orderId}/orderItems/{orderItemId}")
    fun deleteOrderItem(@PathVariable orderId: UUID,@PathVariable orderItemId: UUID):ResponseEntity<String>{
        orderService.deleteOrderItem(orderId,orderItemId)
        return ResponseEntity("borrado $orderId $orderItemId",HttpStatus.OK)
    }
}
