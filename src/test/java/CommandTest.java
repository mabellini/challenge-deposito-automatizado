package ar.utnba.ddsi.depoautomatizado.services;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones.*;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



public class CommandTest {

    private Robot robot;

    @BeforeEach
    void setUp() {
        robot = Mockito.mock(Robot.class);
    }

    @Test
    void deberiaEjecutarComandoDesplazarse() {
        Desplazarse cmd = new Desplazarse(5);
        cmd.ejecutar(robot);

        Mockito.verify(robot).avanzar(5);
    }

    @Test
    void deberiaEjecutarComandoGirar() {
        Girar cmd = new Girar(90);
        cmd.ejecutar(robot);

        Mockito.verify(robot).girar(90);
    }

    @Test
    void deberiaEjecutarComandoRecogerPaquete() {
        RecogerPaquete cmd = new RecogerPaquete(10);
        cmd.ejecutar(robot);

        Mockito.verify(robot).recogerPaquete(10);
    }

    @Test
    void deberiaEjecutarComandoDejarPaquete() {
        // DejarPaquete no implementa ICommand, testeo su método específico
        DejarPaquete cmd = new DejarPaquete(10);
        cmd.ejecutar(robot);

        Mockito.verify(robot).dejarPaquete(10);
    }
}
