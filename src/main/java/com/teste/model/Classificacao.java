package com.teste.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Classificacao implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String descricao;
	@Column
	private double valor;
	
	public Classificacao(String descricao, double valor){
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
