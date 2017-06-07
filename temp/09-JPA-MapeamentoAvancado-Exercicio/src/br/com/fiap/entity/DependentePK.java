package br.com.fiap.entity;

import java.io.Serializable;

/**
 * Classe que possui os atributos que formam a chave composta,
 * deve possuir o mesmo nome dos atributos da entidade 
 */
public class DependentePK implements Serializable {

	private int codigo;
	
	private int funcionario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}
	
}
