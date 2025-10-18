package DAO;
import model.SpaceMarine;
import java.sql.*;
import java.util.*;

public class SpaceMarineDAO {

    public List<SpaceMarine> obtenerTodos() {
        List<SpaceMarine> lista = new ArrayList<>();
        String sql = "SELECT * FROM spaceMarines";

        try (Connection conn = Conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new SpaceMarine(
                        rs.getInt("cod"),
                        rs.getString("nome"),
                        rs.getInt("puntos")
                ));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener los Space Marines: " + e.getMessage());
        }

        return lista;
    }

    public SpaceMarine buscarPorCodigo(int cod) {
        String sql = "SELECT * FROM spaceMarines WHERE cod = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new SpaceMarine(
                        rs.getInt("cod"),
                        rs.getString("nome"),
                        rs.getInt("puntos")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar por código: " + e.getMessage());
        }

        return null;
    }
}
