package es.edu.escuelait.bautismospring.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class Jugador {
    @NonNull
    private String nombre;
    private int numero;
    private int goles;
}
