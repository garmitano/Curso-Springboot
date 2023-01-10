package es.edu.escuelait.bautismospring.service;

import es.edu.escuelait.bautismospring.models.Jugador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("actuales")
public class ServicioJugadores implements IServicioJugadores{

    public List<Jugador> recuperarJugadoresPorEquipo(String nombreEquipo) {

        List<Jugador> jugadores = null;

        if (nombreEquipo.equalsIgnoreCase("argentina")) {
            jugadores = List.of(
                    new Jugador("Messi"),
                    new Jugador("Paredes"),
                    new Jugador("Julian")
            );
        } else if (nombreEquipo.equalsIgnoreCase("espana")) {
            jugadores = List.of(
                    new Jugador("Alba"),
                    new Jugador("Gabi"),
                    new Jugador("Pedri")
            );
        }
        return jugadores;
    }
}
