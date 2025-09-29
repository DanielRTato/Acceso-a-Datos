import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeService {

    public void insertAnime(Anime anime) {
        String consulta = "insert into anime (nome, descripcion, data, puntuacion) values (?, ?, ?, ?)";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setString(1, anime.getNome());
            stmt.setString(2, anime.getDescripcion());
            stmt.setDate(3, anime.getData());
            stmt.setInt(4, anime.getPuntuacion());

            stmt.executeUpdate();
            System.out.println("Inserido: " + anime.getNome());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Anime> leer() {
        List<Anime> lista = new ArrayList<>();
        String consulta = "select * from anime";
        try (Connection conn = Conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Anime anime = new Anime(
                        rs.getString("nome"),
                        rs.getString("descripcion"),
                        rs.getDate("data"),
                        rs.getInt("puntuacion")
                );
                lista.add(anime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Anime leerFiltrado () {
        return null;

    }

    public void actualizar() {

    }

    public void eliminar (String nome) {
        String consulta = "delete from anime where nome = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setString(1, nome);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Eliminado " + nome);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

}
