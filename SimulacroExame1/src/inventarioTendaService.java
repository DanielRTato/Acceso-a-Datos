import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class inventarioTendaService {


    public void insertarinventarioTenda(inventarioTenda inventario) {
        // List<Vehiculo> garaje = new ArrayList<>();

        String consulta = "insert into inventariotenda (idvehiculo, prezomayorista, prezoventa, porcentaxeoferta) values (?, ?, ?, ?)";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setInt(1, inventario.getIdvehiculo());
            stmt.setInt(2, inventario.getPrezomayorista());
            stmt.setInt(3, inventario.getPrezoventa());
            stmt.setInt(4, inventario.getProcentaxeoferta());

            stmt.executeUpdate();
            // garaje.add(vehiculo);

            System.out.println("Inserido: " + inventario.getIdvehiculo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPorcentaje(inventarioTenda inventario) {
        String consulta = "update inventariotenda set porcentaxeoferta = porcentaxeoferta + 15 where idvehiculo = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setInt(1, inventario.getIdvehiculo());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("porcentaje actualizado  " + inventario.getIdvehiculo());
            } else {
                System.out.println("Error al actualziar el precio del vehiculo: " + inventario.getIdvehiculo());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
