package fiuba.algo3;

import java.lang.Math;

public class Coordenada {
	private double x;
	private double y;
	
	public Coordenada(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double calcularDistancia(Coordenada otra) {
        double distanciaXCuadrado = Math.pow(otra.x - this.x, 2);
        double distanciaYCuadrado = Math.pow(otra.y - this.y, 2);
		return Math.sqrt(distanciaXCuadrado + distanciaYCuadrado);
	}
}