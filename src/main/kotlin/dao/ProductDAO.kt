package dao

import database.Database
import product.Product
import java.sql.SQLException

class ProductDAO {

    fun createProduct(product: Product):Product? {
        val sql = "INSERT INTO PRODUCTS (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)"
        try {
            Database.getConnection().use {conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, product.id.toString())
                    stmt.setString(2, product.name)
                    stmt.setString(3, product.price.toString())
                    stmt.setString(4, product.description)
                    stmt.setString(5, product.brand)
                    stmt.setString(6, product.category)
                    val rs = stmt.executeUpdate()
                    if (rs == 1) {
                        return product
                    }else{
                        //console.showMessage("**ERROR** insert query failed! ($rs records inserted)")
                        return null
                    }
                }
            }


        } catch (e: SQLException) {
            //console.showMessage("**ERROR** Insert query failed! (${e.message})")
            return null
        }
    }

}