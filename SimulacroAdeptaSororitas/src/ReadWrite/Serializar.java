package ReadWrite;

import DAO.Conexion;
import model.AdeptaSororitas;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Serializar {

    /**
     * Coge los codigos del fichero pasado por parámetro
     * @param ruta
     * @return una lista con los codigos
     */
    public List<Integer> getListacodigos(String ruta) {
        List<Integer> listaCodigos = new ArrayList<>();
        File file = new File(ruta);

        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;
                while ((linea = br.readLine()) != null) {
                    listaCodigos.add(Integer.parseInt(linea));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return listaCodigos;
    }

    public void serialarSororitas (String ruta) {
        List<AdeptaSororitas> lista = new ArrayList<>();
        String sql = "select * from adeptaSororitas";


        try (Connection conn = Conexion.conexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                AdeptaSororitas adepta = new AdeptaSororitas(
                rs.getInt("cod"),
                rs.getString("nome"),
                rs.getInt("puntos")
            );
                lista.add(adepta);
            }

            ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(ruta));
            oos.writeObject(lista);
            System.out.println("Serialización completada con exito en: " + ruta);

    } catch (SQLException | IOException e) {
            System.out.println("Error al serializar las Sororitas: " + e.getMessage());
        }

    }
}
