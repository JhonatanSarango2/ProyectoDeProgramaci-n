import java.util.ArrayList;

public class GestionNovedades {
    private ArrayList<NovedadPlanta> novedades;

    public GestionNovedades() { novedades = new ArrayList<NovedadPlanta>(); }

    public String siguienteCodigo() {
        int numero = novedades.size() + 1;
        return String.format("NOV-%03d", numero);
    }

    public boolean agregar(NovedadPlanta novedad) {
        novedades.add(novedad);
        return true;
    }

    public NovedadPlanta buscar(String codigo) {
        for (NovedadPlanta novedad : novedades) {
            if (novedad.getCodigo().equalsIgnoreCase(codigo)) return novedad;
        }
        return null;
    }

    public ArrayList<NovedadPlanta> getNovedades() { return novedades; }

    public int contarAbiertas() {
        int total = 0;
        for (NovedadPlanta novedad : novedades) {
            if (novedad.getEstado().equals("Abierta")) total++;
        }
        return total;
    }

    public String listar() {
        String texto = "--- NOVEDADES DE PLANTA ---\n";
        for (NovedadPlanta novedad : novedades) texto += novedad.toString() + "\n-------------------------------\n";
        return texto;
    }
}
