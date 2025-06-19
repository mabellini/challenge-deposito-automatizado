package ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.Exceptions.Obstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface ICommand {
    public void ejecutar(Robot robot) throws Obstaculo;
}
