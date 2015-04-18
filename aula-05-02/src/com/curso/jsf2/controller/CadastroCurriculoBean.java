package com.curso.jsf2.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CadastroCurriculoBean {
	private String vaga = "A0382D";
	private String cargo = "Programador Java Senior";
	
	public String getVaga() {
		return vaga;
	}
	
	public void setVaga(String vaga) {
		
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
