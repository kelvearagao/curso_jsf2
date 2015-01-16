package com.curso.jsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.curso.jsf2.model.Livro;

@ManagedBean
@ViewScoped
public class LivroBean implements Serializable{
	private List<Livro> livros;
	private Livro livro;
	
	
	public LivroBean() {
		this.setLivros(new ArrayList<Livro>());
		this.setLivro(new Livro());
	}
	
	public void incluir() {
		this.getLivros().add(this.getLivro());
		this.setLivro(new Livro());
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}