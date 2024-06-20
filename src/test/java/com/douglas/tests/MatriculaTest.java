package com.douglas.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.douglas.dao.MatriculaDAO;
import com.douglas.dao.IMatriculaDAO;
import com.douglas.domain.Matricula;

public class MatriculaTest {
	
	private IMatriculaDAO matriculaDAO;
	
	public MatriculaTest() {
		this.matriculaDAO = new MatriculaDAO();
	}
	
	@AfterEach
	public void end() {
		List<Matricula> list = matriculaDAO.buscarTodos();
		for (Matricula m : list) {
			matriculaDAO.excluir(m);
		}
	}
	
	@Test
	public void cadastrar() {
		Matricula matricula = instanciarMatricula("A1");
		matriculaDAO.cadastrar(matricula);
		
		matricula = matriculaDAO.buscar(matricula.getId());	
		assertNotNull(matricula.getId());
		
		matriculaDAO.excluir(matricula);
		matricula = matriculaDAO.buscar(matricula.getId());
		assertNull(matricula);
	}
	
	@Test
	public void buscar() {
		Matricula matricula = instanciarMatricula("A1");
		matriculaDAO.cadastrar(matricula);
		
		matricula = matriculaDAO.buscar(matricula.getId());	
		assertNotNull(matricula.getId());
		
		matriculaDAO.excluir(matricula);
		matricula = matriculaDAO.buscar(matricula.getId());
		assertNull(matricula);
	}
	
	@Test
	public void buscarTodos() {
		Matricula m1 = instanciarMatricula("A1");
		Matricula m2 = instanciarMatricula("A2");
		
		matriculaDAO.cadastrar(m1);
		m1 = matriculaDAO.buscar(m1.getId());
		assertNotNull(m1.getId());
		
		matriculaDAO.cadastrar(m2);
		m2 = matriculaDAO.buscar(m2.getId());
		assertNotNull(m2.getId());
	}
	
	@Test
	public void excluir() {
		
		Matricula matricula = instanciarMatricula("A1");
		matriculaDAO.cadastrar(matricula);
		
		matricula = matriculaDAO.buscar(matricula.getId());	
		assertNotNull(matricula.getId());
		
		matriculaDAO.excluir(matricula);
		matricula = matriculaDAO.buscar(matricula.getId());	
		assertNull(matricula);
	}
	
	private Matricula instanciarMatricula(String codigo) {
		Matricula matricula = new Matricula();
		matricula.setCodigo(codigo);
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("Ativa");
		matricula.setValor(5000.0);
		
		return matricula;
	}
}
