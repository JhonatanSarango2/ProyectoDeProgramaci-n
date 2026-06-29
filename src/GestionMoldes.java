import java.util.ArrayList;

public class GestionMoldes {
    private ArrayList<Molde> moldes;

    public GestionMoldes() { moldes = new ArrayList<Molde>(); }

    public boolean agregar(Molde molde) {
        if (buscar(molde.getCodigo()) != null) return false;
        moldes.add(molde);
        return true;
    }

    public Molde buscar(String codigo) {
        for (Molde molde : moldes) {
            if (molde.getCodigo().equalsIgnoreCase(codigo)) return molde;
        }
        return null;
    }

    public String siguienteCodigo() {
        int numero = moldes.size() + 1;
        String codigo = String.format("MOL-%03d", numero);
        while (buscar(codigo) != null) {
            numero++;
            codigo = String.format("MOL-%03d", numero);
        }
        return codigo;
    }

    public int duplicarMoldesModelo(String codigoOrigen, String codigoDestino) {
        ArrayList<Molde> copias = new ArrayList<Molde>();
        int numero = moldes.size() + 1;

        for (Molde molde : moldes) {
            if (molde.getCodigoModelo().equalsIgnoreCase(codigoOrigen)) {
                String codigoNuevo = String.format("MOL-%03d", numero);
                while (buscar(codigoNuevo) != null || existeEnCopias(copias, codigoNuevo)) {
                    numero++;
                    codigoNuevo = String.format("MOL-%03d", numero);
                }
                numero++;
                Molde copia = new Molde(codigoNuevo, codigoDestino, molde.getNombrePieza(),
                        molde.getTalla(), molde.getCantidadCorte(), molde.getAnchoCm(),
                        molde.getAltoCm(), "Activo", "Copia del molde " + molde.getCodigo());
                copias.add(copia);
            }
        }
        for (Molde copia : copias) moldes.add(copia);
        return copias.size();
    }

    private boolean existeEnCopias(ArrayList<Molde> copias, String codigo) {
        for (Molde copia : copias) {
            if (copia.getCodigo().equalsIgnoreCase(codigo)) return true;
        }
        return false;
    }

    public boolean existePiezaActiva(String codigoModelo, String nombrePieza, String talla, String codigoExcluir) {
        for (Molde molde : moldes) {
            boolean mismoModelo = molde.getCodigoModelo().equalsIgnoreCase(codigoModelo);
            boolean mismaPieza = molde.getNombrePieza().equalsIgnoreCase(nombrePieza);
            boolean mismaTalla = molde.getTalla().equalsIgnoreCase(talla);
            boolean diferenteCodigo = codigoExcluir == null || !molde.getCodigo().equalsIgnoreCase(codigoExcluir);
            if (mismoModelo && mismaPieza && mismaTalla && diferenteCodigo && molde.getEstado().equals("Activo")) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Molde> getMoldes() { return moldes; }

    public String listarPorModelo(String codigoModelo) {
        String texto = "--- MOLDES DEL MODELO " + codigoModelo + " ---\n";
        int cantidad = 0;
        for (Molde molde : moldes) {
            if (molde.getCodigoModelo().equalsIgnoreCase(codigoModelo)) {
                texto += molde.toString() + "\n";
                cantidad++;
            }
        }
        if (cantidad == 0) texto += "No existen moldes registrados para este modelo.\n";
        return texto;
    }

    public boolean tieneMoldesActivos(String codigoModelo) {
        for (Molde molde : moldes) {
            if (molde.getCodigoModelo().equalsIgnoreCase(codigoModelo) && molde.getEstado().equals("Activo")) {
                return true;
            }
        }
        return false;
    }
}
