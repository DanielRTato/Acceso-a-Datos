import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Anime {
    private String nome;
    private String descripcion;
    private Date data;
    private int puntuacion;

    public Anime(String nome, String descripcion, Date data, int puntuacion) {
        this.nome = nome;
        this.descripcion = descripcion;
        this.data = data;
        this.puntuacion = puntuacion;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "nome='" + nome + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", data=" + data +
                ", puntuacion=" + puntuacion +
                '}';
    }

    public String dateToString(Date dataD) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(dataD);
    }
    public Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println("petou" + e);
            return null;
        }
    }
}

