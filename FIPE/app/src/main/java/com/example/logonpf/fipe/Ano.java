package com.example.logonpf.fipe;

public class Ano {
    private int idMarca;
    private int idVeiculo;
    private int id;
    private String preco;
    private String codFipe;

    public Ano() { }
    public Ano(int id, String preco) { }
    public Ano(int idMarca, int idVeiculo){
        this.idMarca = idMarca;
        this.idVeiculo = idVeiculo;
    }

    @Override
    public String toString() {return String.valueOf(id);}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getCodFipe() {return codFipe;}

    public void setCodFipe(String codFipe) {this.codFipe = codFipe;}

    public String getPreco() {return preco;}

    public void setPreco(String preco) {this.preco = preco;}

    public int getIdMarca() {return idMarca;}

    public void setIdMarca(int idMarca) {this.idMarca = idMarca;}

    public int getIdVeiculo() {return idVeiculo;}

    public void setIdVeiculo(int idVeiculo) {this.idVeiculo = idVeiculo;}
}