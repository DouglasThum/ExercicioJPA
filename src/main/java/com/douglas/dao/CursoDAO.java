package com.douglas.dao;

import java.util.List;

import com.douglas.domain.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursoDAO implements ICursoDAO {

	@Override
	public Curso cadastrar(Curso curso) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(curso);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return curso;
	}
	
	public Curso buscar(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Curso curso = entityManager.find(Curso.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return curso;
	}

	@Override
	public List<Curso> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		List<Curso> list = 
				entityManager.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();      
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}

	@Override
	public void excluir(Curso curso) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		curso = entityManager.merge(curso);
		entityManager.remove(curso);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();	
	}
}
