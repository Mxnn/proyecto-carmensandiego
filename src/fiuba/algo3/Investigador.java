package fiuba.algo3;

public class Investigador implements Rango {
    private int velocidad;

    public Investigador() {
        this.velocidad = 1300;
    }

    public int calcularTiempoDeViaje(double distancia) {
        return (int) (distancia/this.velocidad);
    }
}