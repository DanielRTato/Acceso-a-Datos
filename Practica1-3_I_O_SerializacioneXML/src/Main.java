public class Main {
    public static void main(String[] args) {


        Producto producto1 = new Producto("manzana", 1, 2.3);
        Producto productoValeiro = new Producto();

        producto1.guardarObjecto("serial");
        productoValeiro.escribirObjeto("serial");

        System.out.println(producto1);
        System.out.println(productoValeiro);


    }
}