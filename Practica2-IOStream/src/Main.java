import java.io.*;

public class Main {
    public static void main(String[] args) {

        // PARTE 1

        //Ejercicio 1 Crear un documento y escribir en el
        File archivo = new File("texto1.txt"); //Creacion del archivio
        try {
            archivo.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String texto = "Tanjiro\n" + // texto a escribir en el documento
                "Nezuko\n" +
                "Muzan";

        try{ // escribe el texto
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
            escribir.write(texto);
            escribir.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Ejercicio 2 por byte en otro docuemento
        try {
            FileInputStream fis = new FileInputStream(archivo);
            FileOutputStream fos = new FileOutputStream("texto2.txt");

            int dato = 0;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}