package com.example.logonpf.fipe;

public class Veiculo {

    private int id;
    private int marca;
    private String key;
    private String nome;

    public Veiculo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Veiculo(int id, String key, String nome) {
        this.id = id;
        this.key = key;
        this.nome = nome;
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

    public int getMarca() {return marca;}

    public void setMarca(int marca) {this.marca = marca;}
}