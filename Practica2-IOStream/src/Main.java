import java.io.*;

public class Main {
    public static void main(String[] args) {

        // PARTE 1
        crearArchivo();
        copiaContido("texto1.txt");
        copiaSinRemplazar("texto1.txt");



        // PARTE 2
       // copiarImagen("foto.jpg", "foto2.jpg");
        copiarImagenBuffer("foto.jpg", "foto2.jpg");




    }

    // PARTE 1

    //Ejercicio 1 Crear un documento y escribir en el
    public static void crearArchivo() {
    File archivo = new File("texto1.txt"); //Creacion del archivio
        try {
        archivo.createNewFile();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    String texto = "Tanjiro\n" + // texto a escribir en el documento
            "Nezuko\n" +
            "Muzan\n";

        try{ // escribe el texto
        BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
        escribir.write(texto);
        escribir.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
        }
    }

    // Ejercicio 2 por byte en otro docuemento
    public static void copiaContido(String archivo) {
        try {
            FileInputStream fis = new FileInputStream(archivo);
            FileOutputStream fos = new FileOutputStream("texto2.txt");

            int dato = 0;
            while ((dato = fis.read()) != -1) {
                fos.write(dato);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Ejercicio 3, copia sin remplazar
    public static void copiaSinRemplazar (String archivo) {
        try {
            FileInputStream fis = new FileInputStream(archivo);
            FileOutputStream fos = new FileOutputStream("texto2.txt", true); // Al poner true el texto se pone al final en lugar de sobreescribir

            int dato = 0;
            while ((dato = fis.read()) != -1) {
                fos.write(dato);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // PARTE 2
    // Ejercicio 1
    public static void copiarImagen (String origen, String destino) {
        File archivo = new File(origen);
        try {
            FileInputStream fis = new FileInputStream(archivo);
            FileOutputStream fos = new FileOutputStream(destino, true);

            int dato = 0;
            while ((dato = fis.read()) != -1) {
                fos.write(dato);
            }

            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Ejercicio 3
    public static void copiarImagenBuffer (String origen, String destino) {
        File archivo = new File(origen);

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivo));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destino));

            int dato = 0;
            while ((dato = bis.read()) != -1) {
                bos.write(dato);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}