package es.edu.escuelait.bautismospring.controllers;

import es.edu.escuelait.bautismospring.models.Equipo;
import es.edu.escuelait.bautismospring.service.IServicioJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoControlador {
    @Autowired
    @Qualifier("actuales")
    private IServicioJugadores servicioJugadores;
    ArrayList<Equipo> equipos = new ArrayList<>(
            List.of(
                    new Equipo("Argentina", "Conmebol"),
                    new Equipo("Espana", "UEFA"),
                    new Equipo("Croacia", "UEFA"),
                    new Equipo("Marruecos", "CAF"),
                    new Equipo("Uruguay", "Conmebol")
        )
    );
    @GetMapping
    public List<Equipo> listarTodos(){
        return equipos;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Equipo> recuperarEquipoPorNombre(@PathVariable String nombre){

        for(Equipo equipo : equipos){
            if (equipo.getNombrePais().equalsIgnoreCase(nombre)){
                return ResponseEntity.ok(equipo);
            }
        }

        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity crearEquipo(@RequestBody Equipo equipo){

        equipos.add(equipo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{nombre}")
                .buildAndExpand(equipo.getNombrePais())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity eliminarEquipoPorNombre(@PathVariable String nombre){

        for(Equipo equipo : equipos){
            if (equipo.getNombrePais().equalsIgnoreCase(nombre)){
                equipos.remove(equipo);
            }else{
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/{nombre}")
    public ResponseEntity<Equipo> modificarEquipo (@RequestBody Equipo equipoModif){
        for(Equipo equipo : equipos){
            if (equipo.getNombrePais().equalsIgnoreCase(equipoModif.getNombrePais())){
                equipo.setConf(equipoModif.getConf());
                equipo.setRankingFifa(equipoModif.getRankingFifa());
                return ResponseEntity.ok(equipo);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{nombreEquipo}/jugadores")
    public ResponseEntity<?> listarJugadoresPorEquipo(@PathVariable String nombreEquipo){



        List jugadores = servicioJugadores.recuperarJugadoresPorEquipo(nombreEquipo);

        return ResponseEntity.ok(jugadores);
    }

}
