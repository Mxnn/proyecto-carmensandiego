package fiuba.algo3;

public class Ciudad {

	private String nombre;
	private Coordenada coordenadas;
    private Edificio edificioBiblioteca;
    private Edificio edificioEconomia;
    private Edificio edificioSalida;

	public Ciudad(String nombre, Coordenada coordenadas) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
        edificioBiblioteca = new Biblioteca();
        edificioEconomia = new Banco();
        edificioSalida = new Aeropuerto();
	}

	// SETTERS:
	public void setEdificioBiblioteca(Edificio edificio) {
        this.edificioBiblioteca = edificio;
    }

    public void setEdificioEconomia(Edificio edificio) {
        this.edificioEconomia = edificio;
    }

    public void setEdificioSalida(Edificio edificio) {
        this.edificioSalida = edificio;
    }
	
	//GETTERS:
	public Coordenada getCoordenadas() {
		return this.coordenadas;
	}
}
