import java.util.ArrayList;

public class GrafoTrazabilidad {
    private ArrayList<String> vertices;
    private ArrayList<AristaGrafo> aristas;

    public GrafoTrazabilidad() {
        vertices = new ArrayList<String>();
        aristas = new ArrayList<AristaGrafo>();
    }

    private void limpiar() {
        vertices.clear();
        aristas.clear();
    }

    private void agregarVertice(String vertice) {
        if (!vertices.contains(vertice)) {
            vertices.add(vertice);
        }
    }

    private void agregarConexion(String origen, String destino, String descripcion) {
        agregarVertice(origen);
        agregarVertice(destino);
        aristas.add(new AristaGrafo(origen, destino, descripcion, 0));
    }

    public void construir(ArrayList<RolloTela> rollos, ArrayList<Pedido> pedidos) {
        limpiar();

        for (RolloTela rollo : rollos) {
            String lote = "LOTE:" + rollo.getLote();
            String nodoRollo = "ROLLO:" + rollo.getCodigo();
            agregarConexion(lote, nodoRollo, "contiene");
        }

        for (Pedido pedido : pedidos) {
            if (pedido.getCodigoRollo() != null && pedido.getCodigoRollo().trim().length() > 0) {
                String nodoRollo = "ROLLO:" + pedido.getCodigoRollo();
                String nodoPedido = "PEDIDO:" + pedido.getCodigo();
                agregarConexion(nodoRollo, nodoPedido, "se utilizó en");
            }
        }
    }

    public String rastrearLote(String loteSeleccionado, ArrayList<Pedido> pedidos) {
        if (loteSeleccionado == null || loteSeleccionado.trim().length() == 0) {
            return "Seleccione un lote para revisar su trazabilidad.";
        }

        String inicio = "LOTE:" + loteSeleccionado;
        if (!vertices.contains(inicio)) {
            return "No existen rollos registrados para ese lote.";
        }

        ArrayList<String> cola = new ArrayList<String>();
        ArrayList<String> visitados = new ArrayList<String>();
        ArrayList<String> pedidosEncontrados = new ArrayList<String>();
        int posicion = 0;

        cola.add(inicio);
        visitados.add(inicio);

        String texto = "GRAFO DE TRAZABILIDAD DEL LOTE " + loteSeleccionado + "\n\n";
        texto += "Recorrido desde el lote hacia sus rollos y pedidos asociados:\n\n";

        while (posicion < cola.size()) {
            String actual = cola.get(posicion);
            posicion++;

            for (AristaGrafo arista : aristas) {
                if (arista.getOrigen().equals(actual)) {
                    String destino = arista.getDestino();
                    texto += nombreNodo(actual) + " -> " + nombreNodo(destino)
                            + " (" + arista.getDescripcion() + ")\n";

                    if (!visitados.contains(destino)) {
                        visitados.add(destino);
                        cola.add(destino);
                    }

                    if (destino.startsWith("PEDIDO:") && !pedidosEncontrados.contains(destino)) {
                        pedidosEncontrados.add(destino);
                    }
                }
            }
        }

        texto += "\nPEDIDOS RELACIONADOS\n";
        if (pedidosEncontrados.size() == 0) {
            texto += "No hay pedidos terminados que hayan utilizado rollos de este lote.\n";
        } else {
            for (String nodoPedido : pedidosEncontrados) {
                String codigoPedido = nodoPedido.replace("PEDIDO:", "");
                Pedido pedido = buscarPedido(pedidos, codigoPedido);
                if (pedido != null) {
                    texto += pedido.getCodigo() + " | Estado: " + pedido.getEstado()
                            + " | Rollo: " + pedido.getCodigoRollo()
                            + " | Metros usados: " + String.format("%.2f", pedido.getMetrosConsumidos()) + " m\n";
                }
            }
        }

        return texto;
    }

    private String nombreNodo(String nodo) {
        if (nodo.startsWith("LOTE:")) return "Lote " + nodo.replace("LOTE:", "");
        if (nodo.startsWith("ROLLO:")) return "Rollo " + nodo.replace("ROLLO:", "");
        if (nodo.startsWith("PEDIDO:")) return "Pedido " + nodo.replace("PEDIDO:", "");
        return nodo;
    }

    private Pedido buscarPedido(ArrayList<Pedido> pedidos, String codigo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo().equalsIgnoreCase(codigo)) {
                return pedido;
            }
        }
        return null;
    }
}
