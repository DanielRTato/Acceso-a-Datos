package DAO;

import model.AdeptaSororitas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}


