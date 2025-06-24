package ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class RecogerPaquete implements ICommand{
    private int valor;

    public RecogerPaquete(int valor) {
        this.valor = valor;
    }


    public void ejecutar(Robot robot)  {
        robot.recogerPaquete(valor);
        System.out.println("RecogerPaquete ejecutado");
    }
}
