/**
 * Practica 1 de AD
 * @autor: Daniel Rodríguez Tato
 * @version: 0.1
 */

import java.io.File;
public class Main {

    public static final String directorio = "C://Users//Usuario//Desktop//Acceso a Datos//Prac1_Ficheros//arquivosdir";

    public static void main(String[] args) {

        // Ejercios de la Parte 2

        //Ej 1. Crea el directorio si no existe y comprueba que sea un directorio
        creaDirectorio(directorio);
        System.out.println(eDirectorio(directorio));

        //Ej 2. Crea archivo Productos1.txt si no existe y comprueba que sea un fichero
        crearFicheiro(directorio,"Products1.txt"  );
        System.out.println(eFicheiro(directorio + "//Products1.txt"));

        //Ej 3. Dentro del directorio anterior crear uno nuevo y otro archivo
        String subdir = directorio + "//subdir";
        creaDirectorio(subdir);
        crearFicheiro(subdir, "Products2.txt");

        //Ej 4.
        mContido(directorio);

        //Ej 5. Muestra si se puede leer y escribir en ese archivo y su longitud
        modoAcceso(directorio, "Products1.txt");
        System.out.println(calculaLonxitude(directorio, "Products1.txt"));

        //Ej 6. Convierte el archivo en solo lectura
        mLectura(directorio, "Products1.txt");

        //Ej 7. Permite escribir en el archivo
        mEscritura(directorio, "Products1.txt");

        //Ej 8. Borrar un archivo
        borrarFicheiro(directorio, "Products1.txt");

        //Ej 9. Borrar los archivos y directorios creados
        borrarFicheiro(subdir, "Products2.txt");
        borrarDirectorio(subdir);
        borrarDirectorio(directorio);



    }

    /**
     * Detecta se unha cadea dada corresponde a un directorio
     *
     * @param cadea
     * @return
     */
    public static String eDirectorio(String cadea) {
        File archivo = new File(cadea);
        if (archivo.isDirectory()) {
            return "é directorio";
        } else {
            return "non é directorio";
        }
    }

    /**
     * Comproba se unha cadea dada corresponde a un ficheiro
     *
     * @param cadea
     * @return
     */
    public static String eFicheiro(String cadea) {
        File archivo = new File(cadea);
        if (archivo.isFile()) {
            return "é ficheiro";
        } else {
            return "non é ficheiro";
        }
    }

    /**
     * Crea un directorio a partir da ruta absoluta
     *
     * @param directorio ruta absoluta do directorio a crear
     */
    public static void creaDirectorio(String directorio) {
        File archivo = new File(directorio);
        if (!archivo.exists()) {
            archivo.mkdir();
        } else {
            System.out.println("O directorio xa existe");
        }
    }

    public static void crearFicheiro(String dirName, String fileName) {
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Ficheiro creado correctamente");
            } else {
                System.out.println("O ficheiro xa existe");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void modoAcceso(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            if (file.canWrite()) {
                System.out.println("escritura si");
            } else {
                System.out.println("escritura non");
            }
            if (file.canRead()) {
                System.out.println("lectura si");
            } else {
                System.out.println("lectura non");
            }
        }
    }

    public static double calculaLonxitude(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        double longitud = 0;
        if (file.exists()) {
            longitud = file.length();
        }

        return longitud;
    }


    public static void mLectura(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        if (file.exists()) {
            file.setReadOnly();
        }
    }

    public static void mEscritura(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        if (file.exists()) {
            file.setWritable(true);
        }
    }

    public static void borrarFicheiro(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Ficheiro eliminado correctamente");
            } else {
                System.out.println("Non se puido eliminar o ficheiro");
            }
        } else {
            System.out.println("Ficheiro inexistente");
        }
    }

    public static void borrarDirectorio(String dirName){
        File dir = new File(dirName);
        if (dir.exists()) {
            if (dir.isDirectory() && dir.list().length == 0) {
                dir.delete();
                System.out.println("Directorio eliminado correctamente");
            } else {
                System.out.println("ruta inexistente ou con descendencia");
            }
        } else {
            System.out.println("Ruta inexistente");
        }
    }

        public static void mContido (String dirName) {
            File dir = new File(dirName);
            if (dir.exists()) {
                String[] ficheros = dir.list();
                for (String fichero : ficheros) {
                    System.out.println(fichero);
                }
            } else {
                System.out.println("El directorio no existe");
            }
        }

    /**
     * PENDIENTE
     * @param dirName
     */
    public static void recur(String dirName) {

        }


}




