package ReadWrite;

import model.AdeptaSororitas;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AdeptaXML {

    public void crearXML(List<AdeptaSororitas> lista, String ruta) {
        try {
            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            XMLStreamWriter xsw = xof.createXMLStreamWriter(new FileWriter(ruta));

            xsw.writeStartDocument("1.0");
            xsw.writeStartElement("AdeptaSororitas");

            for (AdeptaSororitas adepta : lista) {
                xsw.writeStartElement("AdeptaSororita");
                xsw.writeAttribute("cod", String.valueOf(adepta.getCod()));


                xsw.writeStartElement("nome");
                xsw.writeCharacters(adepta.getNome());
                xsw.writeEndElement();

                xsw.writeStartElement("puntos");
                xsw.writeCharacters(String.valueOf(adepta.getPuntos()));
                xsw.writeCharacters("\n");
                xsw.writeEndElement();

                xsw.writeEndElement(); // </unidad>
            }

            xsw.writeEndElement(); // </sororitas>
            xsw.writeEndDocument();
            xsw.close();

            System.out.println(" Archivo xml creado correctamente");

        } catch (Exception e) {
            System.out.println("Error al generar el XML: " + e.getMessage());
        }
    }
}
