import java.util.ArrayList;

public class GestionMoldes {
    private ArrayList<Molde> moldes;
    private PilaAcciones historial;

    public GestionMoldes(PilaAcciones historial) {
        this.historial = historial;
        moldes = new ArrayList<>();
        precargarMoldes();
    }

    private void precargarMoldes() {
        moldes.add(new Molde(101, "Manga corta", "Camiseta", 540.0));
        moldes.add(new Molde(102, "Frente camiseta", "Camiseta", 1200.0));
        moldes.add(new Molde(103, "Espalda camiseta", "Camiseta", 1250.0));
        moldes.add(new Molde(104, "Cuello polo", "Polo", 280.0));
        moldes.add(new Molde(105, "Pierna pantalon", "Pantalon", 1800.0));
    }

    public ArrayList<Molde> getMoldes() {
        return moldes;
    }

    public boolean agregarMolde(Molde molde) {
        for (Molde m : moldes) {
            if (m.getCodigo() == molde.getCodigo()) {
                return false;
            }
        }
        moldes.add(molde);
        historial.apilar("Se agrego el molde: " + molde.getNombre());
        return true;
    }

    public boolean actualizarMolde(int codigo, String nombre, String tipo, double area) {
        Molde m = buscarPorCodigoSecuencial(codigo);
        if (m == null) {
            return false;
        }
        m.setNombre(nombre);
        m.setTipo(tipo);
        m.setArea(area);
        historial.apilar("Se actualizo el molde codigo: " + codigo);
        return true;
    }

    public boolean eliminarMolde(int codigo) {
        for (int i = 0; i < moldes.size(); i++) {
            if (moldes.get(i).getCodigo() == codigo) {
                historial.apilar("Se elimino el molde: " + moldes.get(i).getNombre());
                moldes.remove(i);
                return true;
            }
        }
        return false;
    }

    private Molde buscarPorCodigoSecuencial(int codigo) {
        for (Molde m : moldes) {
            if (m.getCodigo() == codigo) {
                return m;
            }
        }
        return null;
    }

    public Molde buscarPorNombreSecuencial(String nombre) {
        for (Molde m : moldes) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

    private void ordenarPorCodigoAscendente() {
        int n = moldes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (moldes.get(j).getCodigo() > moldes.get(j + 1).getCodigo()) {
                    Molde temp = moldes.get(j);
                    moldes.set(j, moldes.get(j + 1));
                    moldes.set(j + 1, temp);
                }
            }
        }
    }

    public Molde buscarPorCodigoBinario(int codigo) {
        ordenarPorCodigoAscendente();
        int inicio = 0;
        int fin = moldes.size() - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            Molde moldeMedio = moldes.get(medio);
            if (moldeMedio.getCodigo() == codigo) {
                return moldeMedio;
            }
            if (moldeMedio.getCodigo() < codigo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null;
    }

    public ArrayList<Molde> ordenarPorAreaDescendente() {
        ArrayList<Molde> listaOrdenada = new ArrayList<>(moldes);
        int n = listaOrdenada.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listaOrdenada.get(j).getArea() < listaOrdenada.get(j + 1).getArea()) {
                    Molde temp = listaOrdenada.get(j);
                    listaOrdenada.set(j, listaOrdenada.get(j + 1));
                    listaOrdenada.set(j + 1, temp);
                }
            }
        }
        return listaOrdenada;
    }

    public Molde buscarMayorAreaRecursivo(int indice) {
        if (moldes.size() == 0) {
            return null;
        }
        if (indice == moldes.size() - 1) {
            return moldes.get(indice);
        }
        Molde actual = moldes.get(indice);
        Molde mayorRestante = buscarMayorAreaRecursivo(indice + 1);
        if (mayorRestante != null && mayorRestante.getArea() > actual.getArea()) {
            return mayorRestante;
        } else {
            return actual;
        }
    }

    public int contarPorTipoRecursivo(String tipo, int indice) {
        if (indice >= moldes.size()) {
            return 0;
        }
        int cuentaActual = moldes.get(indice).getTipo().equalsIgnoreCase(tipo) ? 1 : 0;
        return cuentaActual + contarPorTipoRecursivo(tipo, indice + 1);
    }
}