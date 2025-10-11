import java.io.File;

public class Main {
    public static void main(String[] args) {

        Conexion.conexion();

        // Insertar los vehiculos en la tabla vehiculo
        Vehiculo Ford = new Vehiculo("Ford", "Mustang", 2021, "Deportivos americanos icónicos");
        Vehiculo Tesla = new Vehiculo("Tesla ", "Model S ", 2023, "Sedán eléctrico de luxo con gran autonomía");
        Vehiculo Honda  = new Vehiculo("Honda ", "Civic ", 2020, "Compacto de gran fiabilidade");
        Vehiculo Chevrolet  = new Vehiculo("Chevrolet", "Corvette ", 2022, "Deportivo americano con motor V8");
        Vehiculo Toyota  = new Vehiculo("Toyota ", "Prius ", 2022, "Híbrido de baixo consumo e ecolóxico");

        VehiculoService vehiculoSer = new VehiculoService();

        vehiculoSer.insertVehiculo(Ford); // Se les asigna el id en orden (1,2,3,4,5(
        vehiculoSer.insertVehiculo(Tesla);
        vehiculoSer.insertVehiculo(Honda);
        vehiculoSer.insertVehiculo(Chevrolet);
        vehiculoSer.insertVehiculo(Toyota);

        // Insertar el inventario en la tabla inventariotenda
        InventarioTenda i1 = new InventarioTenda(1, 25000.00, 30000.00, 10);
        InventarioTenda i2 = new InventarioTenda(2, 40000.00, 50000.00, 12);
        InventarioTenda i3 = new InventarioTenda(3, 18000.00, 22000.00, 5);
        InventarioTenda i4 = new InventarioTenda(4, 60000.00, 70000.00, 8);
        InventarioTenda i5 = new InventarioTenda(5, 25000.00, 30000.00, 6);

        InventarioTendaService invetarioSer = new InventarioTendaService();
        invetarioSer.insertInventario(i1);
        invetarioSer.insertInventario(i2);
        invetarioSer.insertInventario(i3);
        invetarioSer.insertInventario(i4);
        invetarioSer.insertInventario(i5);

        SerializacionVehiculo serial = new SerializacionVehiculo();
        serial.serializarVehiculo("vehiculoserializados"); // Serializar los coches
        serial.desSerializarVehiculo("vehiculoserializados"); // Deserializa y los muestra (ni idea, por como gestiono la ID se crean los vehiculos todo el rato)

        //Exportar la tabla vehiculo a XML
        VehiculoXML vxml = new VehiculoXML();
        vxml.vehiculoAXML();

        // Modiciar el porcentaje de inventarioVehiculos

        invetarioSer.updatePorcentaje();










    }
}

