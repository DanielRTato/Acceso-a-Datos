import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


        Connection conn = Conexion.conexion();
        if (conn != null) {
            System.out.println("A conexión funciona");
        }

    }

}