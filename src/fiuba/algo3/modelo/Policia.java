package fiuba.algo3.modelo;

public class Policia {
	public final static int TIEMPO_DISPONIBLE_INICIAL = 106;
    public final static int TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO = 3;
	public final static int TIEMPO_POR_RECIBIR_HERIDA = 3;
    public final static int TIEMPO_POR_ENTRAR_AL_PRIMER_EDIFICIO = 1;
    public final static int TIEMPO_POR_ENTRAR_AL_SEGUNDO_EDIFICIO = 2;
    public final static int TIEMPO_POR_ENTRAR_AL_TERCER_EDIFICIO = 3;

    private String nombre;
    private int tiempoDisponible;
    private Rango rango;
    private Ciudad ciudadActual;
	private int edificiosVisitadosEnEstaCiudad;
	private int casosResueltos;

    public Policia(String unNombre) {
        this.nombre = unNombre;
        this.tiempoDisponible = TIEMPO_DISPONIBLE_INICIAL;
        this.rango = new Novato();
		this.edificiosVisitadosEnEstaCiudad = 0;
		this.casosResueltos	= 0;
    }
	
	//SETTERS:
    public void setRango(Rango unRango) {
        this.rango = unRango;
    }

	public void setTiempoDisponible(int tiempoDelPolicia){
    	this.tiempoDisponible = tiempoDelPolicia ;
    }
	
	public void setCiudadActual(Ciudad ciudad) {
		this.ciudadActual = ciudad;
	}

	//GETTERS:
	public String getNombre() {
		return this.nombre;
	}
	
	public int getTiempoDisponible() {
        return this.tiempoDisponible;
    }

	public Rango getRango(){
    	return this.rango;
    }

	public Ciudad getCiudadActual() {
        return this.ciudadActual;
    }
	
	//LOGICA:
	public void resetear() {
		this.tiempoDisponible = TIEMPO_DISPONIBLE_INICIAL;
		this.edificiosVisitadosEnEstaCiudad = 0;
	}

    public void viajar(Ciudad ciudadDestino) throws ExcepcionTiempoAgotado {
		Coordenada coordenadasCiudadActual = (this.ciudadActual).getCoordenadas();
		
		double distanciaEnKM = coordenadasCiudadActual.calcularDistancia(ciudadDestino.getCoordenadas());
		int tiempoDelViaje = (this.rango).calcularTiempoDeViaje(distanciaEnKM);
		descontarTiempo(tiempoDelViaje);
		
		this.ciudadActual = ciudadDestino;
		this.edificiosVisitadosEnEstaCiudad = 0;
    }

	public String visitarEdificioEconomia() throws ExcepcionTiempoAgotado {
		descuentoDeTiempoPorVisitarEdificio();
		return this.ciudadActual.recibirVisitaEdificioEconomia(this);
	}

	public String visitarEdificioCultural() throws ExcepcionTiempoAgotado {
		descuentoDeTiempoPorVisitarEdificio();
		return this.ciudadActual.recibirVisitaEdificioCultural(this);
	}

	public String visitarEdificioTransporte() throws ExcepcionTiempoAgotado {
		descuentoDeTiempoPorVisitarEdificio();
		return this.ciudadActual.recibirVisitaEdificioTransporte(this);
	}

    public String emitirOrdenDeArresto(Computadora computadora) throws ExcepcionTiempoAgotado {
        descontarTiempo(TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO);
        return computadora.emitirOrdenDeArresto();
    }
	
	public void arrestarA(Ladron buscado) {
		buscado.recibirArresto();
	}
	
	public void recibirHerida() throws ExcepcionTiempoAgotado {
		descontarTiempo(TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	public void resolvioUnCaso() {
		this.casosResueltos++;
	}
	
	public boolean ascender() {
		Rango siguiente = this.rango.determinarRangoSiguiente(this.casosResueltos);
		if (siguiente != null) {
			this.rango = siguiente;
			return true;
		}
		return false;
	}
	
	//PRIVADOS
	private void descuentoDeTiempoPorVisitarEdificio() throws ExcepcionTiempoAgotado {
		if (edificiosVisitadosEnEstaCiudad == 0) {
            this.descontarTiempo(TIEMPO_POR_ENTRAR_AL_PRIMER_EDIFICIO);
		} else if (edificiosVisitadosEnEstaCiudad == 1){
			this.descontarTiempo(TIEMPO_POR_ENTRAR_AL_SEGUNDO_EDIFICIO);
		} else {
            this.descontarTiempo(TIEMPO_POR_ENTRAR_AL_TERCER_EDIFICIO);
		}
		this.edificiosVisitadosEnEstaCiudad += 1;
	}

    private void descontarTiempo(int cantidad) throws ExcepcionTiempoAgotado {
        if (cantidad <= this.tiempoDisponible) {
            this.tiempoDisponible -= cantidad;
        }
        else
            throw new ExcepcionTiempoAgotado();
    }
}
