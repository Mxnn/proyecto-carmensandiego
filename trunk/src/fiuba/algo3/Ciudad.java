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

    public String getPistaEconomia(Rango rangoPolicia) {
        rangoPolicia.setDificultadPista(this.pistaEconomia);
        return this.pistaEconomia.obtenerPista();
    }

    public String getPistaSimbolosPatrios(Rango rangoPolicia) {
        rangoPolicia.setDificultadPista(this.pistaSimbolosPatrios);
        return this.pistaSimbolosPatrios.obtenerPista();
    }

    public String getPistaGeografiaHistoria(Rango rangoPolicia) {
        rangoPolicia.setDificultadPista(this.pistaGeografiaHistoria);
        return this.pistaGeografiaHistoria.obtenerPista();
    }

	public Coordenada getCoordenadas() {
		return this.coordenadas;
	}
}
