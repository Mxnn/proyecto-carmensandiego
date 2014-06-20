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
        edificioCultural = new Edificio("Biblioteca");
        edificioEconomia = new Edificio("Mercado");
        edificioTransporte = new Edificio("Aeropuerto");
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

    public void desconectarCiudad(Ciudad ciudad) {
        this.ciudadesConectadas.remove(ciudad);
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
	
	public static Ciudad hidratar(Node elementoCiudad) {
		String nombre=((Element)elementoCiudad).getAttribute("nombre");

		String stringCoordenadaX = ((Element)elementoCiudad).getAttribute("CoordenadaX");
		int coordenadaX=Integer.parseInt(stringCoordenadaX);
		String stringCoordenadaY = ((Element)elementoCiudad).getAttribute("CoordenadaY");
		int coordenadaY=Integer.parseInt(stringCoordenadaY);
		Ciudad ciudad= new Ciudad(nombre,new Coordenada((double)coordenadaX, (double) coordenadaY));
		return ciudad;
		}
		
/*		Esto no sirve pero lo guarde por las dudas es codigo q estaba probando
		int coordenadaX = Integer.parseInt(ciudad.getAttribute("CoordenadaX"));
		int coordenadaY = Integer.parseInt(ciudad.getAttribute("CoordenadaY"));
		Coordenada coordenada=new Coordenada((double)coordenadaX, (double) coordenadaY);
		
		Ciudad nuevoCiudad = new Ciudad(listaDeCiudades.get(posicionDeLaLista), coordenada);

		Pista pistaFE= Pista.hidratar((Element)doc.getElementsByTagName("pistaFE").item(0));
		Pista pistaIE= Pista.hidratar((Element)doc.getElementsByTagName("pistaIE").item(0));
		Pista pistaDE= Pista.hidratar((Element)doc.getElementsByTagName("pistaDE").item(0));
		Pista pistaFT= Pista.hidratar((Element)doc.getElementsByTagName("pistaFT").item(0));
		Pista pistaIT= Pista.hidratar((Element)doc.getElementsByTagName("pistaIT").item(0));
		Pista pistaDT= Pista.hidratar((Element)doc.getElementsByTagName("pistaDT").item(0));
		Pista pistaFC= Pista.hidratar((Element)doc.getElementsByTagName("pistaFC").item(0));
		Pista pistaIC= Pista.hidratar((Element)doc.getElementsByTagName("pistaIC").item(0));
		Pista pistaDC= Pista.hidratar((Element)doc.getElementsByTagName("pistaDC").item(0));
		Ciudad nuevoCiudad = new Ciudad();
		Element elementoEquipo = (Element)doc.getElementsByTagName("Equipo").item(0);
		nuevoEquipo.nombre = elementoEquipo.getAttribute("nombre");
		Element elementoJugadores = (Element)doc.getElementsByTagName("Jugadores").item(0);
		for(int i=0; i< elementoJugadores.getChildNodes().getLength(); i++) {
			Jugador jugador = Jugador.hidratar(elementoJugadores.getChildNodes().item(i));
			nuevoEquipo.agregarJugador(jugador);
		}
		return nuevoEquipo;*/
	
}
