package ReadWrite;

import model.Vehiculo;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.List;

public class VehiculoXML {

    public static void crearVehiculoXML (List<Vehiculo> listaVehiculo, String ruta) {
        try {
            XMLOutputFactory factory  = XMLOutputFactory.newFactory();
            XMLStreamWriter writer  = factory .createXMLStreamWriter(new FileWriter(ruta));

            writer .writeStartDocument("1.0");
            writer .writeStartElement("vehiculos");

            for (Vehiculo vehiculo : listaVehiculo) {
                writer .writeStartElement("vehiculo");
                writer .writeAttribute("id", String.valueOf(vehiculo.getId()));

                writer .writeStartElement("modelo");
                writer .writeCharacters(vehiculo.getModelo());
                writer .writeEndElement();

                writer .writeStartElement("marca");
                writer .writeCharacters(vehiculo.getMarca());
                writer .writeEndElement();

                writer .writeStartElement("ano");
                writer .writeCharacters(String.valueOf(vehiculo.getAno()));
                writer .writeEndElement();

                writer .writeStartElement("descripcion");
                writer .writeCharacters(vehiculo.getDescripcion());
                writer .writeEndElement();

                writer .writeEndElement(); // </vehiculo>
            }
            writer .writeEndElement(); // </vehiculos>
            writer .writeEndDocument();
            writer .flush();
            writer .close();

            System.out.println("Archivo xml creado correctamente");


        } catch (Exception e) {
            System.out.println("Error al generar el XML: " + e.getMessage());
        }
    }
}
