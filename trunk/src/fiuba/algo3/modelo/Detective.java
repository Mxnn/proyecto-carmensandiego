package fiuba.algo3.modelo;

public class Detective implements Rango {
	public final static int CASOS_NECESARIOS_ASCENSO = 10;
	
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
	
	public Investigador determinarRangoSiguiente(int cantidadDeCasos) {
		if (cantidadDeCasos == CASOS_NECESARIOS_ASCENSO) {
			return new Investigador();
		}
		return null;
	}
}
