package com.teste.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="servicos")
public class Servicos implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private Date dataInicio;
	@Column
	private Date dataFim;
	@Column
	private double valor;
	@Column
	private double valorFinal;
	
	public Servicos(){}
	
	public Servicos(String nome, String descricao, Date dataInicio, Date dataFim, Double valor){
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	@XmlElement
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	@XmlElement
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	@XmlElement
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	@XmlElement
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public double getValor() {
		return valor;
	}
	@XmlElement
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public double getValorFinal() {
		return valorFinal;
	}
	@XmlElement
	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
}
