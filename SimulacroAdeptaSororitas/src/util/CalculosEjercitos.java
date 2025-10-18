package util;

import model.AdeptaSororitas;
import model.SpaceMarine;

import java.util.List;

public class CalculosEjercitos {

    public static double CalcularMediaEjercitos(List<AdeptaSororitas> sororitas, List<SpaceMarine> marines) {
        double suma = 0;
        int totalunidades = 0;

        for (AdeptaSororitas as : sororitas){
            suma += as.getPuntos();
            totalunidades++;
        }

        for (SpaceMarine sm : marines) {
            suma += sm.getPuntos();
            totalunidades ++;
        }

        return suma / totalunidades;
    }


    public static void compararEjercitos(double mediaSororitas, double mediaMarines) {
        System.out.printf("Adepta Sororitas → Media: %.2f%n", mediaSororitas);
        System.out.printf("Space Marines → Media: %.2f%n", mediaMarines);

        if (mediaSororitas > mediaMarines)
            System.out.println("Las Adepta Sororitas tienen la media más alta.");
        else if (mediaMarines > mediaSororitas)
            System.out.println("Los Space Marines dominan la batalla.");
        else
            System.out.println("Ambos ejércitos están equilibrados.");
    }
}

