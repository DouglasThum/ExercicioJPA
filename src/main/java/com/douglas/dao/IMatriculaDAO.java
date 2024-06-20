package com.douglas.dao;

import java.util.List;

import com.douglas.domain.Matricula;

public interface IMatriculaDAO {
	
	public Matricula cadastrar(Matricula matricula);
	public List<Matricula> buscarTodos();
	public void excluir(Matricula matricula);
	public Matricula buscar(Long id);
}
