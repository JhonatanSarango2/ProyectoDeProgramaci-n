import java.util.ArrayList;

public class PilaAcciones {
    private ArrayList<String> acciones;

    public PilaAcciones() {
        acciones = new ArrayList<String>();
    }

    public void registrar(String responsable, String detalle) {
        String nombre = responsable == null || responsable.trim().equals("") ? "Sistema" : responsable.trim();
        String codigo = String.format("ACT-%03d", acciones.size() + 1);
        acciones.add(codigo + " | " + nombre + " | " + detalle);
    }

    public String mostrarHistorial() {
        String texto = "--- HISTORIAL DE ACCIONES DE LA SESIÓN ---\n";
        if (acciones.size() == 0) {
            return texto + "No existen acciones registradas todavía.\n";
        }
        for (int i = acciones.size() - 1; i >= 0; i--) {
            texto += acciones.get(i) + "\n";
        }
        return texto;
    }

    public int cantidadAcciones() {
        return acciones.size();
    }
}
