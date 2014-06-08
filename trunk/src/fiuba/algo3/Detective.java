package fiuba.algo3;

public class Detective implements Rango {
    private int velocidad;

    public Detective() {
        this.velocidad = 1100;
    }

    public int calcularTiempoDeViaje(double distancia) {
        return (int) (distancia/this.velocidad);
    }

    public String pedirPista(Edificio edificio) {
        return edificio.getPista(this);
    }
}
