package com.tul.ecommerce.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Cliente(

    @Id val id: UUID = UUID.randomUUID()
)
