import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones.*;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class RecorridoTest {

    private Robot robot;

    @BeforeEach
    void setUp() {
        robot = Mockito.mock(Robot.class);
    }

    @Test
    void deberiaEjecutarTodasLasOrdenesEnSecuencia() {
        List<ICommand> comandos = List.of(
                new Desplazarse(5),
                new Girar(90),
                new RecogerPaquete(10),
                new DejarPaquete(10)
        );

        Recorrido recorrido = new Recorrido(comandos);
        recorrido.ejecutarRecorrido(robot);

        Mockito.verify(robot).avanzar(5);
        Mockito.verify(robot).girar(90);
        Mockito.verify(robot).recogerPaquete(10);
        Mockito.verify(robot).dejarPaquete(10);
    }

    @Test
    void deberiaLanzarRuntimeSiUnaOrdenFalla() {
        ICommand comandoFalla = Mockito.mock(ICommand.class);
        Mockito.doThrow(new RuntimeException("Falló")).when(comandoFalla).ejecutar(robot);

        Recorrido recorrido = new Recorrido(List.of(comandoFalla));

        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            recorrido.ejecutarRecorrido(robot);
        });
    }
}