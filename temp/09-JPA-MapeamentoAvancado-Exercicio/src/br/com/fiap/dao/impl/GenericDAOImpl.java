package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {		
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
							.getActualTypeArguments()[0];
	}
	
	@Override
	public void insert(T entidade) {
		em.persist(entidade);		
	}

	public void save() throws CommitException {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive()) //valida se existe uma transação ativa
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit");
		}
	}

	@Override
	public void update(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void delete(K id) throws EntityNotFoundException {
		T entidade = findById(id);
		if (entidade == null)
			throw new EntityNotFoundException("Entidade não existe");
		em.remove(entidade);
	}

	@Override
	public T findById(K id) {
		return em.find(clazz, id);
	}
	
}
