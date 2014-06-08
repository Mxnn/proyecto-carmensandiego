package fiuba.algo3;

public class Novato implements Rango {
    private int velocidad;

    public Novato() {
        this.velocidad = 900;
    }

    public int calcularTiempoDeViaje(double distancia) {
        return (int) (distancia/this.velocidad);
    }

    public String pedirPista(Edificio edificio) {
        return edificio.getPista(this);
    }
}
