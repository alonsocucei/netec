
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteJDBCEjemplo {

    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/RH";
        String username = "user01";
        String password = "secreto";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement stmt = con.createStatement();
            String query = "DELETE FROM Empleados where id=500";
            if (stmt.executeUpdate(query) > 0) {
                System.out.println("Un empleado ha sido eliminado exitosamente");
            }
            String query1 = "select * from Empleados";
            ResultSet rs = stmt.executeQuery(query1);
            // código para verificar que el empleado fue eliminado
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }
}
