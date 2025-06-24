package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


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
    private int direccion = Direccion.NORTE; // para simplificar la rotacion - 0 Norte, 1 este, 2 sur, 3 oeste

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

    public boolean detectarObstaculo(){
        return false; // Cada robot tiene la suya.
    }

    public abstract void volverAlPuntoInicial();
} 