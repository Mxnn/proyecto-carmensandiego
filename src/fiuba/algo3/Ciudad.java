package fiuba.algo3;
import java.awt.geom.Arc2D.Double;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class Ciudad {

	private String nombre;
	private Coordenada coordenadas;
    private Edificio edificioCultural;
    private Edificio edificioEconomia;
    private Edificio edificioTransporte;
    private ArrayList<Ciudad> ciudadesConectadas;
	private boolean acaEstaElLadron;

	public Ciudad(String nombre, Coordenada coordenadas) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
        edificioCultural = new Edificio();
        edificioEconomia = new Edificio();
        edificioTransporte = new Edificio();
        ciudadesConectadas = new ArrayList<Ciudad>();
		acaEstaElLadron = false;
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
	
    public boolean estaConectadaConEstaCiudad(Ciudad ciudad) {
        return this.ciudadesConectadas.contains(ciudad);
    }

    public int cantidadDeCiudadesConectadas(){
    	return ciudadesConectadas.size();
    }
	
	public void esconderAlLadron() {
		this.acaEstaElLadron = true;
	}

	//GETTERS:
	public Coordenada getCoordenadas() {
		return this.coordenadas;
	}

	public String getNombre() {
		return this.nombre;
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

    public boolean escondeAlLadron() {
        return this.acaEstaElLadron;
    }
}
