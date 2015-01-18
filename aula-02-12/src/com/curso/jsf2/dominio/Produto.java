package com.curso.jsf2.dominio;

import java.io.Serializable;

public class Produto implements Serializable { 
	private static final long serialVersionUID = 5213949132319400644L;
	private String nome;
	private String fabricante;
	private String categoria;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
