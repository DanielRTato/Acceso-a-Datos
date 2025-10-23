package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:postgresql://192.168.0.28:5432/probas";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection conexion() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa con la base de datos.");
            return conn;

        } catch (SQLException e) {
            System.out.println("Error en la conexion a la base de datos: " + e.getMessage());
            return null;
        }
    }

}
