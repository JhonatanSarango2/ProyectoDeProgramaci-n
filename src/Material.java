public class Material {
    private String codigo;
    private String nombre;
    private String composicion;
    private String proveedorPrincipal;
    private double costoMetroBase;
    private double stockMinimoMetros;
    private String notas;

    public Material(String codigo, String nombre, String composicion, String proveedorPrincipal,
                    double costoMetroBase, double stockMinimoMetros, String notas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.composicion = composicion;
        this.proveedorPrincipal = proveedorPrincipal;
        this.costoMetroBase = costoMetroBase;
        this.stockMinimoMetros = stockMinimoMetros;
        this.notas = notas;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getComposicion() { return composicion; }
    public String getProveedorPrincipal() { return proveedorPrincipal; }
    public double getCostoMetroBase() { return costoMetroBase; }
    public double getStockMinimoMetros() { return stockMinimoMetros; }
    public String getNotas() { return notas; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setComposicion(String composicion) { this.composicion = composicion; }
    public void setProveedorPrincipal(String proveedorPrincipal) { this.proveedorPrincipal = proveedorPrincipal; }
    public void setCostoMetroBase(double costoMetroBase) { this.costoMetroBase = costoMetroBase; }
    public void setStockMinimoMetros(double stockMinimoMetros) { this.stockMinimoMetros = stockMinimoMetros; }
    public void setNotas(String notas) { this.notas = notas; }

    public String toString() {
        return codigo + " - " + nombre + " | " + composicion + " | $" + costoMetroBase + "/m";
    }
}
