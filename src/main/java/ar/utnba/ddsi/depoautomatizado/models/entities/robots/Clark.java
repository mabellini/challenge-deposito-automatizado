package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;



public class Clark extends Robot {
    private Long id;
    private boolean disponible;
    private EstrategiaObstaculo estrategiaObstaculo;
    private int direccion = Direccion.NORTE; // para simplificar la rotacion - 0 Norte, 1 este, 2 sur, 3 oeste

    private Posicion puntoInicial;
    private Posicion puntoActual;


    public Clark(Long id) {
        super(id);
    }

    public void girar(int grados) {
        int pasos = grados / 90;
        direccion = (direccion + pasos) % 4;
        if (direccion < 0) direccion += 4;
        System.out.println("Robot giró. Nueva dirección: " + direccion);
    }

    public void avanzar(int valor) {

        while(valor > 0){
            if(!avanzarUnidad()){
                this.resolverObstaculo();
                continue;
            }
            valor--;
        }

        System.out.println("Robot avanzó " + valor + " hacia " + direccion);
    }

    private boolean avanzarUnidad(){

        if(this.detectarObstaculo()) return false;

        Posicion posicion = getPuntoActual();
        // Usamos switch expression para calcular nuevos valores
        int nuevoX = posicion.getX();
        int nuevoY = posicion.getY();

        switch (direccion) {
            case Direccion.NORTE -> nuevoY += 1;
            case Direccion.ESTE -> nuevoX += 1;
            case Direccion.SUR -> nuevoY -= 1;
            case Direccion.OESTE -> nuevoX -= 1;
        }

        posicion.setX(nuevoX);
        posicion.setY(nuevoY);

        return true;
    }

    public void recogerPaquete(int valor){
        System.out.println("Paquete recogido");
    }

    public void dejarPaquete(int valor){
        System.out.println("Paquete ejado");
    }

    public void volverAlPuntoInicial(){
        while (!puntoActual.equals(puntoInicial)) {
            int dx = puntoInicial.getX() - puntoActual.getX();
            int dy = puntoInicial.getY() - puntoActual.getY();

            int dirObjetivo = Direccion.NORTE;

            // Decidir dirección horizontal o vertical para moverse
            if (dx != 0) {
                dirObjetivo = dx > 0 ? Direccion.ESTE : Direccion.OESTE;
            } else if (dy != 0) {
                dirObjetivo = dy > 0 ? Direccion.NORTE : Direccion.SUR;
            } else {
                break; // Ya llegó al punto inicial
            }

            girarHacia(dirObjetivo);
            avanzar(1); // Avanza un paso en la dirección actual

            // Se asume que avanzar(1) actualiza puntoActual internamente
        }
        System.out.println("Robot volvió al punto inicial.");
    }

    private void girarHacia(int dirObjetivo) {
        int diff = dirObjetivo - this.direccion;

        // Normalizar para girar la menor cantidad de veces
        if (diff == 3) diff = -1;
        if (diff == -3) diff = 1;

        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                girar(90); // Gira 90 grados a la derecha
            }
        } else if (diff < 0) {
            for (int i = 0; i < -diff; i++) {
                girar(-90); // Gira 90 grados a la izquierda
            }
        }
    }

} 