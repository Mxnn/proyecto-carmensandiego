package fiuba.algo3;

public class Sargento implements Rango{

	private int velocidad;

	public Sargento(){
        this.velocidad = 1500;
	}
    public int calcularTiempoDeViaje(double distancia) {
    	int tiempoDeViaje=(int) distancia/this.velocidad;
    	if (tiempoDeViaje>0){
    		return tiempoDeViaje;
    	}
    	return 1;
    }

    public String pedirPista(Edificio edificio) {
        return edificio.getPista(this);
    }
}
