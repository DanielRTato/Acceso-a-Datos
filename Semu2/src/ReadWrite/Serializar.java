package ReadWrite;

import DAO.Conexion;
import model.Vehiculo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Serializar {

    public static void serializarVehiculo (String ruta) {
        List<Vehiculo> listVehiculo = new ArrayList<>();
        String sql = "select * from vehiculo";

        try (Connection conn = Conexion.conexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getInt("id"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getString("descripcion")
                );
                listVehiculo.add(vehiculo);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
                oos.writeObject(listVehiculo);
                System.out.println(" Serialización completada con éxito en: " + ruta);
            }

        } catch (SQLException | IOException e) {
            System.out.println("Error al serializar las Vehiculos: " + e.getMessage());
        }
    }
}
