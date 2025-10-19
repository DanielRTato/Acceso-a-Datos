package model;

public class InventarioTenda {
    private int id;
    private int idVehiculo;
    private double prezoMayorista;
    private double prezoVenta;
    private int porcentaxeOferta;

    public InventarioTenda(int id, int idVehiculo, double prezoMayorista, double prezoVenta, int porcentaxeOferta) {
        this.id = id;
        this.idVehiculo = idVehiculo;
        this.prezoMayorista = prezoMayorista;
        this.prezoVenta = prezoVenta;
        this.porcentaxeOferta = porcentaxeOferta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public double getPrezoMayorista() {
        return prezoMayorista;
    }

    public void setPrezoMayorista(double prezoMayorista) {
        this.prezoMayorista = prezoMayorista;
    }

    public double getPrezoVenta() {
        return prezoVenta;
    }

    public void setPrezoVenta(double prezoVenta) {
        this.prezoVenta = prezoVenta;
    }

    public int getPorcentaxeOferta() {
        return porcentaxeOferta;
    }

    public void setPorcentaxeOferta(int porcentaxeOferta) {
        this.porcentaxeOferta = porcentaxeOferta;
    }

    @Override
    public String toString() {
        return "InventarioTenda{" +
                "id=" + id +
                ", idVehiculo=" + idVehiculo +
                ", prezoMayorista=" + prezoMayorista +
                ", prezoVenta=" + prezoVenta +
                ", porcentaxeOferta=" + porcentaxeOferta +
                '}';
    }
}


