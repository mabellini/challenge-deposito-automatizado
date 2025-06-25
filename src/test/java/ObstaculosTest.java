import ar.utnba.ddsi.depoautomatizado.models.entities.helper.Llamador;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.*;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Acciones.*;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


public class ObstaculosTest {

    @Test
    void deberiaLlamarANumeroDeSoporte() {
        Llamador llamador = Mockito.mock(Llamador.class);
        Robot robot = Mockito.mock(Robot.class);

        LlamarMantenimientoStrategy estrategia = new LlamarMantenimientoStrategy(llamador,"1234");

        estrategia.manejarObstaculo(robot);

        Mockito.verify(llamador).LlamarPorAlerta("1234");
    }


    @Test
    void deberiaEjecutarSecuenciaParaEsquivar() {
        Robot robot = Mockito.mock(Robot.class);
        EstrategiaObstaculo estrategia = new EsquivarObstaculoStrategy();

        estrategia.manejarObstaculo(robot);

        Mockito.verify(robot).girar(90);
        Mockito.verify(robot, Mockito.times(2)).girar(-90);
        Mockito.verify(robot, Mockito.times(3)).avanzar(10);

    }

    @Test
    void deberiaLlamarAVolverAlPuntoInicial() {
        Robot robot = Mockito.mock(Robot.class);
        EstrategiaObstaculo estrategia = new VolverInicioStrategy();

        estrategia.manejarObstaculo(robot);

        Mockito.verify(robot).volverAlPuntoInicial();
    }
}
