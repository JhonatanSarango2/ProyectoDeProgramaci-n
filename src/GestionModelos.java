import java.util.ArrayList;

public class GestionModelos {
    private ArrayList<ModeloPrenda> modelos;

    public GestionModelos() { modelos = new ArrayList<ModeloPrenda>(); }

    public boolean agregar(ModeloPrenda modelo) {
        if (buscar(modelo.getCodigo()) != null) return false;
        modelos.add(modelo);
        return true;
    }

    public ModeloPrenda buscar(String codigo) {
        for (ModeloPrenda modelo : modelos) {
            if (modelo.getCodigo().equalsIgnoreCase(codigo)) return modelo;
        }
        return null;
    }

    public boolean duplicar(String codigoOrigen, String codigoNuevo, String nuevoNombre, String nuevaManga) {
        ModeloPrenda origen = buscar(codigoOrigen);
        if (origen == null || buscar(codigoNuevo) != null) return false;
        ModeloPrenda copia = new ModeloPrenda(codigoNuevo, origen.getCodigoLinea(), nuevoNombre,
                nuevaManga, origen.getTipoCuello(), origen.getTalla(), origen.getCodigoMaterial(),
                origen.getAnchoMinimoTela(), origen.getConsumoPorUnidad(),
                origen.getPrecioVenta(), "Activo", "Duplicado desde " + origen.getCodigo());
        modelos.add(copia);
        return true;
    }

    public ArrayList<ModeloPrenda> getModelos() { return modelos; }

    public String listar() {
        String texto = "--- MODELOS DE PRENDA ---\n";
        for (ModeloPrenda modelo : modelos) texto += modelo.toString() + "\n";
        return texto;
    }
}
