import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    /**
     * Busca los animes con mayor puntuacion de la especificada
     * @param puntuacion
     * @return
     */
    public Anime leerFiltrado(int puntuacion) {
        String consulta = "select * from anime where puntuacion < ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setInt(1, puntuacion);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Anime(
                            rs.getString("nome"),
                            rs.getString("descripcion"),
                            rs.getDate("data"),
                            rs.getInt("puntuacion\n")

                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public String dateToString(Date dataD) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(dataD);
    }
    public Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println("petou" + e);
            return null;
        }
    }
}


