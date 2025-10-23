import DAO.Conexion;
import DAO.InventarioTendaDAO;
import DAO.VehiculoDAO;
import ReadWrite.Deserializar;
import ReadWrite.Serializar;
import ReadWrite.VehiculoXML;
import model.InventarioTenda;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Conexion conexion = new Conexion();
        if (conexion != null) System.out.println("Conexion exitosa"); // Prompo

        List<Vehiculo> vehiculosLista = new ArrayList<>();
        List<InventarioTenda> inventarioTendaLista = new ArrayList<>();


        // Insertar en la tabla vehiculo 5 vehiculos
          VehiculoDAO vehiculoDAO = new VehiculoDAO();
//        Vehiculo v1 = new Vehiculo("Ford", "Mustang", 2021, "Deportivos americanos icónicos");
//        Vehiculo v2 = new Vehiculo("Tesla", "Model S", 2023, "Sedán eléctrico de luxo con gran autonomía");
//        Vehiculo v3 = new Vehiculo("Honda", "Civic ", 2020, "Compacto de gran fiabilidade");
//        Vehiculo v4 = new Vehiculo("Chevrolet", "Corvette", 2022, "Deportivo americano con motor V8");
//        Vehiculo v5 = new Vehiculo("Toyota", "Prius", 2022, "Híbrido de baixo consumo e ecolóxico");
//        vehiculoDAO.insertarVehiculo(v1); vehiculoDAO.insertarVehiculo(v2); vehiculoDAO.insertarVehiculo(v3); vehiculoDAO.insertarVehiculo(v4); vehiculoDAO.insertarVehiculo(v5);


        // Comprobar que se insertaron correctamente
        vehiculosLista = vehiculoDAO.obtenerVehiculos();
        for (Vehiculo v : vehiculosLista) {
            System.out.println(v);
        }

        System.out.println("-------------------------------------------------------------------");

        // Serializar y deserializar tabla vehiculo
        Serializar.serializarVehiculo("vehiculoSerializado.dat");
        Deserializar.deserializarVehiculo("vehiculoSerializado.dat");

        // Generar XMl de Vehiculo
        VehiculoXML.crearVehiculoXML(vehiculosLista, "vehiculoXML.xml");

        System.out.println("----------------------------------------");

        // Insertar en InventarioTenda
//        for (Vehiculo v : vehiculosLista) {
//            switch (v.getModelo()) {
//                case "Ford" -> InventarioTendaDAO.insertarinventarioTenda(new InventarioTenda(v.getId(), 25000.00, 30000.00, 10));
//                case "Tesla" -> InventarioTendaDAO.insertarinventarioTenda(new InventarioTenda(v.getId(), 40000.00, 50000.00, 12));
//                case "Honda" -> InventarioTendaDAO.insertarinventarioTenda(new InventarioTenda(v.getId(), 18000.00, 22000.00, 5));
//                case "Chevrolet" -> InventarioTendaDAO.insertarinventarioTenda(new InventarioTenda(v.getId(), 60000.00, 70000.00, 8));
//                case "Toyota" -> InventarioTendaDAO.insertarinventarioTenda(new InventarioTenda(v.getId(), 25000.00, 30000.00, 6));
//            }
//        }
//
//        inventarioTendaLista = InventarioTendaDAO.obtenerInventarioTenda();
//        System.out.println(inventarioTendaLista);


        System.out.println("OFERTAS COCHES");



    }
}
