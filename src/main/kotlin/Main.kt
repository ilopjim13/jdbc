import dao.ProductDAO
import product.Product

fun main() {

    val product = Product(3, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    val productId = ProductDAO().createProduct(product)

    println("Product ID: $productId")

}