import java.util.ArrayList;

public class PilaAcciones {
    private ArrayList<String> acciones;

    public PilaAcciones() {
        acciones = new ArrayList<>();
    }

    public void apilar(String accion) {
        acciones.add(accion);
    }

    public String desapilar() {
        if (acciones.size() == 0) {
            return "No hay acciones registradas.";
        }
        return acciones.remove(acciones.size() - 1);
    }

    public String mostrarHistorial() {
        if (acciones.size() == 0) {
            return "No hay acciones registradas.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("--- HISTORIAL DE ACCIONES ---\n");
        for (int i = acciones.size() - 1; i >= 0; i--) {
            sb.append(acciones.get(i)).append("\n");
        }
        return sb.toString();
    }
}
