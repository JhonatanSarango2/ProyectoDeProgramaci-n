import java.util.ArrayList;

public class GestionLineas {
    private ArrayList<LineaProducto> lineas;

    public GestionLineas() {
        lineas = new ArrayList<LineaProducto>();
    }

    public boolean agregar(LineaProducto linea) {
        if (buscar(linea.getCodigo()) != null) return false;
        lineas.add(linea);
        return true;
    }

    public LineaProducto buscar(String codigo) {
        for (LineaProducto linea : lineas) {
            if (linea.getCodigo().equalsIgnoreCase(codigo)) return linea;
        }
        return null;
    }

    public ArrayList<LineaProducto> getLineas() { return lineas; }

    public String listar() {
        String texto = "--- LÍNEAS DE PRODUCTO ---\n";
        for (LineaProducto linea : lineas) texto += linea.toString() + "\n";
        return texto;
    }
}
