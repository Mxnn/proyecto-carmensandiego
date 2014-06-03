package fiuba.algo3;

import java.lang.Math;

//final double radioTierra = 6371;


public class Coordenada {
	private double latitud;
	private double longitud;
	
	public Coordenada(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public double calcularDistancia(Coordenada otra) {
        double difLatitud = Math.toRadians(otra.latitud - this.latitud);
		double difLongitud = Math.toRadians(otra.longitud - this.longitud);
		
		double sinDifLatitud = Math.sin(difLatitud/2);
		double sinDifLongitud = Math.sin(difLongitud/2);
		
		double aux = Math.pow(sinDifLatitud, 2) + Math.pow(sinDifLongitud, 2) * Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(otra.latitud));
		double aux1 = 2 * Math.atan2(Math.sqrt(aux), Math.sqrt(1 - aux));
		
		return 6371.00 * aux1;
	}
}