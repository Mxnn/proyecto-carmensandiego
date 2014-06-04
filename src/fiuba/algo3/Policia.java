package fiuba.algo3;

public class Policia {

    private String nombre;
    private int tiempoDisponible;
    private Rango rango;
    private Ciudad ciudadActual;

    public Policia(String unNombre) {
        this.nombre = unNombre;
        this.tiempoDisponible = 154; //Tiempo en horas
        this.rango = new Novato();
    }

	//SETTERS:
    public void setRango(Rango unRango) {
        this.rango = unRango;
    }

    public void setCiudadActual(Ciudad unaCiudad) {
        this.ciudadActual = unaCiudad;
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
        int distanciaEnKM;
        coordenadasCiudadActual = (this.ciudadActual).getCoordenadas();
        distanciaEnKM = (int) coordenadasCiudadActual.calcularDistancia(ciudadDestino.getCoordenadas());
        this.tiempoDisponible -= (this.rango).calcularTiempoDeViaje(distanciaEnKM);
        this.ciudadActual = ciudadDestino;
    }
}