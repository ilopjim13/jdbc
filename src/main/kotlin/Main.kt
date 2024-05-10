import dao.ProductDAO
import output.Console
import product.Product

fun main() {

    val console = Console()

    val product = Product(3, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    val productId = ProductDAO(console).createProduct(product)

    println("Product ID: $productId")

}