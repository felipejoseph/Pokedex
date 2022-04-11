package br.com.pokedex.model.controller.form;

import javax.validation.constraints.NotEmpty;

import br.com.pokedex.model.Pokemon;


public class PokemonForm {
	
	
	private int Numero;
	@NotEmpty
	private String nomePokemon;
	@NotEmpty
	private String Descricao;
	@NotEmpty 
	private String UrlImagem;
	@NotEmpty
	private String Tipo;
	
		
	
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
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
	public Pokemon converter() {
		
		return new Pokemon(Numero,nomePokemon, Descricao, UrlImagem, Tipo);
	}

}
