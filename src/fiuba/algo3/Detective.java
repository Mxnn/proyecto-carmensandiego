package fiuba.algo3;

public class Detective implements Rango {
    private int velocidad;

    public Detective() {
        this.velocidad = 1100;
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
