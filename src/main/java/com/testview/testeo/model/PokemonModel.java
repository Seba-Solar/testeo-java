package com.testview.testeo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Pokemon")
public class PokemonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nombre;
    private String linkImagen;
    private String tipo;
    //El elementcollection se usa para decir que es una coleccion de elementos basicos, sin eso,
    //Me arroja el error de 'Basic' attribute type should not be a container, no identifica que es mas de un atributo
    //Collection table es que es una tabla dependiente a la otra
    //Column es el nombre de la columna dentro de la atbla pokemon_ataques
    @ElementCollection
    @CollectionTable(name = "pokemon_ataques", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Column(name = "ataque")
    private List<String> ataques;

    public List<String> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<String> ataques) {
        this.ataques = ataques;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
