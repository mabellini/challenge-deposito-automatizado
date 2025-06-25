package ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class DejarPaquete implements ICommand{
    private int valor;

    public DejarPaquete(int valor) {
        this.valor = valor;
    }

    public void ejecutar(Robot robot) {
        robot.dejarPaquete(valor);
        System.out.println("DejarPaquete");
    }
}
