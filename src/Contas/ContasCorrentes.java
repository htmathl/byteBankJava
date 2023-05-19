package Contas;

import java.util.ArrayList;

public class ContasCorrentes {
    private static ArrayList<ContaCorrente> contaCorrentes = new ArrayList<>();
    public ContasCorrentes(ContaCorrente contaCorrente) {
        contaCorrentes.add(contaCorrente);
    }
    public void showContas() {
        for(ContaCorrente ct : contaCorrentes) {
            System.out.println(ct.getConta());
        }
    }
}
