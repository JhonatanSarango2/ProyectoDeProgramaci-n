public class ModeloPrenda {
    private String codigo;
    private String codigoLinea;
    private String nombre;
    private String tipoManga;
    private String tipoCuello;
    private String talla;
    private String codigoMaterial;
    private double anchoMinimoTela;
    private double consumoPorUnidad;
    private double precioVenta;
    private String estado;
    private String notas;

    public ModeloPrenda(String codigo, String codigoLinea, String nombre, String tipoManga,
                         String tipoCuello, String talla, String codigoMaterial,
                         double anchoMinimoTela, double consumoPorUnidad,
                         double precioVenta, String estado, String notas) {
        this.codigo = codigo;
        this.codigoLinea = codigoLinea;
        this.nombre = nombre;
        this.tipoManga = tipoManga;
        this.tipoCuello = tipoCuello;
        this.talla = talla;
        this.codigoMaterial = codigoMaterial;
        this.anchoMinimoTela = anchoMinimoTela;
        this.consumoPorUnidad = consumoPorUnidad;
        this.precioVenta = precioVenta;
        this.estado = estado;
        this.notas = notas;
    }

    public String getCodigo() { return codigo; }
    public String getCodigoLinea() { return codigoLinea; }
    public String getNombre() { return nombre; }
    public String getTipoManga() { return tipoManga; }
    public String getTipoCuello() { return tipoCuello; }
    public String getTalla() { return talla; }
    public String getCodigoMaterial() { return codigoMaterial; }
    public double getAnchoMinimoTela() { return anchoMinimoTela; }
    public double getConsumoPorUnidad() { return consumoPorUnidad; }
    public double getPrecioVenta() { return precioVenta; }
    public String getEstado() { return estado; }
    public String getNotas() { return notas; }

    public void setCodigoLinea(String codigoLinea) { this.codigoLinea = codigoLinea; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipoManga(String tipoManga) { this.tipoManga = tipoManga; }
    public void setTipoCuello(String tipoCuello) { this.tipoCuello = tipoCuello; }
    public void setTalla(String talla) { this.talla = talla; }
    public void setCodigoMaterial(String codigoMaterial) { this.codigoMaterial = codigoMaterial; }
    public void setAnchoMinimoTela(double anchoMinimoTela) { this.anchoMinimoTela = anchoMinimoTela; }
    public void setConsumoPorUnidad(double consumoPorUnidad) { this.consumoPorUnidad = consumoPorUnidad; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setNotas(String notas) { this.notas = notas; }

    public double calcularMetrosNecesarios(int cantidad) {
        return consumoPorUnidad * cantidad;
    }

    public String toString() {
        return codigo + " - " + nombre + " | " + tipoManga + " | Talla " + talla + " | " + estado;
    }
}
