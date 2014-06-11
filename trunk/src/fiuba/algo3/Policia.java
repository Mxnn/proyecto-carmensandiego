package fiuba.algo3;

public class Policia {

    private String nombre;
    private int tiempoDisponible;
    private Rango rango;
    private Ciudad ciudadActual;

    public Policia(String unNombre, Ciudad ciudadInicial) {
        this.nombre = unNombre;
        this.tiempoDisponible = 154; //Tiempo en horas
        this.ciudadActual = ciudadInicial;
        this.rango = new Novato();
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
        Coordenada coordenadasCiudadActual;
        double distanciaEnKM;
        coordenadasCiudadActual = (this.ciudadActual).getCoordenadas();
        distanciaEnKM = coordenadasCiudadActual.calcularDistancia(ciudadDestino.getCoordenadas());
        int tiempoDescontado = (this.rango).calcularTiempoDeViaje(distanciaEnKM);

        if (this.tiempoDisponible < tiempoDescontado){
        	return false;
        }

        this.tiempoDisponible -= tiempoDescontado;
        this.ciudadActual = ciudadDestino;
        return true;
    }
}
