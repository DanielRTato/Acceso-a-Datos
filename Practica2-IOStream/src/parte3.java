import java.io.*;

public class parte3 {
    public static void main(String[] args) {

        // PARTE 3
        grabar3Veces("texto3.txt");
        leer("texto3.txt");


    }

    // PARTE 3
    public static void grabar3Veces (String origen) {
        File archivo = new File(origen);

        try{
            DataInputStream dis = new DataInputStream(new FileInputStream(archivo));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo, true));

            dos.writeUTF("Cadea: o tempo está xélido\n");
            dos.writeUTF("Cadea: o tempo está xélido\n");
            dos.writeUTF("Cadea: o tempo está xélido\n");
            System.out.println(dos.size());
            dis.close();
            dos.close();
            System.out.println(archivo.length() + " bytes");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leer (String origen) {
        File archivo = new File(origen);

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(archivo));

            while (dis.available() > 0) {
                System.out.println(dis.readUTF());
            }
            dis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
