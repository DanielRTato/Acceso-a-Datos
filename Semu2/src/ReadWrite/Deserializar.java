package ReadWrite;

import model.Vehiculo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializar {

    public static void deserializarVehiculo(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {

            List<Vehiculo> listaVehiculos = (List<Vehiculo>) ois.readObject();
            System.out.println("Deserialización de vehículos completada correctamente.");

            for (Vehiculo v : listaVehiculos) {
                System.out.println(v);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Error al deserializar los vehículos: " + e.getMessage());
        }
    }
}
