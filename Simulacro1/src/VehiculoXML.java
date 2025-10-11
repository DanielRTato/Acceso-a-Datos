import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoXML {
    public void vehiculoAXML() {
        VehiculoService vs = new VehiculoService();
        List<Vehiculo> garaje = vs.selectVehiculo();
        try {
            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            XMLStreamWriter xsw = xof.createXMLStreamWriter(new FileWriter("vehiculos.xml"));

            xsw.writeStartDocument("1.0");
            xsw.writeStartElement("vehiculos");

            for (Vehiculo v : garaje) {
                xsw.writeStartElement("vehiculo");

                xsw.writeAttribute("id", String.valueOf(v.getIdd()));

                xsw.writeStartElement("modelo");
                xsw.writeCharacters(v.getModelo());
                xsw.writeEndElement();

                xsw.writeStartElement("marca");
                xsw.writeCharacters(v.getMarca());
                xsw.writeEndElement();

                xsw.writeStartElement("ano");
                xsw.writeCharacters(String.valueOf(v.getAno()));
                xsw.writeEndElement();

                xsw.writeStartElement("descripcion");
                xsw.writeCharacters(v.getDescripcion());
                xsw.writeEndElement();

                xsw.writeEndElement();
            }

            xsw.writeEndElement();
            xsw.writeEndDocument();
            xsw.close();

            System.out.println(" Archivo xml creado correctamente");

        } catch (XMLStreamException | IOException e) {
            System.out.println("Error al generar el XML: " + e);
        }
    }
}

