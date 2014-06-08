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
	
	//GETTERS:
	public int getTiempoDisponible() {
        return this.tiempoDisponible;
    }
	
	public Rango getRango(){
    	return this.rango;
    }
	
    public void viajar(Ciudad ciudadDestino) {
        Coordenada coordenadasCiudadActual;
        double distanciaEnKM;
        coordenadasCiudadActual = (this.ciudadActual).getCoordenadas();
        distanciaEnKM = coordenadasCiudadActual.calcularDistancia(ciudadDestino.getCoordenadas());
        this.tiempoDisponible -= (this.rango).calcularTiempoDeViaje(distanciaEnKM);
        this.ciudadActual = ciudadDestino;
    }

    public Ciudad getCiudadActual() {
        return this.ciudadActual;
    }
}