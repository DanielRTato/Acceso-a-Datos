import DAO.AdeptaDAO;
import DAO.Conexion;
import ReadWrite.AdeptaXML;
import ReadWrite.Deserializar;
import ReadWrite.LeerFicheroCodigos;
import ReadWrite.Serializar;
import model.AdeptaSororitas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Conexión a la base de datos
        Conexion.conexion();
        AdeptaDAO dao = new AdeptaDAO();

        List<AdeptaSororitas> adeptas = dao.obtenerTodas();

        // Serializar y deserializar
        Serializar escribir = new Serializar();
        escribir.serialarSororitas("SororitasSerial.dat");

        Deserializar leer = new Deserializar();
        System.out.println("[Mostrando contenido del archivo Serializado:]");
        leer.deSerializarSororitas("SororitasSerial.dat");

        System.out.println("-------------------------------------------------------");

        // Crear y leer del XML
        AdeptaXML xml = new AdeptaXML();
        xml.crearXML(adeptas, "adeptas.xml");
        System.out.println("[Mostrando contenido del XML:]");
        xml.leerXML("adeptas.xml");

        System.out.println("------------------------------------------");

        // Leer los códigos desde el archivo codigosUnidades.txt
        System.out.println("Leyendo archivo codigosUnidades.txt");
        List<Integer> codigos = LeerFicheroCodigos.leerCodigos("codigosUnidades.txt"); // Meter en la lista los codígos del archivo

        // Buscar las unidades correspondientes en la BD
        List<AdeptaSororitas> listaAdeptas = new ArrayList<>();
        for (int cod : codigos) {
            AdeptaSororitas s = dao.buscarPorCodigo(cod);
            if (s != null) listaAdeptas.add(s);
        }

        // Ordenar por puntos descendentes
        listaAdeptas.sort(Comparator.comparingInt(AdeptaSororitas::getPuntos).reversed());

        // Mostrar por consola
        System.out.println("Unidades ordenadas por puntos (según archivo codigosUnidades.txt):");
        for (AdeptaSororitas s : listaAdeptas) {
            System.out.println(s.getNome() + " - " + s.getPuntos());
        }

        // Escribir en el fichero puntosOrdeados.txt
        try (PrintWriter pw = new PrintWriter(new FileWriter("puntosOrdeados.txt"))) {
            for (AdeptaSororitas s : listaAdeptas) {
                pw.println(s.getNome() + " - " + s.getPuntos());
            }
            System.out.println("\nFicheiro puntosOrdeados xerado correctamente.");
        } catch (IOException e) {
            System.out.println(" Erro ao escribir o ficheiro: " + e.getMessage());
        }









    }

}
