package fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ciudad {
	public final static String MENSAJE_ENCUENTRA_LADRON = "";
	public final static String MENSAJE_RECIBE_HERIDA = "Ciudado! Te han herido!";

	private String nombre;
	private Coordenada coordenadas;
    private Edificio edificioCultural;
    private Edificio edificioEconomia;
    private Edificio edificioTransporte;
    private ArrayList<Ciudad> ciudadesConectadas;
	private boolean estaElLadron;
	private boolean acaHierenAlPolicia;

	public Ciudad(String nombre, Coordenada coordenadas) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
        edificioCultural = new Edificio();
        edificioEconomia = new Edificio();
        edificioTransporte = new Edificio();
        ciudadesConectadas = new ArrayList<Ciudad>();
		this.estaElLadron = false;
		this.acaHierenAlPolicia = false;
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

	public boolean conectarCiudad(Ciudad ciudad) {
        if ( (ciudad != this) && (!estaConectadaConEstaCiudad(ciudad)) ) {
			this.ciudadesConectadas.add(ciudad);
			ciudad.ciudadesConectadas.add(this);
        	return true;
        }
        return false;
    }
	
	public void esconderAlLadron() {
		this.estaElLadron = true;
	}
	
	public void setHierenAlPolicia() {
		this.acaHierenAlPolicia = true;
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
        return this.ciudadesConectadas;
    }
	
	public boolean estaConectadaConEstaCiudad(Ciudad ciudad) {
        return this.ciudadesConectadas.contains(ciudad);
    }

    public int cantidadDeCiudadesConectadas() {
    	return ciudadesConectadas.size();
    }

	//LOGICA: 
    public String recibirVisitaEdificioCultural(Policia policia) throws ExcepcionTiempoAgotado {
		return recibirVisitaEdificio(policia, this.edificioCultural);
	}
	
	public String recibirVisitaEdificioEconomia(Policia policia) throws ExcepcionTiempoAgotado {
		return recibirVisitaEdificio(policia, this.edificioEconomia);
	}
	
	public String recibirVisitaEdificioTransporte(Policia policia) throws ExcepcionTiempoAgotado {
		return recibirVisitaEdificio(policia, this.edificioTransporte);
	}
	
	public void resetear() {
		this.edificioCultural = new Edificio();
		this.edificioEconomia = new Edificio();
		this.edificioTransporte = new Edificio();
		this.ciudadesConectadas = new ArrayList<Ciudad>();
		this.estaElLadron = false;
		this.acaHierenAlPolicia = false;
	}

	//PRIVADOS:
	private String recibirVisitaEdificio(Policia policia, Edificio edificio) throws ExcepcionTiempoAgotado {
		if (this.estaElLadron && enEsteEdificioArrestaAlLadron(policia, edificio)) {
			return MENSAJE_ENCUENTRA_LADRON;
		} else if (enEsteEdificioHierenAlPolicia(policia, edificio)) {
			policia.recibirHerida();
			return MENSAJE_RECIBE_HERIDA;
		} else {
			Rango rango = policia.getRango();
			return rango.pedirPista(edificio);
		}
	}
	
	private boolean enEsteEdificioArrestaAlLadron(Policia policia, Edificio edificioActual) {
		int caracteresNombre = policia.getNombre().length();
		if (caracteresNombre > 4) {
			if (caracteresNombre % 2 == 0 && edificioActual == this.edificioCultural) {
				return true;
			}
			else if (edificioActual == this.edificioTransporte) {
				return true;
			}
		} 
		else if (edificioActual == this.edificioEconomia) {
			return true;
		}
		return false;
	}
	
	private boolean enEsteEdificioHierenAlPolicia(Policia policia, Edificio edificioActual) {
		if (!this.acaHierenAlPolicia) {
			return false;
		}
		int caracteresNombre = policia.getNombre().length();
		if (caracteresNombre < 8) {
			if (caracteresNombre % 2 == 0 && edificioActual == this.edificioCultural) {
				return true;
			}
			else if (edificioActual == this.edificioTransporte) {
				return true;
			}
		} 
		else if (edificioActual == this.edificioEconomia) {
			return true;
		}
		return false;
	}
}