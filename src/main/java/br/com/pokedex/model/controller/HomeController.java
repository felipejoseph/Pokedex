package br.com.pokedex.model.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pokedex.model.Pokemon;
import br.com.pokedex.model.controller.dto.PokemonDto;
import br.com.pokedex.model.controller.form.AtualizacaoPokemonform;
import br.com.pokedex.model.controller.form.PokemonForm;
import br.com.pokedex.repository.PokedexRepository;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomeController {
	
	@Autowired
	private PokedexRepository repository;
	
	
	
	@GetMapping
	public List<PokemonDto> listar(String nomePokemon){
		
		if(nomePokemon == null) {
			List<Pokemon> pokemons = repository.findAll();
			return PokemonDto.converter(pokemons);
		}
		
		else {
			List<Pokemon> pokemons = repository.findByNomePokemonContainingIgnoreCase(nomePokemon);
			return PokemonDto.converter(pokemons);
		}
	}
	
	@PostMapping
	public ResponseEntity<PokemonDto> cadastrar(@RequestBody @Valid PokemonForm pokemonform, UriComponentsBuilder uriBuilder) {
		
		Pokemon pokemon = pokemonform.converter();
		
			repository.save(pokemon);
		
			URI uri = uriBuilder.path("/home/{id}").buildAndExpand(pokemon.getId()).toUri();
			return ResponseEntity.created(uri).body(new PokemonDto(pokemon));
	}
	
	@GetMapping("/{id}")
	public PokemonDto detalhar(@PathVariable Long id) {
		Pokemon pokemon = repository.getById(id);
		return new PokemonDto(pokemon);
		
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PokemonDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPokemonform atualizacaopokemonform){
		Pokemon pokemon = atualizacaopokemonform.atualizacao(id, repository);
		
		return ResponseEntity.ok(new PokemonDto(pokemon));  
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}
		
	

}

