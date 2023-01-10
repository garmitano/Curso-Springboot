package es.edu.escuelait.bautismospring.models;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.Table;

@Data
@Table(name="Equipos")
public class Equipo {
    @NonNull
    private String nombrePais;
    @NonNull
    private String conf;
    private int rankingFifa;
}
