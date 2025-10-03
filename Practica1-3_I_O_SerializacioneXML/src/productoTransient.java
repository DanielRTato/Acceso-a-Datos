import java.io.*;

public class productoTransient implements Serializable {
    String nome;
    transient int num1;
    double num2;

    public productoTransient(String nome, int num1, double num2) {
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;
    }

    public productoTransient(){

    }


    public void guardarObjecto(String ruta) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
            oos.writeObject(this);
            System.out.println("Guardado");
        } catch (IOException | RuntimeException e) {
            System.out.println("Erroral guardad:  " + e);;
        }
    }


    public void escribirObjeto(String ruta) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));
            productoTransient producto = (productoTransient) ois.readObject();
            this.nome = producto.nome;
            this.num1 = producto.num1;
            this.num2 = producto.num2;
            System.out.println("Cargado bien");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al escribir: " + e);
        }
    }

    @Override
    public String toString() {
        return "productoTransient{" +
                "nome='" + nome + '\'' +
                ", num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}


