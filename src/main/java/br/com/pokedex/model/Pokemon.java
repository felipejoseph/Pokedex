package br.com.pokedex.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int Numero;
	private String nomePokemon;
	private String Descricao;
	private String UrlImagem;
	private String Tipo;

	
	public Pokemon(int numero, String nomePokemon, String descricao, String urlImagem, String Tipo) {
		this.Numero = numero;
		this.nomePokemon = nomePokemon;
		this.Descricao = descricao;	
		this.UrlImagem = urlImagem;	
		this.Tipo = Tipo;
	}

	
	
	public String getTipo() {
		return Tipo;
	}


	public void setTipo(String tipo) {
		Tipo = tipo;
	}


	public Pokemon() {
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
		
	public String getNomePokemon() {
		return nomePokemon;
	}
	public void setNomePokemon(String nomePokemon) {
		this.nomePokemon = nomePokemon;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public String getUrlImagem() {
		return UrlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		UrlImagem = urlImagem;
	}
	

}
