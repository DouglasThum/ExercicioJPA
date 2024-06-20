package com.douglas.dao;

import java.util.List;

import com.douglas.domain.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MatriculaDAO implements IMatriculaDAO {

	@Override
	public Matricula cadastrar(Matricula matricula) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(matricula);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return matricula;
	}
	
	public Matricula buscar(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Matricula matricula = entityManager.find(Matricula.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return matricula;
	}

	@Override
	public List<Matricula> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		List<Matricula> list = 
				entityManager.createQuery("SELECT m FROM Matricula m", Matricula.class).getResultList();      
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}

	@Override
	public void excluir(Matricula matricula) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		matricula = entityManager.merge(matricula);
		entityManager.remove(matricula);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();	
	}
}
