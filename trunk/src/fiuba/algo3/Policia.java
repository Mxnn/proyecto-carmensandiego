package fiuba.algo3;

public class Policia {
	private String nombre;
	private Rango rango;
	private int tiempoDisponible;
	private Ciudad ciudadActual;
	
	public void Policia(String nombre){
		this.nombre = nombre;
	}
	
	public void setTiempoDisponible(int tiempo) {
		this.tiempoDisponible = tiempo;
	}
	
	public void setRango(Novato rango) {
		this.rango = rango;
	}
	
    public void setCiudadActual(Ciudad ciudadSalida) {
		this.ciudadActual = ciudadSalida;
	}
	
    public void viajar(Ciudad ciudadDestino) {
	
	}
}