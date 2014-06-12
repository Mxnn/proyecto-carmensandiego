package fiuba.algo3;

public class Policia {
	public final static int TIEMPO_DISPONIBLE_INICIAL = 154; 

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

    public boolean viajar(Ciudad ciudadDestino) {
        Coordenada coordenadasCiudadActual = (this.ciudadActual).getCoordenadas();
        double distanciaEnKM = coordenadasCiudadActual.calcularDistancia(ciudadDestino.getCoordenadas());
        int tiempoDescontado = (this.rango).calcularTiempoDeViaje(distanciaEnKM);

        if (this.tiempoDisponible < tiempoDescontado){
        	return false;
        }

        this.tiempoDisponible -= tiempoDescontado;
        this.ciudadActual = ciudadDestino;
		this.edificiosVisitadosEnEstaCiudad = 0;
        return true;
    }
	
	private void descuentoDeTiempoPorVisitarEdificio() {
		if (edificiosVisitadosEnEstaCiudad == 0) {
			this.tiempoDisponible -= 1;
		} else if (edificiosVisitadosEnEstaCiudad == 1){
			this.tiempoDisponible -= 2;
		} else {
			this.tiempoDisponible -= 3;
		}
		this.edificiosVisitadosEnEstaCiudad += 1;
	}
	
	public String visitarEdificioEconomia() {
		Edificio edificio = this.ciudadActual.getEdificioEconomia();
		descuentoDeTiempoPorVisitarEdificio();
		return this.rango.pedirPista(edificio);
	}
	
	public String visitarEdificioCultural() {
		Edificio edificio = this.ciudadActual.getEdificioCultural();
		descuentoDeTiempoPorVisitarEdificio();
		return this.rango.pedirPista(edificio);
	}
	
	public String visitarEdificioTransporte() {
		Edificio edificio = this.ciudadActual.getEdificioTransporte();
		descuentoDeTiempoPorVisitarEdificio();
		return this.rango.pedirPista(edificio);
	}
}
