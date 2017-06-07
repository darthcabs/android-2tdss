package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NAC_AUTOR")
@SequenceGenerator(name="seqAutor",
sequenceName="SQ_T_NAC_AUTOR",allocationSize=1)
public class Autor {

	@Id
	@Column(name="CD_AUTOR")
	@GeneratedValue(generator="seqAutor",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_AUTOR",nullable=false,length=150)
	private String autor;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO")
	private Calendar dataNascimento;
	
	@ManyToMany(mappedBy="autores")
	private List<Livro> livros;
	
	public Autor() {
		super();
	}

	public Autor(String autor, Calendar dataNascimento, List<Livro> livros) {
		super();
		this.autor = autor;
		this.dataNascimento = dataNascimento;
		this.livros = livros;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
}
