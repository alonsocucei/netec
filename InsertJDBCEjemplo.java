
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertJDBCEjemplo {

    public static void main(String[] args) {
        // Definir la "url"
        // el servidor de la base de datos esta en el localhost
        String url = "jdbc:derby://localhost:1527/RH";
        String username = "user01";
        String password = "secreto";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement stmt = con.createStatement();
            String query = "INSERT INTO Empleados VALUES (500, 'Jesus', 'Rodriguez','1957-02-23', 75000)";
            if (stmt.executeUpdate(query) > 0) {
                System.out.println("Se añadió un nuevo empleado");
            }
            String query1 = "select *  from Empleados";
            int recordsUpdated = stmt.executeUpdate(query1);
// código para verificar que el empleado fue añadido
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }
} 
