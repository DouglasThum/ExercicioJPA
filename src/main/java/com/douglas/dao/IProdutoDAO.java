package com.douglas.dao;

import java.util.List;

import com.douglas.domain.Produto;

public interface IProdutoDAO {
	
	public Produto cadastrar(Produto produto);
	public List<Produto> buscarTodos();
	public void excluir(Produto produto);
	public Produto buscar(Long id);
}
