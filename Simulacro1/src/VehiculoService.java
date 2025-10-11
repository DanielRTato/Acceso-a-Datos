import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class VehiculoService {

    private static final String consultaInsert = "insert into vehiculo (modelo, marca, ano, descripcion) values (?, ?, ?, ?)";
    private static final String consultaSelect = "select * from vehiculo";

    public void insertVehiculo (Vehiculo vehiculo) {
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consultaInsert)) {

            stmt.setString(1,vehiculo.getModelo());
            stmt.setString(2,vehiculo.getMarca());
            stmt.setInt(3,vehiculo.getAno());
            stmt.setString(4,vehiculo.getDescripcion());
            stmt.executeUpdate();
            System.out.println("Vehiculo " + vehiculo.getModelo() + " insertado correctamente");

        } catch (SQLException e) {
            System.out.println("Error en el insert de vehiculo: " + e);
        }
    }

    public List<Vehiculo> selectVehiculo() {
        List<Vehiculo> garaje = new ArrayList<>();
        try (Connection conn = Conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consultaSelect)){

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
            System.out.println("Error en el select vehiculo: " + e);
        }


        return garaje;
    }
}

