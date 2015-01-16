package com.curso.jsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.curso.jsf2.dominio.Produto;

@ManagedBean
//@ApplicationScoped
//@SessionScoped
//@ViewScoped
//@RequestScoped
@NoneScoped
public class GestaoProdutosBean implements Serializable {
	private List<Produto> produtos;
	private Produto produto;
	
	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		System.out.println(this.produto.getNome());
		System.out.println(this.produto.getFabricante());
		System.out.println(this.produto.getCategoria());
		this.produto = new Produto();
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
}
