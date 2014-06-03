package fiuba.algo3;

import junit.framework.Assert;


public class Policia {

    private String nombre;
    private int tiempoDisponible;
    private Rango rango;
    private Ciudad ciudadActual;

    public  Policia(String unNombre) {
        this.nombre = unNombre;
        this.tiempoDisponible = 154; //Tiempo en horas
    }

    public int getTiempoDisponible() {
        return this.tiempoDisponible;
    }

    public void setRango(Rango unRango) {
        this.rango = unRango;
    }

    public String solicitarPistaEconomia() {
        return (this.ciudadActual).getPistaEconomia(this.rango);
    }

    public String solicitarPistaGeografiaHistoria() {
        return (this.ciudadActual).getPistaGeografiaHistoria(this.rango);
    }

    public String solicitarPistaSimbolosPatrios() {
    	Assert.assertEquals(this.rango,null);
    	Assert.assertEquals(this.ciudadActual,null);   	
    	
    	return (this.ciudadActual).getPistaSimbolosPatrios(this.rango);
    }

    public void setCiudadActual(Ciudad unaCiudad) {
        this.ciudadActual = unaCiudad;
    }

    public void viajar(Ciudad ciudadDestino) {
        Coordenada coordenadasCiudadActual;
        int distanciaEnKM;
        coordenadasCiudadActual = (this.ciudadActual).getCoordenadas();
        distanciaEnKM = (int) coordenadasCiudadActual.calcularDistancia(ciudadDestino.getCoordenadas());
        this.tiempoDisponible -= (this.rango).calcularTiempoDeViaje(distanciaEnKM);
        this.ciudadActual = ciudadDestino;
    }
    
    public Rango getRango (){
    	return this.rango;
    }
}