package fiuba.algo3.modelo;

public class Novato implements Rango {
    public final static int CASOS_NECESARIOS_ASCENSO = 5;
	
	private int velocidad;

    public Novato() {
        this.velocidad = 900;
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
	
	public Detective determinarRangoSiguiente(int cantidadDeCasos) {
		if (cantidadDeCasos == CASOS_NECESARIOS_ASCENSO) {
			return new Detective();
		}
		return null;
	}
}
