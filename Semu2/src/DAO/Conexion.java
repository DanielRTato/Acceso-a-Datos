package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:postgresql://192.168.0.28:5432/probas";
    private static final String user = "postgres";
    private static final String password = "admin";

    public static Connection conexion() {
        try {
            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("Error en la conexion a la base de datos: " + e.getMessage());
            return null;
        }
    }

}
