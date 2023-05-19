package Contas;

import TItular.Cliente;

import java.util.Objects;

public class ContaCorrente {
    private static int totalDeContas;
    private int numeroAgencia;
    private String conta;
    private Cliente Titular;
    private double saldo = 0;
    private String senha;
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
    public boolean tranferir(double valor, ContaCorrente origem, ContaCorrente destino) {
        if(Objects.equals(origem.getConta(), destino.getConta())) return false;
        if (saldo >= valor) {
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
    public Cliente getTitular() { return Titular; }
    public String getSenha() {
        return senha;
    }

    //É possível ter mais de um método construtor em uma classe
    public ContaCorrente(int numeroAgencia, String numeroConta, Cliente titular, String senha) {
        this.numeroAgencia = numeroAgencia;
        this.conta = numeroConta;
        Titular = titular;
        this.senha = senha;
        totalDeContas++;
    }
}
