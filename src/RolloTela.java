public class RolloTela {
    private int codigo;
    private String tipo;
    private double ancho;
    private double largo;

    public RolloTela(int codigo, String tipo, double ancho, double largo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.ancho = ancho;
        this.largo = largo;
    }

    public int getCodigo() { return codigo; }
    public String getTipo() { return tipo; }
    public double getAncho() { return ancho; }
    public double getLargo() { return largo; }

    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setAncho(double ancho) { this.ancho = ancho; }
    public void setLargo(double largo) { this.largo = largo; }

    public double calcularAreaDisponible() {
        return ancho * largo;
    }

    @Override
    public String toString() {
        return "Rollo [Codigo=" + codigo + ", Tipo=" + tipo + ", Ancho=" + ancho + ", Largo=" + largo + "]";
    }
}
