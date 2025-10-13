import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:postgresql://10.0.9.202:5432/probas";
    private static final String user = "postgres";
    private static final String password = "admin";

    public static Connection conexion() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Succeful connection");

        } catch (SQLException e) {
            System.out.println("Fail to connect to the DataBase: " + e);
        }
        return conn;
    }
}

