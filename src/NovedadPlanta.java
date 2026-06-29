public class NovedadPlanta {
    private String codigo;
    private String fecha;
    private String maquinaArea;
    private String tipo;
    private String prioridad;
    private String responsable;
    private double horasDetenida;
    private String descripcion;
    private String estado;
    private String solucion;

    public NovedadPlanta(String codigo, String fecha, String maquinaArea, String tipo,
                         String prioridad, String responsable, double horasDetenida,
                         String descripcion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.maquinaArea = maquinaArea;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.responsable = responsable;
        this.horasDetenida = horasDetenida;
        this.descripcion = descripcion;
        this.estado = "Abierta";
        this.solucion = "";
    }

    public String getCodigo() { return codigo; }
    public String getFecha() { return fecha; }
    public String getMaquinaArea() { return maquinaArea; }
    public String getTipo() { return tipo; }
    public String getPrioridad() { return prioridad; }
    public String getResponsable() { return responsable; }
    public double getHorasDetenida() { return horasDetenida; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    public String getSolucion() { return solucion; }

    public void resolver(String solucion) {
        this.estado = "Resuelta";
        this.solucion = solucion;
    }

    public String toString() {
        return codigo + " | " + fecha + " | " + maquinaArea + " | " + tipo +
                " | " + prioridad + " | " + estado + " | " + horasDetenida + " h\n" +
                "Detalle: " + descripcion + "\nSolución: " + solucion;
    }
}
