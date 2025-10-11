import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioTendaService {

    public void insertInventario (InventarioTenda inventario) {
        String consulta = "insert into inventariotenda (idvehiculo, prezomayorista, prezoventa, porcentaxeoferta) values (?, ?, ?, ?)";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setInt(1,inventario.getVehiculoId());
            stmt.setDouble(2,inventario.getPrezoMayorista());
            stmt.setDouble(3,inventario.getPrezoVenta());
            stmt.setInt(4,inventario.getPorcentaje());
            stmt.executeUpdate();
            System.out.println("Inventario " + inventario.getVehiculoId() + " insertado correctamente");

        } catch (SQLException e) {
            System.out.println("Error en el insert de inventario: " + e);
        }
    }

    public List<InventarioTenda> selectInventario() {
        List<InventarioTenda> inventario = new ArrayList<>();
        String consulta = "select * from inventariotenda";
        try (Connection conn = Conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)){

            while (rs.next()) {
                InventarioTenda filaInventario = new InventarioTenda(
                        rs.getInt("idvehiculo"),
                        rs.getDouble("prezomayorista"),
                        rs.getInt("prezoventa"),
                        rs.getInt("porcentaxeoferta")
                );
                inventario.add(filaInventario);
            }
        } catch (SQLException e) {
            System.out.println("Error en el select de InventarioTenda: " + e);
        }


        return inventario;
    }

    public void updatePorcentaje() {
        String consulta = "update inventariotenda set porcentaxeoferta = porcentaxeoferta + 15";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt= conn.prepareStatement(consulta) ){

            stmt.executeUpdate();
            System.out.println("Porcentaje modificado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al hacer update sobre el porcentaje: "+ e);
        }
    }
}


