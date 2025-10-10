import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class inventarioTenda {

    private int idvehiculo;
    private int prezomayorista;
    private int prezoventa;
    private int procentaxeoferta;

    public inventarioTenda(int idvehiculo, int prezomayorista, int prezoventa, int procentaxeoferta) {
        this.idvehiculo = idvehiculo;
        this.prezomayorista = prezomayorista;
        this.prezoventa = prezoventa;
        this.procentaxeoferta = procentaxeoferta;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public int getPrezomayorista() {
        return prezomayorista;
    }

    public void setPrezomayorista(int prezomayorista) {
        this.prezomayorista = prezomayorista;
    }

    public int getPrezoventa() {
        return prezoventa;
    }

    public void setPrezoventa(int prezoventa) {
        this.prezoventa = prezoventa;
    }

    public int getProcentaxeoferta() {
        return procentaxeoferta;
    }

    public void setProcentaxeoferta(int procentaxeoferta) {
        this.procentaxeoferta = procentaxeoferta;
    }

    @Override
    public String toString() {
        return "inventarioTenda{" +
                "idvehiculo=" + idvehiculo +
                ", prezomayorista=" + prezomayorista +
                ", prezoventa=" + prezoventa +
                ", procentaxeoferta=" + procentaxeoferta +
                '}';
    }


}

