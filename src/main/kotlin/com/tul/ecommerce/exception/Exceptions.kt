package com.tul.ecommerce.exception


class ProductNotFoundException(override val message: String?) : Exception(message)

class PurchaseOrderNotExistException(override val message: String?) : Exception(message)
