import DAO.AdeptaDAO;
import DAO.Conexion;
import ReadWrite.AdeptaXML;
import ReadWrite.Deserializar;
import ReadWrite.Serializar;
import model.AdeptaSororitas;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Conexion.conexion();
        AdeptaDAO dao = new AdeptaDAO();
        List<AdeptaSororitas> adeptas = dao.obtenerTodas();


        Serializar escribir = new Serializar();
        escribir.serialarSororitas("SororitasSerial.dat");

        Deserializar leer = new Deserializar();
        leer.deSerializarSororitas("SororitasSerial.dat");

        AdeptaXML xml = new AdeptaXML();
        xml.crearXML(adeptas, "adeptas.xml");




    }

}
