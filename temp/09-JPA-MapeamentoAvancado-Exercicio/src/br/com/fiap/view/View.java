package br.com.fiap.view;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DependenteDAO;
import br.com.fiap.dao.impl.DependenteDAOImpl;
import br.com.fiap.entity.Dependente;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Cadastrar um dependente e um funcionario
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		DependenteDAO dao = new DependenteDAOImpl(em);
		
		Funcionario func = new Funcionario();
		func.setNome("Age");
		func.setDataAdmissao(new GregorianCalendar(2013, 1, 2));
		func.setSalario(20000);
		func.setNumeroConta(1231);
		
		Dependente dep = new Dependente();
		dep.setNome("Lorena");
		dep.setFuncionario(func);
		
		try {
			dao.insert(dep);
			dao.save();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		System.exit(0);
	}
	
}