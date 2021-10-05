package com.tul.ecommerce.service

import com.tul.ecommerce.repository.ProductoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ProductoServiceTest {

    private val productoRepository: ProductoRepository = mockk(relaxed = true)

    private val productoService = ProductoService(productoRepository)
    @Test
    fun `deberia llamar 1 vez al repository y traer todos los productos`(){
        //given

        //when
        productoService.getAllProductos()

        //then
        verify(exactly = 1){productoRepository.findAll()}
    }

}
