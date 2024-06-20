package com.douglas.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.douglas.dao.ProdutoDAO;
import com.douglas.dao.IProdutoDAO;
import com.douglas.domain.Produto;

public class ProdutoTest {
	
	private IProdutoDAO produtoDAO;
	
	public ProdutoTest() {
		this.produtoDAO = new ProdutoDAO();
	}
	
	@AfterEach
	public void end() {
		List<Produto> list = produtoDAO.buscarTodos();
		for (Produto p : list) {
			produtoDAO.excluir(p);
		}
	}
	
	@Test
	public void cadastrar() {
		Produto produto = instanciarProduto("A1");
		produtoDAO.cadastrar(produto);
		
		produto = produtoDAO.buscar(produto.getId());	
		assertNotNull(produto.getId());
		
		produtoDAO.excluir(produto);
		produto = produtoDAO.buscar(produto.getId());
		assertNull(produto);
	}
	
	@Test
	public void buscar() {
		Produto produto = instanciarProduto("A1");
		produtoDAO.cadastrar(produto);
		
		produto = produtoDAO.buscar(produto.getId());	
		assertNotNull(produto.getId());
		
		produtoDAO.excluir(produto);
		produto = produtoDAO.buscar(produto.getId());
		assertNull(produto);
	}
	
	@Test
	public void buscarTodos() {
		Produto p1 = instanciarProduto("A1");
		Produto p2 = instanciarProduto("A2");
		
		produtoDAO.cadastrar(p1);
		p1 = produtoDAO.buscar(p1.getId());
		assertNotNull(p1.getId());
		
		produtoDAO.cadastrar(p2);
		p2 = produtoDAO.buscar(p2.getId());
		assertNotNull(p2.getId());
	}
	
	@Test
	public void excluir() {
		
		Produto produto = instanciarProduto("A1");
		produtoDAO.cadastrar(produto);
		
		produto = produtoDAO.buscar(produto.getId());	
		assertNotNull(produto.getId());
		
		produtoDAO.excluir(produto);
		produto = produtoDAO.buscar(produto.getId());	
		assertNull(produto);
	}
	
	private Produto instanciarProduto(String codigo) {
		Produto produto = new Produto();
		produto.setNome("Computador");
		produto.setDescricao("Descrição do produto");
		produto.setValor(5000.0);
		
		return produto;
	}
}
