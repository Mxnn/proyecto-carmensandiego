package fiuba.algo3;

import java.lang.Math;

public class Coordenada {
	private float x;
	private float y;
	
	public void Coordenada(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float calcularDistancia(Coordenada otra) {
		float distanciaXCuadrado = (float) Math.pow(otra.x - this.x, 2);
		float distanciaYCuadrado = (float) Math.pow(otra.y - this.y, 2);
		return (float) Math.sqrt(distanciaXCuadrado + distanciaYCuadrado);
	}
}