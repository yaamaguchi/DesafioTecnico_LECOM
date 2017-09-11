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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="cliente")
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

	public Cliente(){}
	
	public Cliente(String nome){
		this.nome = nome;
		this.listaServicos= new ArrayList<Servicos>();
	}
	
	
	public Long getId() {
		return id;
	}
	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	@XmlElement
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Classificacao getClassificacao() {
		return classificacao;
	}
	@XmlElement
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	public List<Servicos> getListaServicos() {
		return listaServicos;
	}
	@XmlElement
	public void setListaServicos(List<Servicos> listaServicos) {
		this.listaServicos = listaServicos;
	}
}
