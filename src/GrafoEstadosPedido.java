import java.util.ArrayList;

public class GrafoEstadosPedido {
    private ArrayList<String> estados;
    private ArrayList<AristaGrafo> transiciones;

    public GrafoEstadosPedido() {
        estados = new ArrayList<String>();
        transiciones = new ArrayList<AristaGrafo>();

        agregarEstado("Pendiente");
        agregarEstado("En producción");
        agregarEstado("Terminado");
        agregarEstado("Cancelado");

        agregarTransicion("Pendiente", "En producción", "Iniciar trabajo");
        agregarTransicion("Pendiente", "Cancelado", "Cancelar antes de producir");
        agregarTransicion("En producción", "Terminado", "Registrar resultado final");
    }

    private void agregarEstado(String estado) {
        if (!estados.contains(estado)) {
            estados.add(estado);
        }
    }

    private void agregarTransicion(String origen, String destino, String descripcion) {
        transiciones.add(new AristaGrafo(origen, destino, descripcion, 0));
    }

    public boolean puedeCambiar(String estadoActual, String nuevoEstado) {
        for (AristaGrafo transicion : transiciones) {
            if (transicion.getOrigen().equalsIgnoreCase(estadoActual)
                    && transicion.getDestino().equalsIgnoreCase(nuevoEstado)) {
                return true;
            }
        }
        return false;
    }

    public String listarGrafo() {
        String texto = "GRAFO DE ESTADOS DEL PEDIDO\n\n";
        texto += "El sistema solo permite las transiciones mostradas:\n\n";

        for (AristaGrafo transicion : transiciones) {
            texto += "[" + transicion.getOrigen() + "] -> [" + transicion.getDestino()
                    + "] : " + transicion.getDescripcion() + "\n";
        }

        texto += "\nRegla de seguridad: no existe una conexión desde Cancelado a Terminado.\n";
        texto += "Por eso el programa bloquea cambios de estado inválidos.";
        return texto;
    }
}
