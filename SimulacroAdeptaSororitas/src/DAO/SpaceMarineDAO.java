package DAO;
import model.AdeptaSororitas;
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
            System.out.println("Error al obtener los Space Marines: " + e.getMessage());
        }

        return lista;
    }

    public SpaceMarine buscarPorCodigo(int cod) {
        String sql = "SELECT * FROM spaceMarines WHERE cod = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cod);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new SpaceMarine(
                            rs.getInt("cod"),
                            rs.getString("nome"),
                            rs.getInt("puntos")
                    );
                } else {
                    System.out.println(" No se encontró ninguna SpaceMarine con código: " + cod);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar por código: " + e.getMessage());
        }

        return null;
    }

    public void insertarMarine(SpaceMarine marine) {
        String consulta = "insert into spacemarines(cod, nome, puntos) values (?,?,?)";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setInt(1, marine.getCod());
            stmt.setString(2, marine.getNome());
            stmt.setInt(3, marine.getPuntos());
            stmt.executeUpdate();
            System.out.println("SpaceMarine " + marine.getNome() + " insertado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar en la tabla spacemarines " + e.getMessage());
        }
    }

    public void deleteMarine(int codigo) {
        String consulta = "delete from spacemarines where cod = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setInt(1, codigo);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Eliminado correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar de la BD: " + e.getMessage());
        }
    }

    public void actualizarMarine (SpaceMarine spaceMarine) {
        String consulta = "update spacemarines set nome = ?, puntos = ? where cod = ?";

        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setString(1, spaceMarine.getNome());
            stmt.setInt(2, spaceMarine.getPuntos());
            stmt.setInt(3, spaceMarine.getCod());
            int filas = stmt.executeUpdate();
            if (filas > 0 ) {
                System.out.println("SpaceMarine actualizado correctamente: " + spaceMarine.getNome());
            }

        } catch (SQLException e) {
            System.out.println("Error al actulizar SpaceMarine: " + e.getMessage());
        }
    }



}
