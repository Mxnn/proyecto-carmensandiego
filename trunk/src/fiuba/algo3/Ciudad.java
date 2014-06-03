package fiuba.algo3;

public class Ciudad {
	
	private String nombre;
	private Coordenada coordenadas;
	private Pista pistaEconomia;
	private Pista pistaSimbolosPatrios;
	private Pista pistaGeografiaHistoria;
	
	public Ciudad(String nombre, Coordenada coordenadas) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
	}
	
	// SETTERS:
	public void setPistaEconomia(Pista pista) {
		this.pistaEconomia = pista;
	}
	
	public void setPistaSimbolosPatrios(Pista pista) {
		this.pistaSimbolosPatrios = pista;
	}
	
	public void setPistaGeografiaHistoria(Pista pista) {
		this.pistaGeografiaHistoria = pista;
	}
	
	// GETTERS:
	public String getPistaEconomia(Rango rangoPolicia) {
		return this.pistaEconomia.getPista(rangoPolicia);
	}
	
	public String getPistaSimbolosPatrios(Rango rangoPolicia) {
		return this.pistaSimbolosPatrios.getPista(rangoPolicia);
	}
	
	public String getPistaGeografiaHistoria(Rango rangoPolicia) {
		return this.pistaGeografiaHistoria.getPista(rangoPolicia);
	}
	
	public Coordenada getCoordenadas() {
		return this.coordenadas;
	}
}