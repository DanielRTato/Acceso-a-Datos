import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SerializacionVehiculo implements Serializable {

    public void serializarVehiculo (String ruta) {
        List<Vehiculo> garaje = new ArrayList<>();
        String consulta = "select * from vehiculo";

        try (Connection conn = Conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getString("descripcion")
                );
                vehiculo.setIdd(rs.getInt("id"));
                garaje.add(vehiculo);
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
            oos.writeObject(garaje);
            System.out.println("Serializacion terminada");
            oos.close();
        } catch (SQLException | IOException e) {
            System.out.println("Error al Serializar los vehiculo:" + e);

        }
    }

    public void desSerializarVehiculo (String ruta) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));
            List<Vehiculo> garaje = (List<Vehiculo>)  ois.readObject();
            System.out.println("Desearilazion de vehiculos correcta");
            for (Vehiculo v  : garaje) {
                System.out.println(v);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al desearilazar los vehiculos: " + e);
        }
    }
}


