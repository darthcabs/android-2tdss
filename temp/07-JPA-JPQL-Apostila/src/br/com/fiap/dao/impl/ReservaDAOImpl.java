package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reserva> buscarPorNumeroDias(int dias) {
		return em.createNativeQuery("SELECT * FROM RESERVA WHERE "
				+ "NUMERO_DIAS = :d",Reserva.class)
				.setParameter("d", dias)
				.getResultList();
	}

}
