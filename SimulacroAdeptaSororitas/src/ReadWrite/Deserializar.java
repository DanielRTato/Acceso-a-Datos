package ReadWrite;

import model.AdeptaSororitas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Deserializar {

    public void deSerializarSororitas(String ruta) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));
            List<AdeptaSororitas> lista = (List<AdeptaSororitas>) ois.readObject();
            System.out.println("Deserializacion de Sororitas realiazado correctamente");

            for (AdeptaSororitas adepta : lista ) {
                System.out.println(adepta);
            }

        } catch (IOException |ClassNotFoundException e) {
            System.out.println("Error al deserializar sororitas: " + e.getMessage());
        }

    }
}
