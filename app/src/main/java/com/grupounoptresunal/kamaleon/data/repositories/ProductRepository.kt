package com.grupounoptresunal.kamaleon.data.repositories

import com.grupounoptresunal.kamaleon.data.mocks.ProductMocks
import com.grupounoptresunal.kamaleon.data.models.Product

class ProductRepository(private val dataSource: ProductMocks) {
    suspend fun loadproducts (): List<Product>{
        return dataSource.loadProducts()
    }
}