import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL  = "jdbc:postgresql://10.0.9.202:5432/probas";
    private static final String USER  = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection conexion() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Succeful connection");

        } catch (SQLException e) {
            System.out.println("Fail to connect to the DataBase: " + e);
        }
        return conn;
    }
}

