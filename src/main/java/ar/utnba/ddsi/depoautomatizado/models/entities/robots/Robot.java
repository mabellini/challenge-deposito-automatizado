package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.Exceptions.Obstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    private boolean disponible;
    private EstrategiaObstaculo estrategiaObstaculo;

    private Posicion puntoInicial;
    private Posicion puntoActual;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
    }


    public abstract void avanzar(int valor);

    public abstract void girar(int valor);

    public abstract void recogerPaquete(int valor);

    public abstract void dejarPaquete(int valor);

    public void resolverObstaculo(){
        estrategiaObstaculo.manejarObstaculo(this);
    }
} 