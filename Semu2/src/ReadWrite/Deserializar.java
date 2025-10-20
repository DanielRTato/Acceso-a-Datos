package ReadWrite;

import model.Vehiculo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializar {

    public static void deSerializarVehiculo (String ruta) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));
            List<Vehiculo> listaVehiculo = (List<Vehiculo>) ois.readObject();
            System.out.println("Deserializacion de Vehiculo correcta");

            for (Vehiculo vehiculo : listaVehiculo) {
                System.out.println(vehiculo);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar Vehiculo: " + e.getMessage());
        }
    }
}
