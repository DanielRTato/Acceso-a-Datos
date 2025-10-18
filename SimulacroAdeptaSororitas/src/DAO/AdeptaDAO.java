package DAO;

import model.AdeptaSororitas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdeptaDAO {

        public List<AdeptaSororitas> obtenerTodas() {
        List<AdeptaSororitas> lista = new ArrayList<>();
        String sql = "SELECT * FROM adeptaSororitas";

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

        } catch (SQLException e) {
            System.out.println("Error al obtener datos: " + e.getMessage());
        }

        return lista;
    }


    public AdeptaSororitas buscarPorCodigo(int cod) {
        AdeptaSororitas sororita = null;
        String sql = "SELECT * FROM adeptaSororitas WHERE cod = ?";

        try (Connection conn = Conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                sororita = new AdeptaSororitas(
                        rs.getInt("cod"),
                        rs.getString("nome"),
                        rs.getInt("puntos")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar por código: " + e.getMessage());
        }

        return sororita;
    }

    // Calucla la media desde la BD con una consulta
    public void mediaPuntos () {
        String sql = "SELECT AVG(puntos) AS media FROM adeptaSororitas";
        try (Connection conn = Conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                double media = rs.getDouble("media");
                System.out.println("Media de puntos (desde BD): " + media);
            }

        } catch (SQLException e) {
            System.out.println("Error al calcular la media: " + e.getMessage());
        }

    }

}


