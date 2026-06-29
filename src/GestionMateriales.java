import java.util.ArrayList;

public class GestionMateriales {
    private ArrayList<Material> materiales;

    public GestionMateriales() { materiales = new ArrayList<Material>(); }

    public boolean agregar(Material material) {
        if (buscar(material.getCodigo()) != null) return false;
        materiales.add(material);
        return true;
    }

    public Material buscar(String codigo) {
        for (Material material : materiales) {
            if (material.getCodigo().equalsIgnoreCase(codigo)) return material;
        }
        return null;
    }

    public ArrayList<Material> getMateriales() { return materiales; }

    public String listar() {
        String texto = "--- MATERIALES ---\n";
        for (Material material : materiales) texto += material.toString() + "\n";
        return texto;
    }
}
