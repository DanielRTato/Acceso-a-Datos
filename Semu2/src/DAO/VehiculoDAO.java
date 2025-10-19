package DAO;

import model.Vehiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    public List<Vehiculo> obtenerVehiculos() {
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "select * from vehiculo";

        try (Connection conn = Conexion.conexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getString("descripcion")
                );
                lista.add(vehiculo);
            }
        }catch (SQLException e) {
            System.out.println("Error al obtener datos: " + e.getMessage());
        }

        return lista;
    }

    public void insertarVehiculo (Vehiculo vehiculo) {
        String consulta = "insert into vehiculo (modelo, marca, ano, descripcion) values (?,?,?,?)";

        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setString(1, vehiculo.getModelo());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setInt(3, vehiculo.getAno());
            stmt.setString(4, vehiculo.getDescripcion());
            stmt.executeUpdate();
            System.out.println("SpaceMarine " + vehiculo.getModelo() + " insertado correctamente");

        } catch (SQLException e) {
        System.out.println("Error al insertar en la tabla vehiculo " + e.getMessage());
    }

    }



}
