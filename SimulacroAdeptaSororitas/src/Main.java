import DAO.AdeptaDAO;
import DAO.Conexion;
import DAO.SpaceMarineDAO;
import ReadWrite.AdeptaXML;
import ReadWrite.Deserializar;
import ReadWrite.LeerFicheroCodigos;
import ReadWrite.Serializar;
import model.AdeptaSororitas;
import model.SpaceMarine;
import util.CalculosEjercitos;
import util.CalculosMarines;
import util.CalculosSororitas;

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


        // Ejemplo de coger una parte de un documento y buscarlo en la BD
        for (int i = 0; i < 3; i++) {  // Math.min(3, codigos.size()) evita errores si el archivo tiene menos de 3 códigos
            int cod = codigos.get(i);
            AdeptaSororitas as = dao.buscarPorCodigo(cod);
            if (as != null) {
                System.out.println(as.getNome() + " - " + as.getPuntos());
            }
        }

        //Caluclar la media de puntos con una consulta
        AdeptaDAO adeptaDAO = new AdeptaDAO();
        adeptaDAO.mediaPuntos();


        // Calcular la media por una lista
        double media = 0;
        int total = 0;

        for (AdeptaSororitas s : adeptas) {
            media += s.getPuntos();
            total++;
        }

        if (total > 0) media /= total;
        System.out.println("Media de puntos: " + media);


        // Mostrar toda la tabla de la BD
        SpaceMarineDAO Spacedao = new SpaceMarineDAO();

        // Leer todos de la BD
        List<SpaceMarine> marines = Spacedao.obtenerTodos();

        System.out.println("📋 Unidades de Space Marines:");
        for (SpaceMarine m : marines) {
            System.out.println(m);
        }



        AdeptaDAO daoSor = new AdeptaDAO();
        SpaceMarineDAO daoMar = new SpaceMarineDAO();

        List<AdeptaSororitas> sororitas = daoSor.obtenerTodas();
        List<SpaceMarine> m = Spacedao.obtenerTodos();

        double mediaSor = CalculosSororitas.calcularMediaPuntos(sororitas);
        double mediaMar = CalculosMarines.calcularMediaPuntos(marines);
        double mediaAmbos = CalculosEjercitos.CalcularMediaEjercitos(sororitas, marines);

        System.out.println("------------------------------------------");
        CalculosEjercitos.compararEjercitos(mediaSor, mediaMar);
        System.out.printf("Media total combinada: %.2f%n", mediaAmbos);
        System.out.println("------------------------------------------");

        SpaceMarineDAO smdao = new SpaceMarineDAO();
        SpaceMarine spaceMarine = new SpaceMarine(4, "liada", 250);

        //smdao.insertarMarine(spaceMarine);
        //smdao.deleteMarine(10);
        smdao.actualizarMarine(spaceMarine);






    }

}
