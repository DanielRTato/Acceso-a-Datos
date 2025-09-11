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
     * @param directorio ruta absoluta do directorio a crear
     */
    public static void creaDirectirio(String directorio) {
        File archivo = new File(directorio);
        if (!archivo.exists()) {
            archivo.mkdir();
        }
        else {
            System.out.println("O directorio xa existe");
        }
    }

    public static void crearFicheiro(String dirName, String fileName) {

    }


}