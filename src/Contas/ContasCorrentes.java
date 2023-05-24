package Contas;

import java.util.ArrayList;

public class ContasCorrentes {
    private static final ArrayList<ContaCorrente> contaCorrentes = new ArrayList<>();
    public ArrayList<ContaCorrente> getContaCorrentes() {
        return contaCorrentes;
    }
    public ContasCorrentes() {}
    public ContasCorrentes(ContaCorrente contaCorrente) {
        contaCorrentes.add(contaCorrente);
    }
    public void showContas() {
        for(ContaCorrente ct : contaCorrentes) {
            System.out.println(ct.getNumeroAgencia());
            System.out.println(ct.getConta());
        }
    }
}
