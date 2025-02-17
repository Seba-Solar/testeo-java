package com.testview.testeo.controller;

import com.testview.testeo.model.PokemonModel;
import com.testview.testeo.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class PokeApiController {
    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon/";
    @Autowired
    private PokemonService pokemonService;
    @GetMapping("/llamarPokemon")
    public String llamarPokemon() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(POKE_API_URL, String.class);
        return response;
    }
    @GetMapping("/nombrePokemon")
    public String obtenerPokemon(@RequestParam("nombre") String nombre, Model model){
        PokemonModel pokemon = pokemonService.obtenerPokemonPorNombre(nombre);
        model.addAttribute("habilidades", pokemon.getAtaques());
        model.addAttribute("nombre", pokemon.getNombre());
        model.addAttribute("tipo", pokemon.getTipo());
        model.addAttribute("linkImagen", pokemon.getLinkImagen());
        return "detallePokemon";
    }
}
