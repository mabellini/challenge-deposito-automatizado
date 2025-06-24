package ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Girar implements ICommand {
    private int grados;

    public Girar(int grados) {
        this.grados = grados;
    }

    public void ejecutar(Robot robot) {
        robot.girar(grados);
        System.out.println("Girar " + grados + " grados");
    }
}
