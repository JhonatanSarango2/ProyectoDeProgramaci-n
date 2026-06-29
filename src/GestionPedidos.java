import java.util.ArrayList;

public class GestionPedidos {
    private ArrayList<Pedido> pedidos;
    private GrafoEstadosPedido grafoEstados;

    public GestionPedidos() {
        pedidos = new ArrayList<Pedido>();
        grafoEstados = new GrafoEstadosPedido();
    }

    public String siguienteCodigo() {
        int numero = pedidos.size() + 1;
        String codigo = String.format("PED-%03d", numero);
        while (buscar(codigo) != null) {
            numero++;
            codigo = String.format("PED-%03d", numero);
        }
        return codigo;
    }

    public boolean agregar(Pedido pedido) {
        if (buscar(pedido.getCodigo()) != null) return false;
        pedidos.add(pedido);
        return true;
    }

    public Pedido buscar(String codigo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo().equalsIgnoreCase(codigo)) return pedido;
        }
        return null;
    }

    public boolean iniciarProduccion(Pedido pedido, String responsable) {
        if (pedido == null) return false;
        if (!Validacion.textoObligatorio(responsable, 60)) return false;
        if (!grafoEstados.puedeCambiar(pedido.getEstado(), "En producción")) return false;

        pedido.setResponsable(responsable.trim());
        pedido.setEstado("En producción");
        return true;
    }

    public boolean cancelarPedido(Pedido pedido) {
        if (pedido == null) return false;
        if (!grafoEstados.puedeCambiar(pedido.getEstado(), "Cancelado")) return false;

        pedido.setEstado("Cancelado");
        return true;
    }

    public boolean registrarProduccion(Pedido pedido, RolloTela rollo, double metrosReales,
                                       String responsable, int terminadas, int defectuosas,
                                       String observacion) {
        if (pedido == null || rollo == null) return false;
        if (!grafoEstados.puedeCambiar(pedido.getEstado(), "Terminado")) return false;
        if (!Validacion.textoObligatorio(responsable, 60)) return false;
        if (!Validacion.numeroPositivo(metrosReales) || metrosReales > rollo.getLargoDisponibleM()) return false;
        if (!Validacion.enteroNoNegativo(terminadas) || !Validacion.enteroNoNegativo(defectuosas)) return false;
        if (terminadas + defectuosas != pedido.getCantidad()) return false;
        if (defectuosas > 0 && !Validacion.textoObligatorio(observacion, 300)) return false;
        if (!rollo.descontarMetros(metrosReales)) return false;

        pedido.setCodigoRollo(rollo.getCodigo());
        pedido.setMetrosConsumidos(metrosReales);
        pedido.setResponsable(responsable.trim());
        pedido.setPrendasTerminadas(terminadas);
        pedido.setPrendasDefectuosas(defectuosas);
        pedido.setNotas(observacion.trim());
        pedido.setEstado("Terminado");
        return true;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public GrafoEstadosPedido getGrafoEstados() {
        return grafoEstados;
    }

    public int contarPendientes() {
        int total = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equals("Pendiente") || pedido.getEstado().equals("En producción")) {
                total++;
            }
        }
        return total;
    }

    public String listar() {
        String texto = "--- PEDIDOS ---\n";
        for (Pedido pedido : pedidos) texto += pedido.toString() + "\n";
        return texto;
    }
}
