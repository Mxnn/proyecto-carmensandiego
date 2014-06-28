package fiuba.algo3.modelo;

public class Sargento implements Rango{
	private int velocidad;

	public Sargento(){
        this.velocidad = 1500;
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
