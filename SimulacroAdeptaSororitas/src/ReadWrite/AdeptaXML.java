package ReadWrite;

import model.AdeptaSororitas;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

            System.out.println("Archivo xml creado correctamente");

        } catch (Exception e) {
            System.out.println("Error al generar el XML: " + e.getMessage());
        }
    }

    /**
     * Muestra el contenido de un archivo XML pasado por parámetro
     * @param ruta
     */
    public void leerXML (String ruta) {
        XMLInputFactory xif = XMLInputFactory.newFactory();

        try {
            XMLStreamReader reader = xif.createXMLStreamReader(new FileInputStream(ruta));

            String nome = "";
            String puntos = "";
            String codigo = "";

            while (reader.hasNext()) {
                int event = reader.next();

                if (event == XMLStreamConstants.START_ELEMENT) {
                    String elemento = reader.getLocalName();

                    // Si es <unidad>, leer su atributo "codigo"
                    if (elemento.equals("AdeptaSororita")) {
                        codigo = reader.getAttributeValue(null, "cod");
                    } else if (elemento.equals("nome")) {
                        nome = reader.getElementText().trim(); // lee directamente el texto dentro de la etiqueta
                    } else if (elemento.equals("puntos")) {
                        puntos = reader.getElementText().trim();
                    }
                }

                // 🔹 Fin de un elemento </unidad>
                else if (event == XMLStreamConstants.END_ELEMENT) {
                    if (reader.getLocalName().equals("AdeptaSororita")) {
                        System.out.println("Código: " + codigo);
                        System.out.println("Nome: " + nome);
                        System.out.println("Puntos: " + puntos);
                        System.out.println("-----------------------");

                        // Reiniciar variables para la siguiente unidad
                        nome = "";
                        puntos = "";
                        codigo = "";
                    }
                }
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println(" No se encontró el archivo XML: " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println(" Error al leer el XML: " + e.getMessage());
        }


    }
}
