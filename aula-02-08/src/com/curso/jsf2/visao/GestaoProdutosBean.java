package com.curso.jsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.curso.jsf2.dominio.Produto;

@ManagedBean
//@ApplicationScoped
@SessionScoped
public class GestaoProdutosBean {
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
