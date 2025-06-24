package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones.ICommand;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.List;

public class Recorrido {
    private final List<ICommand> ordenes;

    public Recorrido(List<ICommand> ordenes) {
        this.ordenes = ordenes;
    }

    public void ejecutarRecorrido(Robot robot) {
        for (ICommand orden : ordenes) {
            try{
                orden.ejecutar(robot);
            } catch (Exception e) {
                throw new RuntimeException("EXPLOTO TODO");
            }
        }
    }
}