package ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Desplazarse implements ICommand {
    private int distancia; // asumo valores redondos x el ejemplo

    public Desplazarse(int distancia) {
        this.distancia = distancia;
    }

    public void ejecutar(Robot robot) {
        robot.avanzar(distancia);
        System.out.println("Avanza " + distancia);
    }
}
