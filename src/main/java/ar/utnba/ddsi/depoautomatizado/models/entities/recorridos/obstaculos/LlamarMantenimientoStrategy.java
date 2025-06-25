package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.helper.Llamador;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;


public class LlamarMantenimientoStrategy implements EstrategiaObstaculo {
    private Llamador llamador;
    private String numeroSoporte;

    public LlamarMantenimientoStrategy(Llamador llamador, String numeroSoporte) {
        this.llamador = llamador;
        this.numeroSoporte = numeroSoporte;
    }

    @Override
    public void manejarObstaculo(Robot robot) {
        llamador.LlamarPorAlerta(numeroSoporte);
    }
} 