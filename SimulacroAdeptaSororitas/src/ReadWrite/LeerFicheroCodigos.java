package ReadWrite;

import model.AdeptaSororitas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeerFicheroCodigos {

    public static List<Integer> leerCodigos(String ruta) {
        List<Integer> codigos = new ArrayList<>();

        File archivo = new File(ruta);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe: " + ruta);
            return codigos; // lista vacía
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    try {
                        codigos.add(Integer.parseInt(linea));
                    } catch (NumberFormatException e) {
                        System.out.println("Línea no válida (no es número): " + linea);
                    }
                }
            }
            System.out.println("Fichero leído correctamente. Total códigos: " + codigos.size());
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de códigos: " + e.getMessage());
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


