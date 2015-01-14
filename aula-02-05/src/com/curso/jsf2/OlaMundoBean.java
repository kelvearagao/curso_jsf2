package com.curso.jsf2;

import javax.faces.bean.ManagedBean;

public class OlaMundoBean {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void enviar() {
		this.setNome(this.getNome().toUpperCase());
	}
}
