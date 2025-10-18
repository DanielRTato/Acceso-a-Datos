package util;
import model.AdeptaSororitas;
import java.util.List;

public class CalculosSororitas {

    public static double calcularMediaPuntos(List<AdeptaSororitas> lista) {
        double suma = 0;
        int total = 0;
        for (AdeptaSororitas s : lista) {
            suma += s.getPuntos();
            total++;
        }
        return total == 0 ? 0 : suma / total;
    }
}
