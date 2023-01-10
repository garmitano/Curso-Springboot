package es.edu.escuelait.bautismospring.service;

import es.edu.escuelait.bautismospring.models.Jugador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("90")
public class ServicioJugadores90 implements IServicioJugadores {

    public List<Jugador> recuperarJugadoresPorEquipo(String nombreEquipo) {

        List<Jugador> jugadores = null;

        if (nombreEquipo.equalsIgnoreCase("argentina")) {
            jugadores = List.of(
                    new Jugador("Maradona"),
                    new Jugador("Cannigia"),
                    new Jugador("Rugeri")
            );
        } else if (nombreEquipo.equalsIgnoreCase("espana")) {
            jugadores = List.of(
                    new Jugador("Luis Enrique"),
                    new Jugador("Butragueno"),
                    new Jugador("El mejor")
            );
        }
        return jugadores;
    }
}