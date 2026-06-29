public class Cliente {
    private String codigo;
    private String nombre;
    private String telefono;
    private String correo;
    private String notas;

    public Cliente(String codigo, String nombre, String telefono, String correo, String notas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.notas = notas;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getNotas() { return notas; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setNotas(String notas) { this.notas = notas; }

    public String toString() {
        return codigo + " - " + nombre + " | " + telefono;
    }
}
