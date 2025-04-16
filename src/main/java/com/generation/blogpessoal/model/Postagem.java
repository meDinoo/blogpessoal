package com.generation.blogpessoal.model;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity //ta falando que uma tabela
@Table( name = "tb_postagens")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // entende que e uma chave primaria e faz o auto incremento
	
	@NotBlank
	@Size(min = 3 , max = 100 )
	private String titulo;//nao pode ser menor que 3 ou maior que 100, e nao pode ser null ou vazio
	
	
	@NotBlank
	@Size(min = 10 , max = 1000 )
	private String texto;
	
	@UpdateTimestamp
	private LocalDate data; //atualiza o tempo sosinho
	
	@ManyToOne
	@JsonIgnoreProperties("postagem") //para nao entrar em loop com a repeticao de dados no retorno
	private Tema tema;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
	
	
}
