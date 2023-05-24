package TItular;

public class Cliente {
    private final String nome;
    private final String cpf;
    private final String profissao;
    private final String endereco;
    private final String nascimento;
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
    public String getCpf() {
        return cpf;
    }
    public String getProfissao() {
        return profissao;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getNascimento() {
        return nascimento;
    }
}
