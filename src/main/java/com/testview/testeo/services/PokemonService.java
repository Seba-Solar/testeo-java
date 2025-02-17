package com.testview.testeo.services;

import com.testview.testeo.model.PokemonModel;
import com.testview.testeo.repository.PokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class PokemonService {
    //Traigo el model x medio del repository
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Transactional
    public String agregarPokemon(String nombre, ArrayList<String> ataques, String linkImagen, String tipo){
        try {
            PokemonModel pokemon = new PokemonModel();
            pokemon.setAtaques(ataques);
            pokemon.setNombre(nombre);
            pokemon.setLinkImagen(linkImagen);
            pokemon.setTipo(tipo);
            pokemonRepository.save(pokemon);
            return "Pokemon registrado con exito";
        }catch (Exception e){
            return "Error creando un pokemon en la base de datos (Service Error) \n Detalle del error: " + e;
        }
    }
    @Autowired
    private RestTemplate restTemplate;

    public PokemonModel obtenerPokemonPorNombre(String nombre) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + nombre;
        return restTemplate.getForObject(url, PokemonModel.class);
    }
}
