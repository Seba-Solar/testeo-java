package com.testview.testeo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pokemon")
public class PokeApiController {
    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon/";

    @GetMapping("/llamarPokemon")
    public String llamarPokemon() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(POKE_API_URL, String.class);
        return response;
    }
    @PostMapping("/nombrePokemon")
    public String nombrePokemon(@RequestParam String pokemon){
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(POKE_API_URL + pokemon, String.class);
        return response;
    }
}
