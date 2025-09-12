/**
 * Practica 1 de AD
 * @autor: Daniel Rodríguez Tato
 * @version: 0.1
 */

import java.io.File;
public class Main {
    public static void main(String[] args) {

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
    public static void creaDirectirio(String directorio) {
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
            file.setWritable(false);
        }
    }

    public static String borrarFicheiro(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        if (file.exists()){
            file.delete();
            System.out.println("Fichero eliminado correctamente");
        }
        return "ficheiro inexistente";
    }

    public static void borrarDirectorio(String dirName){
        File dir = new File(dirName);
        if (dir.exists()){
            dir.delete();
            System.out.println("Directorio eliminado correctamente");
        } else {
            System.out.println("Directorio inexistente");
        }
    }

        public void mContido (String dirName) {
            File dir = new File(dirName);
            if (dir.exists()) {
                String[] ficheros = dir.list();
                for (String fichero : ficheros) {
                    System.out.println(fichero);
                }
            } else {
                System.out.println("El directorio no existe o no es un directorio.");
            }
        }

    /**
     * PENDIENTE
     * @param dirName
     */
    public static void recur(String dirName) {

        }


}




