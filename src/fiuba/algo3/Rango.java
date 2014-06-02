package fiuba.algo3;

public class Rango {
	protected int velocidad;
	
	public float calcularTiempoDeViaje(float distancia) {
		return distancia/this.velocidad;
	}
}