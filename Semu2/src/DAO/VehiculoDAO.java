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
                        rs.getInt("id"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getString("descripcion")
                );
                lista.add(vehiculo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos: " + e.getMessage());
        }

        return lista;
    }

    public void insertarVehiculo(Vehiculo vehiculo) {
        String consulta = "insert into vehiculo (modelo, marca, ano, descripcion) values (?,?,?,?)";

        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, vehiculo.getModelo());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setInt(3, vehiculo.getAno());
            stmt.setString(4, vehiculo.getDescripcion());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys(); // Captura do ID autoxerado
            if (rs.next()) {
                vehiculo.setId(rs.getInt(1));
            }
            System.out.println("Vehiculo: " + vehiculo.getModelo() + " insertado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar en la tabla vehiculo " + e.getMessage());
        }
    }

    public void deleteCar(int codigo) {
        String consulta = "delete from vehiculo where id = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setInt(1, codigo);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Vehiculo correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar de la BD: " + e.getMessage());
        }
    }

    public void actualizarVehiculo(Vehiculo vehiculo) {
        String consulta = "update vehioculo set modelo = ?, marca = ?, ano = ?, descripcion  = ? where id = ?";

        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setString(1, vehiculo.getModelo());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setInt(3, vehiculo.getAno());
            stmt.setString(4, vehiculo.getDescripcion());
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Vehiculo actualizado correctamente: " + vehiculo.getModelo());
            }
        } catch (SQLException e) {
            System.out.println("Error al actulizar Vehiculo: " + e.getMessage());
        }
    }
}


