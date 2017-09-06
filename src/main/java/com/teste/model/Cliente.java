package com.teste.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	@OneToOne (cascade=CascadeType.ALL)
	private Classificacao classificacao;
	
	@ManyToMany (fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	private List<Servicos>listaServicos;

	
	public Cliente(String nome){
		this.nome = nome;
		this.listaServicos= new ArrayList<Servicos>();
	}
	
	
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
