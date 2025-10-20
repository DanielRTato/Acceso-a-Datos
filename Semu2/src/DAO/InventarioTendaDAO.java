package DAO;

import model.InventarioTenda;
import model.Vehiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioTendaDAO {

    public static void insertarinventarioTenda(InventarioTenda inventarioTenda) {
        String consulta = "insert into inventariotenda (idvehiculo, prezomayorista, prezoventa, porcentaxeoferta ) values (?,?,?,?)";

        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setInt(1, inventarioTenda.getIdVehiculo());
            stmt.setDouble(2, inventarioTenda.getPrezoMayorista());
            stmt.setDouble(3, inventarioTenda.getPrezoVenta());
            stmt.setInt(4, inventarioTenda.getPorcentaxeOferta());
            stmt.executeUpdate();
            System.out.println("InventarioTenda: " + inventarioTenda.getId() + " insertado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar en la tabla InventarioTenda " + e.getMessage());
        }
    }

    public static List<InventarioTenda> obtenerInventarioTenda() {
        List<InventarioTenda> listaInventarioTendas = new ArrayList<>();
        String sql = "select * from inventariotenda";

        try (Connection conn = Conexion.conexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                InventarioTenda inventarioTenda = new InventarioTenda(
                        rs.getInt("id"),
                        rs.getInt("idvehiculo"),
                        rs.getDouble("prezomayorista"),
                        rs.getDouble("prezoventa"),
                        rs.getInt("porcentaxeoferta")

                );
                listaInventarioTendas.add(inventarioTenda);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos: " + e.getMessage());
        }

        return listaInventarioTendas;
    }


}
