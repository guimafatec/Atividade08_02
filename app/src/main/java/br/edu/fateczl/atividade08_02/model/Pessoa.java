package br.edu.fateczl.atividade08_02.model;

public class Pessoa {
    private String nome;
    private String cpf;
    public Pessoa(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
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

    public String getRegiao(String[] regioes) {
        int nonoDigito =  Integer.valueOf(
                String.valueOf(getCpf().charAt(8))
        );
        String regiao = regioes[nonoDigito];
        return regiao;
    }
}
