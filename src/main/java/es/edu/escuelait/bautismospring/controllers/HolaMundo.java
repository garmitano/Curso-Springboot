package es.edu.escuelait.bautismospring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
    @GetMapping("/saludo/{usuario}")
    public String saludo(@PathVariable String usuario){

        return "Hola Mundo SpringBoot" + usuario;
    }

    @GetMapping("/sumar/{numA}/{numB}")

    public int sumar(@PathVariable int numA, @PathVariable int numB){
        return numA+numB;
    }
}
