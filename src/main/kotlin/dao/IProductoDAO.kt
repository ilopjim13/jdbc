package dao

import product.Product

interface IProductoDAO {
    fun createProduct(product: Product): Product?
}