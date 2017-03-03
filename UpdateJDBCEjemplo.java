
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateJDBCEjemplo {

    public static void main(String[] args) {
        // Definir la "url"
        // el servidor de la base de datos esta en el localhost
        String url = "jdbc:derby://localhost:1527/RH";
        String username = "user01";
        String password = "secreto";
        try (Connection con = DriverManager.getConnection(url, username,
                password)) {
            Statement stmt = con.createStatement();
            String query = "UPDATE Empleados SET sueldo = 20000 where id=500";
            
            if (stmt.executeUpdate(query) > 0) {
                System.out.println("Un empleado existente fue actualizado");
            }
            
            String query1 = "select * from Empleados";
            ResultSet rs = stmt.executeQuery(query1);
            // código para verificar que el empleado fue actualizado
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }
}
