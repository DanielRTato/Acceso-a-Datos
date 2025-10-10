import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       List<Vehiculo> garaje = new ArrayList<>();

        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford",2005, "Un coche muy fiable");
        Vehiculo vehiculoVacio = new Vehiculo();

        vehiculo1.guardarObjecto("vehiculoSerial");
        vehiculoVacio.escribirObjeto("vehiculoSerial");
        System.out.println(vehiculoVacio); // Muestra comom el vehiculo1 se serializo correctamente y como se escribe bien en vehiculoVacio

        // Insertar los vehiculos
        Vehiculo Mustang = new Vehiculo("Ford", "Mustang",2021, "Deportivos americanos icónicos");
        Vehiculo Tesla = new Vehiculo("Tesla", "Model S",2023, "Sedán eléctrico de luxo con gran autonomía");
        Vehiculo Civic = new Vehiculo("Honda", "Civic",2020, "Compacto de gran fiabilidade");
        Vehiculo Corvette = new Vehiculo("Chevrolet", "Corvette",2022, "Deportivo americano con motor V8");
        Vehiculo Toyota = new Vehiculo("Toyota", "Prius",2022, "Híbrido de baixo consumo e ecolóxico");

        Vehiculo.insertarVehiculo(Tesla); // Se les inserta un id en orden (1,2,3,4,5)
        Vehiculo.insertarVehiculo(Mustang);
        Vehiculo.insertarVehiculo(Civic);
        Vehiculo.insertarVehiculo(Corvette);
        Vehiculo.insertarVehiculo(Toyota);

     garaje.add(Tesla);
     garaje.add(Mustang);
     garaje.add(Civic);
     garaje.add(Corvette);
     garaje.add(Toyota);

        vehiculo1.vehiculoXML();

        inventarioTenda i1 = new inventarioTenda(1, 2500,30000, 10);
        inventarioTenda i2 = new inventarioTenda(2, 40000,50000, 12);
        inventarioTenda i3 = new inventarioTenda(3, 18000,22000, 5);
        inventarioTenda i4 = new inventarioTenda(4, 60000,70000, 8);
        inventarioTenda i5 = new inventarioTenda(5, 25000,30000, 6);

        inventarioTendaService its = new inventarioTendaService();

        its.insertarinventarioTenda(i1);
        its.insertarinventarioTenda(i2);
        its.insertarinventarioTenda(i3);
        its.insertarinventarioTenda(i4);
        its.insertarinventarioTenda(i5);


      System.out.println("OFERTAS COCHES");

      its.actualizarPorcentaje(i1);




//        for (int i = 0; i<= garaje.toArray().length; i++) {
//            System.out.println(garaje.get(i));
//        }




    }
}