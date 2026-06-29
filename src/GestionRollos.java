import java.util.ArrayList;

public class GestionRollos {
    private ArrayList<RolloTela> rollos;

    public GestionRollos() { rollos = new ArrayList<RolloTela>(); }

    public String siguienteCodigo() {
        int numero = rollos.size() + 1;
        String codigo = String.format("ROL-%03d", numero);
        while (buscar(codigo) != null) {
            numero++;
            codigo = String.format("ROL-%03d", numero);
        }
        return codigo;
    }

    public boolean agregarLote(String codigoMaterial, String color, double anchoCm,
                               double largoPorRollo, int cantidad, double costoMetro,
                               String proveedor, String lote, String ubicacion,
                               String notaCalidad) {
        if (!Validacion.textoObligatorio(codigoMaterial, 15) || !Validacion.textoObligatorio(color, 50)
                || !Validacion.textoObligatorio(proveedor, 80) || !Validacion.textoObligatorio(lote, 40)
                || !Validacion.textoObligatorio(ubicacion, 80)) return false;
        if (!Validacion.enteroPositivo(cantidad) || !Validacion.numeroPositivo(anchoCm)
                || !Validacion.numeroPositivo(largoPorRollo) || !Validacion.numeroPositivo(costoMetro)) return false;
        for (int i = 0; i < cantidad; i++) {
            String codigo = siguienteCodigo();
            RolloTela rollo = new RolloTela(codigo, codigoMaterial, color, anchoCm,
                    largoPorRollo, costoMetro, proveedor, lote, ubicacion,
                    "Disponible", notaCalidad);
            rollos.add(rollo);
        }
        return true;
    }

    public RolloTela buscar(String codigo) {
        for (RolloTela rollo : rollos) {
            if (rollo.getCodigo().equalsIgnoreCase(codigo)) return rollo;
        }
        return null;
    }

    public RolloTela buscarCompatible(String codigoMaterial, double anchoMinimo, double metrosNecesarios) {
        RolloTela elegido = null;
        for (RolloTela rollo : rollos) {
            if (rollo.getCodigoMaterial().equalsIgnoreCase(codigoMaterial)
                    && rollo.getEstado().equals("Disponible")
                    && rollo.getAnchoCm() >= anchoMinimo
                    && rollo.getLargoDisponibleM() >= metrosNecesarios) {
                if (elegido == null || rollo.getLargoDisponibleM() < elegido.getLargoDisponibleM()) {
                    elegido = rollo;
                }
            }
        }
        return elegido;
    }

    public ArrayList<RolloTela> getRollos() { return rollos; }

    public double metrosPorMaterial(String codigoMaterial) {
        double total = 0;
        for (RolloTela rollo : rollos) {
            if (rollo.getCodigoMaterial().equalsIgnoreCase(codigoMaterial)
                    && !rollo.getEstado().equals("Dañado")) {
                total += rollo.getLargoDisponibleM();
            }
        }
        return total;
    }

    public double totalMetros() {
        double total = 0;
        for (RolloTela rollo : rollos) {
            if (!rollo.getEstado().equals("Dañado")) total += rollo.getLargoDisponibleM();
        }
        return total;
    }

    public double totalValor() {
        double total = 0;
        for (RolloTela rollo : rollos) total += rollo.calcularValorDisponible();
        return total;
    }

    public String listar() {
        String texto = "--- INVENTARIO DE ROLLOS ---\n";
        for (RolloTela rollo : rollos) texto += rollo.toString() + "\n";
        return texto;
    }
}
