import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimeService {
    public void insertAnime(Anime anime) {
        String sql = "insert into anime (nome, descripcion, data, puntuacion) values (?, ?, ?, ?)";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, anime.getNome());
            stmt.setString(2, anime.getDescripcion());
            stmt.setDate(3, anime.getData());
            stmt.setInt(4, anime.getPuntuacion());

            stmt.executeUpdate();
            System.out.println("✅ Inserido: " + anime.getNome());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
