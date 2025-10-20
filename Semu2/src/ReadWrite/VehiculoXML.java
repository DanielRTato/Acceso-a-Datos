package ReadWrite;

import model.Vehiculo;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.List;

public class VehiculoXML {

    public static void crearVehiculoXML (List<Vehiculo> listaVehiculo, String ruta) {
        try {
            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            XMLStreamWriter xsw = xof.createXMLStreamWriter(new FileWriter(ruta));

            xsw.writeStartDocument("1.0");
            xsw.writeStartElement("vehiculos");

            for (Vehiculo vehiculo : listaVehiculo) {
                xsw.writeStartElement("vehiculo");
                xsw.writeAttribute("id", String.valueOf(vehiculo.getId()));

                xsw.writeStartElement("modelo");
                xsw.writeCharacters(vehiculo.getModelo());
                xsw.writeEndElement();

                xsw.writeStartElement("marca");
                xsw.writeCharacters(vehiculo.getMarca());
                xsw.writeEndElement();

                xsw.writeStartElement("ano");
                xsw.writeCharacters(String.valueOf(vehiculo.getAno()));
                xsw.writeEndElement();

                xsw.writeStartElement("descripcion");
                xsw.writeCharacters(vehiculo.getDescripcion());
                xsw.writeEndElement();

                xsw.writeEndElement(); // </vehiculo>
            }
            xsw.writeEndElement(); // </vehiculos>
            xsw.writeEndDocument();
            xsw.flush();
            xsw.close();

            System.out.println("Archivo xml creado correctamente");


        } catch (Exception e) {
            System.out.println("Error al generar el XML: " + e.getMessage());
        }
    }
}
