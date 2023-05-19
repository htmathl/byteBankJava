package TItular;

import java.util.ArrayList;

public class Clientes {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    public Clientes(Cliente clientes) {
        Clientes.clientes.add(clientes);
    }
    public void showClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}
