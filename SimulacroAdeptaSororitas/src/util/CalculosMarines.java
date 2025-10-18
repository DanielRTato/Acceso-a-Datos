package util;
import model.SpaceMarine;
import java.util.List;

public class CalculosMarines {

    public static double calcularMediaPuntos(List<SpaceMarine> lista) {
        double suma = 0;
        int total = 0;
        for (SpaceMarine m : lista) {
            suma += m.getPuntos();
            total++;
        }
        return total == 0 ? 0 : suma / total;
    }
}
