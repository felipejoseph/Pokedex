package br.com.pokedex.model.controller.form;

import javax.validation.constraints.NotEmpty;

import br.com.pokedex.model.Pokemon;
import br.com.pokedex.repository.PokedexRepository;

public class AtualizacaoPokemonform {
	
	@NotEmpty
	private String nomePokemon;
	@NotEmpty
	private String Descricao;
	
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
	public Pokemon atualizacao(Long id, PokedexRepository repository) {
		
		Pokemon pokemon = repository.getById(id);
		
		pokemon.setNomePokemon(this.nomePokemon);
		pokemon.setDescricao(this.Descricao);
		
		return pokemon;
	}

}
