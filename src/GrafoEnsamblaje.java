import java.util.ArrayList;

public class GrafoEnsamblaje {
    private ArrayList<String> vertices;
    private ArrayList<AristaGrafo> aristas;
    private int cantidadSubmoldes;
    private int totalPiezas;

    public GrafoEnsamblaje() {
        vertices = new ArrayList<String>();
        aristas = new ArrayList<AristaGrafo>();
        cantidadSubmoldes = 0;
        totalPiezas = 0;
    }

    public void limpiar() {
        vertices.clear();
        aristas.clear();
        cantidadSubmoldes = 0;
        totalPiezas = 0;
    }

    private void agregarVertice(String vertice) {
        if (!vertices.contains(vertice)) {
            vertices.add(vertice);
        }
    }

    public void construir(ModeloPrenda modelo, ArrayList<Molde> moldes) {
        limpiar();
        if (modelo == null) {
            return;
        }

        String raiz = "MODELO:" + modelo.getCodigo();
        agregarVertice(raiz);

        for (Molde molde : moldes) {
            if (molde.getCodigoModelo().equalsIgnoreCase(modelo.getCodigo())
                    && molde.getEstado().equalsIgnoreCase("Activo")) {
                String destino = "SUBMOLDE:" + molde.getCodigo();
                agregarVertice(destino);
                aristas.add(new AristaGrafo(raiz, destino, molde.getNombrePieza(), molde.getCantidadCorte()));
                cantidadSubmoldes++;
                totalPiezas = totalPiezas + molde.getCantidadCorte();
            }
        }
    }

    public String recorrerProfundidad(ModeloPrenda modelo) {
        if (modelo == null) {
            return "Seleccione un modelo para visualizar su grafo de submoldes.";
        }

        String raiz = "MODELO:" + modelo.getCodigo();
        if (!vertices.contains(raiz)) {
            return "No se pudo construir el grafo.";
        }

        ArrayList<String> visitados = new ArrayList<String>();
        StringBuilder texto = new StringBuilder();
        texto.append("GRAFO DE ENSAMBLAJE / SUBMOLDES\n\n");
        texto.append("Modelo raíz: ").append(modelo.getCodigo()).append(" - ").append(modelo.getNombre()).append("\n");
        texto.append("Cada flecha indica que el modelo está compuesto por un submolde.\n\n");
        texto.append(modelo.getCodigo()).append(" (").append(modelo.getNombre()).append(")\n");
        recorrerDFS(raiz, visitados, texto, 1);

        texto.append("\nRESUMEN\n");
        texto.append("Submoldes activos registrados: ").append(cantidadSubmoldes).append("\n");
        texto.append("Piezas que se cortan por prenda: ").append(totalPiezas).append("\n");

        if (cantidadSubmoldes == 0) {
            texto.append("No existen submoldes activos. Agréguelos uno por uno, sin límite, desde la pestaña Submoldes por modelo.\n");
        }

        return texto.toString();
    }

    private void recorrerDFS(String actual, ArrayList<String> visitados, StringBuilder texto, int nivel) {
        visitados.add(actual);

        for (AristaGrafo arista : aristas) {
            if (arista.getOrigen().equals(actual) && !visitados.contains(arista.getDestino())) {
                String sangria = "";
                for (int i = 0; i < nivel; i++) {
                    sangria += "   ";
                }

                String codigoSubmolde = arista.getDestino().replace("SUBMOLDE:", "");
                texto.append(sangria).append("-> ").append(codigoSubmolde).append(" | ")
                        .append(arista.getDescripcion()).append(" | Cantidad: ")
                        .append(arista.getCantidad()).append("\n");

                recorrerDFS(arista.getDestino(), visitados, texto, nivel + 1);
            }
        }
    }

    public int getCantidadSubmoldes() {
        return cantidadSubmoldes;
    }

    public int getTotalPiezas() {
        return totalPiezas;
    }
}
