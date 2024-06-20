package com.douglas.dao;

import java.util.List;

import com.douglas.domain.Curso;

public interface ICursoDAO {
	
	public Curso cadastrar(Curso curso);
	public List<Curso> buscarTodos();
	public void excluir(Curso curso);
	public Curso buscar(Long id);
}
