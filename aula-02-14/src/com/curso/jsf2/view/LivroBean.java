package com.curso.jsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;

import com.curso.jsf2.model.Livro;

@ManagedBean
@ViewScoped
public class LivroBean implements Serializable, ActionListener{
	private List<Livro> livros;
	private Livro livro;
	private Livro livroSelecionado;
	private List<Livro> livrosFiltrados;
	private String tela;

	public LivroBean() {
		this.setLivros(new ArrayList<Livro>());
		this.setLivro(new Livro());
		this.setLivrosFiltrados(new ArrayList<Livro>());
		this.setTela("");
	}
	
	/*
	 * Métodos de Ação
	 */
	
	public void excluir() {
		this.getLivros().remove(this.getLivroSelecionado());
		this.getLivrosFiltrados().remove(this.getLivroSelecionado());
	}
	
	public void incluir() {
		this.getLivros().add(this.getLivro());
		this.getLivrosFiltrados().add(this.getLivro());
		this.setLivro(new Livro());
	}
	
	@Override
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		// TODO Auto-generated method stub
		this.excluir();
	}
	
	public void pesquisarLivro(ValueChangeEvent event) {
		this.getLivrosFiltrados().clear();
		
		for (Livro livro : this.getLivros()) {
			if (livro.getTitulo().toLowerCase().startsWith(event.getNewValue().toString().toLowerCase())) {
				this.getLivrosFiltrados().add(livro);
			}
		}
	}
	
	public String tela() {
		if (this.getTela().equals("")) {
			return "CatalogoLivros?faces-redirect=true";
		}
		
		return "inicial";
	}
	
	/*
	 * Gettes e Settes
	 */
	
	
	public Livro getLivro() {
		return livro;
	}

	public List<Livro> getLivrosFiltrados() {
		return livrosFiltrados;
	}

	public void setLivrosFiltrados(List<Livro> livrosFiltrados) {
		this.livrosFiltrados = livrosFiltrados;
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
	
	public Livro getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroSelecionado(Livro livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}
}