package fiuba.algo3;

import java.util.ArrayList;

public class Ciudad {

	private String nombre;
	private Coordenada coordenadas;
    private Edificio edificioCultural;
    private Edificio edificioEconomia;
    private Edificio edificioTransporte;
    private ArrayList<Ciudad> ciudadesConectadas;
    private Ladron ladronEscondido;

	public Ciudad(String nombre, Coordenada coordenadas) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
        edificioCultural = new Edificio("Biblioteca");
        edificioEconomia = new Edificio("Mercado");
        edificioTransporte = new Edificio("Aeropuerto");
        ciudadesConectadas = new ArrayList<Ciudad>();
        ladronEscondido = null;
	}

	// SETTERS:
	public void setEdificioCultural(Edificio edificio) {
        this.edificioCultural = edificio;
    }

    public void setEdificioEconomia(Edificio edificio) {
        this.edificioEconomia = edificio;
    }

    public void setEdificioTransporte(Edificio edificio) {
        this.edificioTransporte = edificio;
    }

    public void conectarCiudad(Ciudad ciudad) {
        this.ciudadesConectadas.add(ciudad);
    }

    public void desconectarCiudad(Ciudad ciudad) {
        this.ciudadesConectadas.remove(ciudad);
    }

    public void esconderLadron(Ladron ladron) {
        ladronEscondido = ladron;
    }
	
	//GETTERS:
	public Coordenada getCoordenadas() {
		return this.coordenadas;
	}

    public Edificio getEdificioCultural() {
        return this.edificioCultural;
    }

    public Edificio getEdificioEconomia() {
        return this.edificioEconomia;
    }

    public Edificio getEdificioTransporte() {
        return this.edificioTransporte;
    }

    public ArrayList<Ciudad> getCiudadesConectadas() {
        return ciudadesConectadas;
    }

    public boolean ciudadEstaConectada(Ciudad ciudad) {
        return this.ciudadesConectadas.contains(ciudad);
    }

    public boolean ladronEstaEnLaCiudad() {
        return (ladronEscondido != null);
    }

    public Ladron getLadronEscondido() {
        return ladronEscondido;
    }
}
