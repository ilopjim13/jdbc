package database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.SQLTimeoutException

class DatabaseTimeoutException(val error:String): Exception()
class SqlErrorException(val error:String): Exception()

object Database {
    private const val URL = "jdbc:h2:./default"
    private const val USER = "user"
    private const val PASSWORD = "user"

    init {
        try {
            // Asegurarse de que el driver JDBC de MySQL esté disponible
            Class.forName("org.h2.Driver");
        } catch (e: ClassNotFoundException) {
            e.printStackTrace();
        }
    }

    fun getConnection(): Connection =
        try {
            DriverManager.getConnection(URL, USER, PASSWORD)
        } catch (e: SQLTimeoutException) {
            throw DatabaseTimeoutException("La conexión ha excedido el tiempo de espera permitido.")
        } catch (e: SQLException) {
            throw SqlErrorException("Error de SQL: ${e.message}")
        }

}