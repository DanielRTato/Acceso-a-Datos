package ReadWrite;

import model.AdeptaSororitas;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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


    public void leerXML(String ruta) {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        try (FileInputStream fis = new FileInputStream(ruta)) {
            XMLStreamReader reader = xif.createXMLStreamReader(fis);
            String nome = "";
            String puntos = "";
            String codigo = "";

            while (reader.hasNext()) {
                int event = reader.next();

                if (event == XMLStreamConstants.START_ELEMENT) {
                    String elemento = reader.getLocalName();

                    if (elemento.equals("AdeptaSororita")) {
                        codigo = reader.getAttributeValue(null, "cod");
                    } else if (elemento.equals("nome")) {
                        nome = reader.getElementText().trim();
                    } else if (elemento.equals("puntos")) {
                        puntos = reader.getElementText().trim();
                    }
                }

                else if (event == XMLStreamConstants.END_ELEMENT && reader.getLocalName().equals("AdeptaSororita")) {
                    System.out.println("Código: " + codigo);
                    System.out.println("Nome: " + nome);
                    System.out.println("Puntos: " + puntos);
                    System.out.println("-----------------------");

                    // Reiniciar variables
                    nome = "";
                    puntos = "";
                    codigo = "";
                }
            }
            reader.close();
            System.out.println("Lectura del XML completada correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo XML: " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Error al leer el XML: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}
