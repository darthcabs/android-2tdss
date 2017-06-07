package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_FUNCIONARIO")
@SecondaryTable(name="T_DADO_FUNCIONARIO")
@SequenceGenerator(name="seqFunc",sequenceName="SQ_T_FUNCIONARIO",allocationSize=1)
public class Funcionario {

	@Id
	@Column(name="CD_FUNCIONARIO")
	@GeneratedValue(generator="seqFunc",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_FUNCIONARIO",nullable=false)
	private String nome;
	
	@Column(name="DT_ADMISSAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;
	
	@Column(name="VL_SALARIO",table="T_DADO_FUNCIONARIO")
	private double salario;
	
	@Column(name="NR_CONTA",table="T_DADO_FUNCIONARIO")
	private int numeroConta;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
