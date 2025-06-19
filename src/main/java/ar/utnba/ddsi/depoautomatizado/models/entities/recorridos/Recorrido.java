package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos;

import ar.utnba.ddsi.depoautomatizado.models.entities.Exceptions.Obstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones.ICommand;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.ArrayList;
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
            } catch (Obstaculo obstaculo){ // Otra manera de detectar el obstaculo?
                robot.resolverObstaculo();
            } catch (Exception e) {
                throw new RuntimeException("EXPLOTO TODO");
            }
        }
    }
}