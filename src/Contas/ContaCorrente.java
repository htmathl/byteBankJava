package Contas;

import TItular.Cliente;

public class ContaCorrente {
    private static int totalDeContas;
    private int numeroAgencia;
    private String conta;
    private Cliente Titular;
    private double saldo = 0;

    private void depositar(double valor) {
            saldo += valor;
    }
    private boolean sacar(double valor) {
        if(saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    public boolean tranferir(double valor, ContaCorrente destino) {
        if (saldo >= valor)
        {
            sacar(valor);
            destino.depositar(valor);
            return true;
        }
        return false;
    }
    public void mostrar() {
        //Console.WriteLine(Titular);
        //Console.WriteLine(numeroAgencia);
        //Console.WriteLine(Conta);
        //Console.WriteLine(saldo);
    }
    public void setSaldo(double valor) {
        if (valor < 0) return;
        saldo = valor;
    }
    public double getSaldo() {
        return saldo;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getConta() {
        return conta;
    }

    //É possível ter mais de um método construtor em uma classe
    public ContaCorrente(int numeroAgencia, String numeroConta, Cliente titular) {
        this.numeroAgencia = numeroAgencia;
        this.conta = numeroConta;
        Titular = titular;
        totalDeContas++;
    }
}
