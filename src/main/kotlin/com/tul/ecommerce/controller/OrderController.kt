package com.tul.ecommerce.controller


import com.tul.ecommerce.model.PurchaseOrder
import com.tul.ecommerce.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService){

    @PostMapping("/checkout")
    fun checkout(): ResponseEntity<String>{
        return ResponseEntity("",HttpStatus.OK)
    }

    @GetMapping()
    fun getAllOrders(): ResponseEntity<List<PurchaseOrder>>{
       return ResponseEntity(orderService.findAll(),HttpStatus.OK)
    }

    @PostMapping()
    fun postOrder(@RequestBody order:PurchaseOrder):ResponseEntity<PurchaseOrder>{
        return ResponseEntity(orderService.save(order),HttpStatus.CREATED)
    }

}
