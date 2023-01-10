package es.edu.escuelait.bautismospring.service;

import es.edu.escuelait.bautismospring.models.Jugador;

import java.util.List;

public interface IServicioJugadores {
    public List<Jugador> recuperarJugadoresPorEquipo(String nombreEquipo);
}
