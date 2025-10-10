import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo implements Serializable {

    private String modelo;
    private String marca;
    private int ano;
    private String descripcio;

    // ✅ Constructor que carga la lista desde la BD solo cuando se necesite (no al declarar)
    public Vehiculo() {
    }

    public Vehiculo(String modelo, String marca, int ano, String descripcio) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.descripcio = descripcio;
    }


    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getDescripcio() { return descripcio; }
    public void setDescripcio(String descripcio) { this.descripcio = descripcio; }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }

    public void guardarObjecto(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(this);
            System.out.println("Vehículo guardado correctamente en " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void escribirObjeto(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            Vehiculo vehiculo = (Vehiculo) ois.readObject();
            this.modelo = vehiculo.modelo;
            this.marca = vehiculo.marca;
            this.ano = vehiculo.ano;
            this.descripcio = vehiculo.descripcio;
            System.out.println("Vehículo cargado correctamente desde " + ruta);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar objeto: " + e.getMessage());
        }
    }

    public static void insertarVehiculo(Vehiculo vehiculo) {
        String consulta = "INSERT INTO vehiculo (modelo, marca, ano, descripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setString(1, vehiculo.getModelo());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setInt(3, vehiculo.getAno());
            stmt.setString(4, vehiculo.getDescripcio());

            stmt.executeUpdate();
            System.out.println("Insertado en BD: " + vehiculo.getModelo());
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }


    public List<Vehiculo> leer() {
        List<Vehiculo> garaje = new ArrayList<>();
        String consulta = "select * from vehiculo";

        try (Connection conn = Conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getString("descripcion")
                );
                garaje.add(vehiculo);
            }

        } catch (SQLException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return garaje;
    }

    public void vehiculoXML() {
        List<Vehiculo> garaje = leer();

        try {
            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            XMLStreamWriter xsw = xof.createXMLStreamWriter(new FileWriter("vehiculos.xml"));

            xsw.writeStartDocument("1.0");
            xsw.writeStartElement("vehiculos");

            for (Vehiculo vehiculo : garaje) {
                xsw.writeStartElement("vehiculo");

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
                xsw.writeCharacters(vehiculo.getDescripcio());
                xsw.writeEndElement();

                xsw.writeEndElement();
            }

            xsw.writeEndElement();
            xsw.writeEndDocument();
            xsw.close();

            System.out.println("Archivo XML creado correctamente: vehiculos.xml");

        } catch (XMLStreamException | IOException e) {
            System.out.println("Error al crear el XML: " + e.getMessage());
        }
    }
}
