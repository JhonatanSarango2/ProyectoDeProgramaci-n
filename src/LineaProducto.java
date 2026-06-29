public class LineaProducto {
    private String codigo;
    private String nombre;
    private String categoria;
    private String estado;
    private String notas;

    public LineaProducto(String codigo, String nombre, String categoria, String estado, String notas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.estado = estado;
        this.notas = notas;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getEstado() { return estado; }
    public String getNotas() { return notas; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setNotas(String notas) { this.notas = notas; }

    public String toString() {
        return codigo + " - " + nombre + " | " + categoria + " | " + estado;
    }
}
