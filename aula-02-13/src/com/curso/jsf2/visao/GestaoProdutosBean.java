package com.curso.jsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.curso.jsf2.dominio.Produto;

@ManagedBean
//@ApplicationScoped
//@SessionScoped
@ViewScoped
//@RequestScoped
//@NoneScoped
public class GestaoProdutosBean implements Serializable {
	private static final long serialVersionUID = 1963671387848113299L;
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	private Produto produto;
	private Produto produtoSelecionado;
	private String nomePesquisa;

	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.setProdutosFiltrados(new ArrayList<Produto>());
		this.produto = new Produto();
	}
	
	public void pesquisar() {
		System.out.println("Pesquisando...");
	}
	
	public void nomePesquisaAlterado(ValueChangeEvent event) {
		System.out.println("Evento de mudança de valor...");
		System.out.println("Valor atual: " + this.getNomePesquisa());
		System.out.println("Novo valor: " + event.getNewValue());
		
		this.getProdutosFiltrados().clear();
		
		for (Produto produto : this.getProdutos()) {
			if (produto.getNome().toLowerCase().startsWith(event.getNewValue().toString().toLowerCase())) {
				this.produtosFiltrados.add(produto);
			}
		}
	}
	
	public String obeterAjuda() {
		if (this.getProdutos().isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		} else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}
	
	public void verificarInclusao(ActionEvent event) {
		System.out.println("Verificando...");
		if("".equals(this.getProduto().getFabricante())) {
			this.getProduto().setFabricante("Sem Fabricante");
		}
	}
	
	public void incluir() {
		System.out.println("Incluindo...");
		this.getProdutos().add(this.getProduto());
		this.setProduto(new Produto());
	}
	
	public void excluir() {
		this.getProdutos().remove(this.getProdutoSelecionado());
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou bean");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizando bean");
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}
}
