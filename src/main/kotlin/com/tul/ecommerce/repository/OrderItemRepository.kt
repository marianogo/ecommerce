package com.tul.ecommerce.repository


import com.tul.ecommerce.model.ItemOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrderItemRepository : JpaRepository<ItemOrder, UUID> {

}
