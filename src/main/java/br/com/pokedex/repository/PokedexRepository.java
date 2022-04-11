package br.com.pokedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pokedex.model.Pokemon;

@Repository
public interface PokedexRepository extends JpaRepository<Pokemon, Long>{

	List<Pokemon> findByNomePokemonContainingIgnoreCase(String nomePokemon);

	
	

}
