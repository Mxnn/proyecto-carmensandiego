package fiuba.algo3;

public class Investigador implements Rango {
    private int velocidad;

    public Investigador() {
        this.velocidad = 1300;
    }

    public int calcularTiempoDeViaje(double distancia) {
    	int tiempoDeViaje = (int) distancia/this.velocidad;
    	if (tiempoDeViaje < 1) {
    		return 1;
    	}
    	return tiempoDeViaje;
    }

    public String pedirPista(Edificio edificio) {
        return edificio.getPista(this);
    }
}
