package fiuba.algo3.modelo;

public class Investigador implements Rango {
	public final static int CASOS_NECESARIOS_ASCENSO = 20;
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
	
	public Sargento determinarRangoSiguiente(int cantidadDeCasos) {
		if (cantidadDeCasos == CASOS_NECESARIOS_ASCENSO) {
			return new Sargento();
		}
		return null;
	}
}
