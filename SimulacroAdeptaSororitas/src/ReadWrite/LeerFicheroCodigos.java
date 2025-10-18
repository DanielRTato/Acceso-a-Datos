package ReadWrite;

import model.AdeptaSororitas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeerFicheroCodigos {

    public static List<Integer> leerCodigos(String ruta) {
        List<Integer> codigos = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String liña;
            while ((liña = br.readLine()) != null) {
                codigos.add(Integer.parseInt(liña.trim()));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de códigos: " + e);
        }
        return codigos;
    }

    // Ejemplo de escribir en un fichero
    public static void escribirPuntosOrdeados(List<AdeptaSororitas> lista, String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (AdeptaSororitas s : lista) {
                pw.println(s.getNome() + " - " + s.getPuntos());
            }
            System.out.println("Ficheiro puntosOrdeados xerado correctamente.");
        } catch (IOException e) {
            System.out.println("Erro ao escribir o ficheiro: " + e.getMessage());
        }
    }

}


