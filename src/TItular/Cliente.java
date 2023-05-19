package TItular;

import Contas.ContaCorrente;

import javax.swing.*;

public class Cliente {
    private String nome;
    private String cpf;
    private String profissao;
    private String endereco;
    private String nascimento;
    private Cliente[] clientes;
    private int cls = 0;
    public Cliente(String nome, String cpf, String profissao, String endereco, String nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.profissao = profissao;
        this.endereco = endereco;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}
