package fiuba.algo3;

public class Policia {
	public final static int TIEMPO_DISPONIBLE_INICIAL = 154;
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

    public Policia(String unNombre, Ciudad ciudadInicial) {
        this.nombre = unNombre;
        this.tiempoDisponible = TIEMPO_DISPONIBLE_INICIAL;
        this.ciudadActual = ciudadInicial;
        this.rango = new Novato();
		this.edificiosVisitadosEnEstaCiudad = 0;
    }
    public Policia (String unNombre){
        this.nombre = unNombre;
        this.tiempoDisponible = TIEMPO_DISPONIBLE_INICIAL;
        this.rango = new Novato();
		this.edificiosVisitadosEnEstaCiudad = 0;   	

    }
	//SETTERS:
    public void setRango(Rango unRango) {
        this.rango = unRango;
    }

	public void setTiempoDisponible(int tiempoDelPolicia){
    	this.tiempoDisponible = tiempoDelPolicia ;
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
	
	public boolean yaVisitoTresEdificios() {
		return this.edificiosVisitadosEnEstaCiudad == 3;
	}

    public void viajar(Ciudad ciudadDestino) throws ExcepcionJugadorSinTiempoDisponible {
		Coordenada coordenadasCiudadActual = (this.ciudadActual).getCoordenadas();
		
		double distanciaEnKM = coordenadasCiudadActual.calcularDistancia(ciudadDestino.getCoordenadas());
		int tiempoDelViaje = (this.rango).calcularTiempoDeViaje(distanciaEnKM);
		descontarTiempo(tiempoDelViaje);
		
		this.ciudadActual = ciudadDestino;
		this.edificiosVisitadosEnEstaCiudad = 0;
    }

	public String visitarEdificioEconomia() throws ExcepcionJugadorSinTiempoDisponible {
		descuentoDeTiempoPorVisitarEdificio();
		Edificio edificio = this.ciudadActual.getEdificioEconomia(this);
		return this.rango.pedirPista(edificio);
	}

	public String visitarEdificioCultural() throws ExcepcionJugadorSinTiempoDisponible {
		descuentoDeTiempoPorVisitarEdificio();
		Edificio edificio = this.ciudadActual.getEdificioCultural(this);
		return this.rango.pedirPista(edificio);
	}

	public String visitarEdificioTransporte() throws ExcepcionJugadorSinTiempoDisponible {
		descuentoDeTiempoPorVisitarEdificio();
		Edificio edificio = this.ciudadActual.getEdificioTransporte(this);
		return this.rango.pedirPista(edificio);
	}

    public String emitirOrdenDeArresto(Computadora computadora) throws ExcepcionJugadorSinTiempoDisponible {
        descontarTiempo(TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO);
        return computadora.emitirOrdenDeArresto();
    }
	
	public void arrestarAlLadron(Ladron buscado) {
		buscado.recibirArresto();
	}
	
	public void recibirHerida() throws ExcepcionJugadorSinTiempoDisponible {
		descontarTiempo(TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	//PRIVADOS
	private void descuentoDeTiempoPorVisitarEdificio() throws ExcepcionJugadorSinTiempoDisponible {
		if (edificiosVisitadosEnEstaCiudad == 0) {
            this.descontarTiempo(TIEMPO_POR_ENTRAR_AL_PRIMER_EDIFICIO);
		} else if (edificiosVisitadosEnEstaCiudad == 1){
			this.descontarTiempo(TIEMPO_POR_ENTRAR_AL_SEGUNDO_EDIFICIO);
		} else {
            this.descontarTiempo(TIEMPO_POR_ENTRAR_AL_TERCER_EDIFICIO);
		}
		this.edificiosVisitadosEnEstaCiudad += 1;
	}

    private void descontarTiempo(int cantidad) throws ExcepcionJugadorSinTiempoDisponible {
        if (cantidad <= this.tiempoDisponible) {
            this.tiempoDisponible -= cantidad;
        }
        else
            throw new ExcepcionJugadorSinTiempoDisponible();
    }
}
