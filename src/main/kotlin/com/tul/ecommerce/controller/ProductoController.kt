package com.tul.ecommerce.controller

import com.tul.ecommerce.model.Producto
import com.tul.ecommerce.service.ProductoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/productos")
class ProductoController(private val productoService: ProductoService) {

    @GetMapping("")
    fun getAllProductos():ResponseEntity<Collection<Producto>>{
        return ResponseEntity(productoService.getAllProductos(),HttpStatus.OK)
    }

    @PostMapping()
    fun createProducto(@RequestBody producto: Producto): ResponseEntity<Producto>{
        return ResponseEntity(productoService.save(producto),HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteProducto(@PathVariable id: UUID): ResponseEntity<Producto?> {
        if (productoService.existById(id)) {
            productoService.deleteById(id)
            return ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun updateProducto(@PathVariable id: UUID, @RequestBody toUpdateProducto: Producto): ResponseEntity<Producto?> {
        if (productoService.existById(id)) {
            val savedProducto = productoService.findById(id).get()
            val updatedProducto = Producto(
                id = id,
                nombre = if (toUpdateProducto.nombre != "") toUpdateProducto.nombre else savedProducto.nombre,
                sku = if (toUpdateProducto.sku != "") toUpdateProducto.sku else savedProducto.sku,
                descripcion = if (toUpdateProducto.descripcion != "") toUpdateProducto.descripcion else savedProducto.descripcion,
                precio = if (toUpdateProducto.precio != 0) toUpdateProducto.precio else savedProducto.precio,
                descuento = if (toUpdateProducto.descuento) toUpdateProducto.descuento else false

            )
            return ResponseEntity(productoService.save(updatedProducto), HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}
