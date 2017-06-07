package br.com.fiap.dao;

import java.util.Collection;
import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	Cliente buscarPorCpf(String cpf);
	
	List<Cliente> buscarPorMesAniversario(int mes);
	
	long buscarQuantidade();
	
	List<Cliente> buscarPorEstado(String estado);
	
	List<Cliente> buscarPorDiaReserva(int numero);
	
	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(Collection<String> estados);
	
}



