package com.tul.ecommerce.service

import com.tul.ecommerce.exception.ProductNotFoundException
import com.tul.ecommerce.model.Product
import com.tul.ecommerce.model.ProductForm
import com.tul.ecommerce.repository.ProductoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductoService(private val productoRepository: ProductoRepository){

    fun getAllProducts(): Collection<Product> = productoRepository.findAll()

    fun save(producto: Product): Product = productoRepository.save(producto)

    fun existById(id:UUID)  = productoRepository.existsById(id)

    fun deleteById(id: UUID) = productoRepository.deleteById(id)

    fun findById(id: UUID) = productoRepository.findById(id)

    fun update(id: UUID, productForm: ProductForm): Product {

        if (existById(id)) {
            val savedProducto = findById(id).get()
            val updatedProducto = Product(
                id = id,
                name = if (productForm.name != "") productForm.name else savedProducto.name,
                sku = if (productForm.sku != "") productForm.sku else savedProducto.sku,
                description = if (productForm.description != "") productForm.description else savedProducto.description,
                price = if (productForm.price != 0.0F) productForm.price else savedProducto.price,
                discount = if (productForm.discount) productForm.discount else false

            )
            return save(updatedProducto)
        } else {
            throw ProductNotFoundException("Product $id not Found")
        }
    }
}
