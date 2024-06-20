package com.douglas.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CURSO")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
/*	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
	@SequenceGenerator(name = "curso_seq", sequenceName = "sq_curso", initialValue = 1, allocationSize = 1)*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "DESCRICAO", length = 150, nullable = false)
	private String descricao;
	
	public Curso() {
		
	}

	public Curso(Long id, String codigo, String nome, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
