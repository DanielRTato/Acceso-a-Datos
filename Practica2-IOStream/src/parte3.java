import java.io.*;

public class parte3 {
    public static void main(String[] args) {

        // PARTE 3
        grabar3Veces("texto3.txt");

        System.out.println("-----------------------------------------");

        leer("texto3.txt");


    }

    // PARTE 3
    public static void grabar3Veces (String origen) {
        File archivo = new File(origen);

        try{
            DataInputStream dis = new DataInputStream(new FileInputStream(archivo));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo));

             String cadena = "o tempo está xélido";

            for (int i = 1; i <= 3; i++) {
                dos.writeUTF(cadena);
                System.out.println("Escribindo a cadea: " + cadena);
                System.out.println("Tamaño do ficheiro: " + dos.size() + " bytes");
            }
            System.out.println("tamano final do ficheiro: " + dos.size() + " bytes");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leer (String origen) {
        File archivo = new File(origen);

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(archivo));

            while (dis.available() > 0) {
                System.out.println("Quedan: " + dis.available() + " bytes por ler");
                String leido = dis.readUTF();
                System.out.println("Cadea: " + leido);
            }
            System.out.println("Xa non queda nada por ler");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
