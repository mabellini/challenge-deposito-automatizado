package ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class DejarPaquete {
    private int valor;

    public DejarPaquete(int valor) {
        this.valor = valor;
    }

    public void DejarPaquete(Robot robot) {
        robot.dejarPaquete(valor);
        System.out.println("DejarPaquete");
    }
}
