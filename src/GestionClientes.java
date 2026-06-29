import java.util.ArrayList;

public class GestionClientes {
    private ArrayList<Cliente> clientes;

    public GestionClientes() { clientes = new ArrayList<Cliente>(); }

    public boolean agregar(Cliente cliente) {
        if (buscar(cliente.getCodigo()) != null) return false;
        clientes.add(cliente);
        return true;
    }

    public Cliente buscar(String codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo().equalsIgnoreCase(codigo)) return cliente;
        }
        return null;
    }

    public ArrayList<Cliente> getClientes() { return clientes; }

    public String listar() {
        String texto = "--- CLIENTES ---\n";
        for (Cliente cliente : clientes) texto += cliente.toString() + "\n";
        return texto;
    }
}
