package com.example.logonpf.fipe;

public class Veiculo {

    private int id;
    private String key;
    private String nome;
    private String ano;
    private String preco;

    public Veiculo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Veiculo(int id, String key, String nome, String ano, String preco) {
        this.id = id;
        this.key = key;
        this.nome = nome;
        this.ano = ano;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}