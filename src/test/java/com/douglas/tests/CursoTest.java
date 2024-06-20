package com.douglas.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.douglas.dao.CursoDAO;
import com.douglas.dao.ICursoDAO;
import com.douglas.domain.Curso;

public class CursoTest {
	
	private ICursoDAO cursoDAO;
	
	public CursoTest() {
		this.cursoDAO = new CursoDAO();
	}
	
	@AfterEach
	public void end() {
		List<Curso> list = cursoDAO.buscarTodos();
		for (Curso c : list) {
			cursoDAO.excluir(c);
		}
	}
	
	@Test
	public void cadastrar() {
		Curso curso = instanciarCurso("A1");
		cursoDAO.cadastrar(curso);
		
		curso = cursoDAO.buscar(curso.getId());	
		assertNotNull(curso.getId());
		
		cursoDAO.excluir(curso);
		curso = cursoDAO.buscar(curso.getId());
		assertNull(curso);
	}
	
	@Test
	public void buscar() {
		Curso curso = instanciarCurso("A1");
		cursoDAO.cadastrar(curso);
		
		curso = cursoDAO.buscar(curso.getId());	
		assertNotNull(curso.getId());
		
		cursoDAO.excluir(curso);
		curso = cursoDAO.buscar(curso.getId());
		assertNull(curso);
	}
	
	@Test
	public void buscarTodos() {
		Curso c1 = instanciarCurso("A1");
		Curso c2 = instanciarCurso("A2");
		
		cursoDAO.cadastrar(c1);
		c1 = cursoDAO.buscar(c1.getId());
		assertNotNull(c1.getId());
		
		cursoDAO.cadastrar(c2);
		c2 = cursoDAO.buscar(c2.getId());
		assertNotNull(c2.getId());
	}
	
	@Test
	public void excluir() {
		
		Curso curso = instanciarCurso("A1");
		cursoDAO.cadastrar(curso);
		
		curso = cursoDAO.buscar(curso.getId());	
		assertNotNull(curso.getId());
		
		cursoDAO.excluir(curso);
		curso = cursoDAO.buscar(curso.getId());	
		assertNull(curso);
	}
	
	private Curso instanciarCurso(String codigo) {
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		curso.setDescricao("Teste de curso");
		curso.setNome("Curso Java");
		
		return curso;
	}
}
