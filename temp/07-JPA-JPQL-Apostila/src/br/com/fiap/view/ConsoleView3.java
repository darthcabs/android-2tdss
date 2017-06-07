package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Reserva;

public class ConsoleView3 {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ReservaDAO dao = new ReservaDAOImpl(em);
		
		List<Reserva> lista = dao.buscarPorNumeroDias(10);
		
		for (Reserva reserva : lista) {
			System.out.println(reserva.getCliente().getNome() + " " 
					+ reserva.getNumeroDias());
		}
		
		em.close();
		System.exit(0);
	}
	
}
