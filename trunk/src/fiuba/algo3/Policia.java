package fiuba.algo3;

public class Policia {
	public final static int TIEMPO_DISPONIBLE_INICIAL = 154;
    public final static int TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO = 3;
    public final static int TIEMPO_POR_ENTRAR_AL_PRIMER_EDIFICIO = 1;
    public final static int TIEMPO_POR_ENTRAR_AL_SEGUNDO_EDIFICIO = 2;
    public final static int TIEMPO_POR_ENTRAR_AL_TERCER_EDIFICIO = 3;

    private String nombre;
    private int tiempoDisponible;
    private Rango rango;
    private Ciudad ciudadActual;
	private int edificiosVisitadosEnEstaCiudad;
    private boolean ordenDeArrestoEmitidaContraElLadron;

    public Policia(String unNombre, Ciudad ciudadInicial) {
        this.nombre = unNombre;
        this.tiempoDisponible = TIEMPO_DISPONIBLE_INICIAL; 
        this.ciudadActual = ciudadInicial;
        this.rango = new Novato();
		this.edificiosVisitadosEnEstaCiudad = 0;
        this.ordenDeArrestoEmitidaContraElLadron = false;
    }

	//SETTERS:
    public void setRango(Rango unRango) {
        this.rango = unRango;
    }
	
	public void setTiempoDisponible(int tiempoDelPolicia){
    	this.tiempoDisponible = tiempoDelPolicia ;
    }

	//GETTERS:
	public int getTiempoDisponible() {
        return this.tiempoDisponible;
    }

	public Rango getRango(){
    	return this.rango;
    }
	
	public Ciudad getCiudadActual() {
        return this.ciudadActual;
    }

    public boolean emitioLaOrdenDeArrestoContraElLadronCorrecto() {
        return this.ordenDeArrestoEmitidaContraElLadron;
    }

    public boolean viajar(Ciudad ciudadDestino) throws ExcepcionJugadorSinTiempoDisponible {
        if (this.ciudadActual.ciudadEstaConectada(ciudadDestino)) {
            Coordenada coordenadasCiudadActual = (this.ciudadActual).getCoordenadas();
            double distanciaEnKM = coordenadasCiudadActual.calcularDistancia(ciudadDestino.getCoordenadas());
            int tiempoDescontado = (this.rango).calcularTiempoDeViaje(distanciaEnKM);

            if (this.tiempoDisponible < tiempoDescontado) {
                throw new ExcepcionJugadorSinTiempoDisponible();
            }

            this.tiempoDisponible -= tiempoDescontado;
            this.ciudadActual = ciudadDestino;
            this.edificiosVisitadosEnEstaCiudad = 0;
            return true;
        }
        return false;
    }
	
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
	
	public String visitarEdificioEconomia() throws ExcepcionJugadorSinTiempoDisponible {
		Edificio edificio = this.ciudadActual.getEdificioEconomia();
		descuentoDeTiempoPorVisitarEdificio();
        comprobarArresto();
		return this.rango.pedirPista(edificio);
	}
	
	public String visitarEdificioCultural() throws ExcepcionJugadorSinTiempoDisponible {
		Edificio edificio = this.ciudadActual.getEdificioCultural();
		descuentoDeTiempoPorVisitarEdificio();
        comprobarArresto();
		return this.rango.pedirPista(edificio);
	}
	
	public String visitarEdificioTransporte() throws ExcepcionJugadorSinTiempoDisponible {
		Edificio edificio = this.ciudadActual.getEdificioTransporte();
		descuentoDeTiempoPorVisitarEdificio();
        comprobarArresto();
		return this.rango.pedirPista(edificio);
	}

    private void comprobarArresto() {
        if (this.ciudadActual.ladronEstaEnLaCiudad() && this.edificiosVisitadosEnEstaCiudad == 3) {
            if (ordenDeArrestoEmitidaContraElLadron)
                (this.ciudadActual.getLadronEscondido()).recibirArresto();
            else
                (this.ciudadActual.getLadronEscondido()).escapar();
        }
    }

    public boolean emitirOrdenDeArresto(Computadora computadora, Ladron.Sexo sexo, Ladron.Pelo pelo, Ladron.Hobby hobbie, Ladron.Auto auto, Ladron.MarcaPersonal marcaPersonal) throws ExcepcionJugadorSinTiempoDisponible{
        descontarTiempo(TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO);
        if (computadora.filtrarLadron(sexo, pelo, hobbie, auto, marcaPersonal)) {
            this.ordenDeArrestoEmitidaContraElLadron = true;
            return true;
        }
        else return false;
    }
}