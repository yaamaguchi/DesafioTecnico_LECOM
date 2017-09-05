package com.teste.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@OneToOne
	private Classificacao classificacao;
	
	@OneToMany
	private List<Servicos>listaServicos;

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Classificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	public List<Servicos> getListaServicos() {
		return listaServicos;
	}
	public void setListaServicos(List<Servicos> listaServicos) {
		this.listaServicos = listaServicos;
	}
}
