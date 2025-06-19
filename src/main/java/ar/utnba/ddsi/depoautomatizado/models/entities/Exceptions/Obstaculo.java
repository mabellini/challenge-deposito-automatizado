package ar.utnba.ddsi.depoautomatizado.models.entities.Exceptions;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones.ICommand;

public class Obstaculo extends Exception {
    public Obstaculo() {
        super("Obstaculo")  ;
    }
}
