package controlador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO LEGION 5
 */
public class Conexion {

    private static final String user = "USER3C";
    private static final String pass = "admin123";
    private static final String port = "jdbc:oracle:thin:@localhost:1521:XE";
    public static Connection con;

    public static Connection getConexion() {
        if (con == null) {
            conectar();
        }
        return con;
    }

    public static Connection conectar() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(port, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con != null) {
                System.out.println("Conexion establecida");
            }
        } // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion" + e);
        }
        return con;
    }

    public static void main(String[] args) {
        try {
            Connection cn = Conexion.getConexion();
        } catch (Exception e) {
        }
    }
}
