/**
 * Practica 1 de AD
 * @autor: Daniel Rodríguez Tato
 * @version: 0.1
 */

import java.io.File;
public class Main {
    public static void main(String[] args) {

    }

    public static String eDirectorio(String cadea) {
        File archivo = new File(cadea);
        if (archivo.isDirectory()) {
            return "é directorio";
        } else {
            return "non é directorio";
        }
    }

    public static String eFicheiro(String cadea) {
        File archivo = new File(cadea);
        if (archivo.isFile()) {
            return "é ficheiro";
        } else {
            return "non é ficheiro";
        }
    }

    public static void creaDirectirio(String directorio) {
        File archivo = new File(directorio);
        if (!archivo.exists()) {
            archivo.mkdir();
        }
        else {
            System.out.println("O directorio xa existe");
        }

    }


}