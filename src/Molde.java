public class Molde {
    private int codigo;
    private String nombre;
    private String tipo;
    private double area;

    public Molde(int codigo, String nombre, String tipo, double area) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.area = area;
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getArea() { return area; }

    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setArea(double area) { this.area = area; }

    @Override
    public String toString() {
        return "Molde [Codigo=" + codigo + ", Nombre=" + nombre + ", Tipo=" + tipo + ", Area=" + area + "]";
    }
}

