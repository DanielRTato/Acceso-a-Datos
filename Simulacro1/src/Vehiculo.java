import java.io.*;

public class Vehiculo implements Serializable{
    private int idd;
    private String modelo;
    private String marca;
    private int ano;
    private String descripcion;

    public Vehiculo(String modelo, String marca, int ano, String descripcion) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.descripcion = descripcion;
    }

    public Vehiculo() {}

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "idd=" + idd +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }





}

