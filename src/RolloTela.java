public class RolloTela {
    private String codigo;
    private String codigoMaterial;
    private String color;
    private double anchoCm;
    private double largoInicialM;
    private double largoDisponibleM;
    private double costoMetro;
    private String proveedor;
    private String lote;
    private String ubicacion;
    private String estado;
    private String notaCalidad;

    public RolloTela(String codigo, String codigoMaterial, String color, double anchoCm,
                     double largoInicialM, double costoMetro, String proveedor,
                     String lote, String ubicacion, String estado, String notaCalidad) {
        this.codigo = codigo;
        this.codigoMaterial = codigoMaterial;
        this.color = color;
        this.anchoCm = anchoCm;
        this.largoInicialM = largoInicialM;
        this.largoDisponibleM = largoInicialM;
        this.costoMetro = costoMetro;
        this.proveedor = proveedor;
        this.lote = lote;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.notaCalidad = notaCalidad;
    }

    public String getCodigo() { return codigo; }
    public String getCodigoMaterial() { return codigoMaterial; }
    public String getColor() { return color; }
    public double getAnchoCm() { return anchoCm; }
    public double getLargoInicialM() { return largoInicialM; }
    public double getLargoDisponibleM() { return largoDisponibleM; }
    public double getCostoMetro() { return costoMetro; }
    public String getProveedor() { return proveedor; }
    public String getLote() { return lote; }
    public String getUbicacion() { return ubicacion; }
    public String getEstado() { return estado; }
    public String getNotaCalidad() { return notaCalidad; }

    public void setColor(String color) { this.color = color; }
    public void setAnchoCm(double anchoCm) { this.anchoCm = anchoCm; }
    public void setLargoDisponibleM(double largoDisponibleM) { this.largoDisponibleM = largoDisponibleM; }
    public void setCostoMetro(double costoMetro) { this.costoMetro = costoMetro; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }
    public void setLote(String lote) { this.lote = lote; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setNotaCalidad(String notaCalidad) { this.notaCalidad = notaCalidad; }

    public boolean descontarMetros(double metros) {
        if (!Validacion.numeroPositivo(metros) || metros > largoDisponibleM || !estado.equals("Disponible")) {
            return false;
        }
        largoDisponibleM = largoDisponibleM - metros;
        if (largoDisponibleM <= 0.000001) {
            largoDisponibleM = 0;
            estado = "Agotado";
        }
        return true;
    }

    public double calcularValorDisponible() {
        return largoDisponibleM * costoMetro;
    }

    public String toString() {
        return codigo + " | " + codigoMaterial + " | " + color + " | " +
                String.format("%.2f", anchoCm) + " cm | " +
                String.format("%.2f", largoDisponibleM) + " m | " + estado +
                " | " + ubicacion;
    }
}
