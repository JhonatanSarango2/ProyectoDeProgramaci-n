import java.util.ArrayList;

public class GestionRollos {
    private ArrayList<RolloTela> rollos;
    private PilaAcciones historial;

    public GestionRollos(PilaAcciones historial) {
        this.historial = historial;
        rollos = new ArrayList<>();
        precargarRollos();
    }

    private void precargarRollos() {
        rollos.add(new RolloTela(201, "Algodon", 150.0, 30.0));
        rollos.add(new RolloTela(202, "Jersey", 160.0, 25.0));
        rollos.add(new RolloTela(203, "Gabardina", 140.0, 40.0));
        rollos.add(new RolloTela(204, "Fleece", 180.0, 20.0));
    }

    public ArrayList<RolloTela> getRollos() {
        return rollos;
    }

    public boolean agregarRollo(RolloTela rollo) {
        for (RolloTela r : rollos) {
            if (r.getCodigo() == rollo.getCodigo()) {
                return false;
            }
        }
        rollos.add(rollo);
        historial.apilar("Se agrego el rollo codigo: " + rollo.getCodigo());
        return true;
    }

    public boolean actualizarRollo(int codigo, String tipo, double ancho, double largo) {
        RolloTela r = buscarPorCodigoSecuencial(codigo);
        if (r == null) {
            return false;
        }
        r.setTipo(tipo);
        r.setAncho(ancho);
        r.setLargo(largo);
        historial.apilar("Se actualizo el rollo codigo: " + codigo);
        return true;
    }

    public boolean eliminarRollo(int codigo) {
        for (int i = 0; i < rollos.size(); i++) {
            if (rollos.get(i).getCodigo() == codigo) {
                historial.apilar("Se elimino el rollo codigo: " + codigo);
                rollos.remove(i);
                return true;
            }
        }
        return false;
    }

    private RolloTela buscarPorCodigoSecuencial(int codigo) {
        for (RolloTela r : rollos) {
            if (r.getCodigo() == codigo) {
                return r;
            }
        }
        return null;
    }

    private void ordenarPorCodigoAscendente() {
        int n = rollos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (rollos.get(j).getCodigo() > rollos.get(j + 1).getCodigo()) {
                    RolloTela temp = rollos.get(j);
                    rollos.set(j, rollos.get(j + 1));
                    rollos.set(j + 1, temp);
                }
            }
        }
    }

    public RolloTela buscarPorCodigoBinario(int codigo) {
        ordenarPorCodigoAscendente();
        int inicio = 0;
        int fin = rollos.size() - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            RolloTela rolloMedio = rollos.get(medio);
            if (rolloMedio.getCodigo() == codigo) {
                return rolloMedio;
            }
            if (rolloMedio.getCodigo() < codigo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null;
    }

    public ArrayList<RolloTela> ordenarPorAnchoAscendente() {
        ArrayList<RolloTela> listaOrdenada = new ArrayList<>(rollos);
        int n = listaOrdenada.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listaOrdenada.get(j).getAncho() > listaOrdenada.get(j + 1).getAncho()) {
                    RolloTela temp = listaOrdenada.get(j);
                    listaOrdenada.set(j, listaOrdenada.get(j + 1));
                    listaOrdenada.set(j + 1, temp);
                }
            }
        }
        return listaOrdenada;
    }

    public RolloTela buscarPrimerRolloSuficiente(double anchoRequerido) {
        for (RolloTela r : rollos) {
            if (r.getAncho() >= anchoRequerido) {
                return r;
            }
        }
        return null;
    }

    public double sumarLargoRecursivo(int indice) {
        if (indice >= rollos.size()) {
            return 0.0;
        }
        return rollos.get(indice).getLargo() + sumarLargoRecursivo(indice + 1);
    }
}
