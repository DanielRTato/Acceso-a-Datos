import DAO.Conexion;
import ReadWrite.Deserializar;
import ReadWrite.Serializar;

public class Main {
    public static void main(String[] args) {

        Conexion.conexion();

        Serializar escribir = new Serializar();
        escribir.serialarSororitas("SororitasSerial");

        Deserializar leer = new Deserializar();
        leer.deSerializarSororitas("SororitasSerial");



    }

}
