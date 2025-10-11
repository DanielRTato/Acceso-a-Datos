public class InventarioTenda {
    private int id;
    private int vehiculoId;
    private double prezoMayorista;
    private double prezoVenta;
    private int porcentaje;

    public InventarioTenda(int vehiculoId, double prezoMayorista, double prezoVenta, int porcentaje) {
        this.vehiculoId = vehiculoId;
        this.prezoMayorista = prezoMayorista;
        this.prezoVenta = prezoVenta;
        this.porcentaje = porcentaje;
    }

    public InventarioTenda() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
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

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "InventarioTenda{" +
                "id=" + id +
                ", vehiculoId=" + vehiculoId +
                ", prezoMayorista=" + prezoMayorista +
                ", prezoVenta=" + prezoVenta +
                ", porcentaje=" + porcentaje +
                '}';
    }
}

