package com.tul.ecommerce.controller

import com.tul.ecommerce.exception.ProductNotFoundException
import com.tul.ecommerce.model.ProductForm
import com.tul.ecommerce.model.Product
import com.tul.ecommerce.model.toPersonRecord
import com.tul.ecommerce.service.ProductoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotEmpty

@RestController
@RequestMapping("/api/products")
class ProductController(private val productoService: ProductoService) {

    @GetMapping("")
    fun getAllProductos():ResponseEntity<Collection<Product>>{
        return ResponseEntity(productoService.getAllProducts(),HttpStatus.OK)
    }

    @PostMapping()
    fun createProducto(@RequestBody producto: Product): ResponseEntity<Product>{
        return ResponseEntity(productoService.save(producto),HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteProducto(@PathVariable id: UUID): ResponseEntity<Product?> {
        if (productoService.existById(id)) {
            productoService.deleteById(id)
            return ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun updateProducto(@PathVariable id: UUID,  @RequestBody productForm: ProductForm): ResponseEntity<Product?> {


        return ResponseEntity(productoService.update(id, productForm), HttpStatus.OK)

    }

}
