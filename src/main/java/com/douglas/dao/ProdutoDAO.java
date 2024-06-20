package com.douglas.dao;

import java.util.List;

import com.douglas.domain.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Produto cadastrar(Produto produto) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(produto);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return produto;
	}
	
	public Produto buscar(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Produto produto = entityManager.find(Produto.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return produto;
	}

	@Override
	public List<Produto> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		List<Produto> list = 
				entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();      
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}

	@Override
	public void excluir(Produto produto) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		produto = entityManager.merge(produto);
		entityManager.remove(produto);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();	
	}
}
