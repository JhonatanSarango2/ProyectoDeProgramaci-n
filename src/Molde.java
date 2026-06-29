public class Molde {
    private String codigo;
    private String codigoModelo;
    private String nombrePieza;
    private String talla;
    private int cantidadCorte;
    private double anchoCm;
    private double altoCm;
    private String estado;
    private String notas;

    public Molde(String codigo, String codigoModelo, String nombrePieza, String talla,
                 int cantidadCorte, double anchoCm, double altoCm,
                 String estado, String notas) {
        this.codigo = codigo;
        this.codigoModelo = codigoModelo;
        this.nombrePieza = nombrePieza;
        this.talla = talla;
        this.cantidadCorte = cantidadCorte;
        this.anchoCm = anchoCm;
        this.altoCm = altoCm;
        this.estado = estado;
        this.notas = notas;
    }

    public String getCodigo() { return codigo; }
    public String getCodigoModelo() { return codigoModelo; }
    public String getNombrePieza() { return nombrePieza; }
    public String getTalla() { return talla; }
    public int getCantidadCorte() { return cantidadCorte; }
    public double getAnchoCm() { return anchoCm; }
    public double getAltoCm() { return altoCm; }
    public String getEstado() { return estado; }
    public String getNotas() { return notas; }

    public void setCodigoModelo(String codigoModelo) { this.codigoModelo = codigoModelo; }
    public void setNombrePieza(String nombrePieza) { this.nombrePieza = nombrePieza; }
    public void setTalla(String talla) { this.talla = talla; }
    public void setCantidadCorte(int cantidadCorte) { this.cantidadCorte = cantidadCorte; }
    public void setAnchoCm(double anchoCm) { this.anchoCm = anchoCm; }
    public void setAltoCm(double altoCm) { this.altoCm = altoCm; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setNotas(String notas) { this.notas = notas; }

    public double calcularArea() {
        return anchoCm * altoCm;
    }

    public String toString() {
        return codigo + " - " + nombrePieza + " | Talla " + talla +
                " | Área: " + String.format("%.2f", calcularArea()) + " cm2" +
                " | Cantidad: " + cantidadCorte + " | " + estado;
    }
}
