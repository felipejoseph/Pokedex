package br.com.pokedex.model.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pokedex.model.Pokemon;

public class PokemonDto {
	
	
	private int Numero;
	private String nomePokemon;
	private String Descricao;
	private String UrlImagem;
	private String Tipo;
	
	public PokemonDto(Pokemon pokemon) {
		
		this.Numero = pokemon.getNumero();
		this.nomePokemon = pokemon.getNomePokemon();
		this.Descricao = pokemon.getDescricao();
		this.UrlImagem = pokemon.getUrlImagem();
		this.Tipo = pokemon.getTipo();
		
				
	}
	
	public String getTipo() {
		return Tipo;
	}

	public String getNomePokemon() {
		return nomePokemon;
	}
	public void setNomePokemon(String nomePokemon) {
		this.nomePokemon = nomePokemon;
	}
	public int getNumero() {
		return Numero;
	}
	public String getDescricao() {
		return Descricao;
	}
	public String getUrlImagem() {
		return UrlImagem;
	}


	public static List<PokemonDto> converter(List<Pokemon> pokemons) {
		
		return pokemons.stream().map(PokemonDto::new).collect(Collectors.toList());
	}
	
	
}
