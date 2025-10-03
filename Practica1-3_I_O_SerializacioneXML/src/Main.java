public class Main {
    public static void main(String[] args) {


        Producto producto1 = new Producto("Parte1", 1, 2.3);
        Producto productoValeiro = new Producto();

        producto1.guardarObjecto("serial");
        productoValeiro.escribirObjeto("serial");

        System.out.println(producto1);
        System.out.println(productoValeiro);

        productoTransient producto2 = new productoTransient("Parte2", 11 , 5.2);
        productoTransient productoValeiro2 = new productoTransient();

        producto2.guardarObjecto("serial2");
        productoValeiro2.escribirObjeto("serial2");

        System.out.println(producto2);
        System.out.println(productoValeiro2);



    }
}