package com.tul.ecommerce.service

import com.tul.ecommerce.model.Producto
import com.tul.ecommerce.repository.ProductoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductoService(private val productoRepository: ProductoRepository){

    fun getAllProductos(): Collection<Producto> = productoRepository.findAll()

    fun save(producto: Producto): Producto = productoRepository.save(producto)

    fun existById(id:UUID)  = productoRepository.existsById(id)

    fun deleteById(id: UUID) = productoRepository.deleteById(id)

    fun findById(id: UUID) = productoRepository.findById(id)
}
