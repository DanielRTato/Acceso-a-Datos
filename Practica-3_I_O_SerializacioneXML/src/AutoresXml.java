import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AutoresXml {
    public static void main(String[] args) {
        try {
            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            XMLStreamWriter xsw = xof.createXMLStreamWriter(new FileWriter("autores.xml"));
            xsw.writeStartDocument("1.0");
            xsw.writeStartElement("autores");

            xsw.writeStartElement("autor");
            xsw.writeAttribute("codigo","a1");
            xsw.writeStartElement("nome");
            xsw.writeCharacters("Alexandre Dumas");
            xsw.writeEndElement();
            xsw.writeStartElement("titulo");
            xsw.writeCharacters("El conde de monstecristo");
            xsw.writeEndElement();
            xsw.writeStartElement("titulo");
            xsw.writeCharacters("Los miserables");
            xsw.writeEndElement();
            xsw.writeEndElement();

            xsw.writeStartElement("autor");
            xsw.writeAttribute("codigo","a2");
            xsw.writeStartElement("nome");
            xsw.writeCharacters("Fiodor Dostoyevski");
            xsw.writeEndElement();
            xsw.writeStartElement("titulo");
            xsw.writeCharacters("El idiota");
            xsw.writeEndElement();
            xsw.writeStartElement("titulo");
            xsw.writeCharacters("Noches blancas");
            xsw.writeEndElement();
            xsw.writeEndElement();
            xsw.writeEndElement();
            xsw.writeEndDocument();

            xsw.close();

        } catch (XMLStreamException | IOException e) {
            System.out.println("Error: " + e);


        }
    }
}