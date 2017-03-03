
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SelectJDBCEjemplo {

    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/RH";
        String username = "user01";
        String password = "secreto";
        String query = "SELECT * FROM Empleados";
        
        try (Connection con = // try-catch con recursos
                DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while (rs.next()) {
                int empID = rs.getInt("Id");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                Date fechaNac = rs.getDate("FechaNac");
                float sueldo = rs.getFloat("Sueldo");
                System.out.println("ID: " + empID + "\n"
                        + "Nombre: " + nombre + " " + apellido + "\n"
                        + "Fecha de nacimiento: " + fechaNac + "\n"
                        + "Sueldo: " + sueldo);
            } // fin del while
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        } // fin del try-catch con recursos
    }
}
