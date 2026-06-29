public class AristaGrafo {
    private String origen;
    private String destino;
    private String descripcion;
    private int cantidad;

    public AristaGrafo(String origen, String destino, String descripcion, int cantidad) {
        this.origen = origen;
        this.destino = destino;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }
}
