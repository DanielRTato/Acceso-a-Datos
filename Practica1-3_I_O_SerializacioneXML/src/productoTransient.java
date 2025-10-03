import java.io.Serializable;

public class productoTransient implements Serializable {
    String nome;
    transient int num1;
    double num2;
}
