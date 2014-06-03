package fiuba.algo3;

public class Policia {

    private String nombre;
    private int tiempoDisponible;
    private Rango rango;
    private Ciudad ciudadActual;

    public Policia(String unNombre) {
        this.nombre = unNombre;
        this.tiempoDisponible = 154; //Tiempo en horas
    }

    public int getTiempoDisponible() {
        return this.tiempoDisponible;
    }

    public Ciudad getCiudadActual() {
        return this.ciudadActual;
    }

    public void setRango(Rango unRango) {
        this.rango = unRango;
    }

    public void setCiudadActual(Ciudad unaCiudad) {
        this.ciudadActual = unaCiudad;
    }

    public String solicitarPistaEconomia() {
        return (this.ciudadActual).getPistaEconomia(this.rango);
    }

    public String solicitarPistaGeografiaHistoria() {
        return (this.ciudadActual).getPistaGeografiaHistoria(this.rango);
    }

    public String solicitarPistaSimbolosPatrios() {
        return (this.ciudadActual).getPistaSimbolosPatrios(this.rango);
    }

    public void viajar(Ciudad ciudadDestino) {
        Coordenada coordenadasCiudadActual;
        double distanciaEnKM;
        coordenadasCiudadActual = (this.ciudadActual).getCoordenadas();
        distanciaEnKM = coordenadasCiudadActual.calcularDistancia(ciudadDestino.getCoordenadas());
        this.tiempoDisponible -= (this.rango).calcularTiempoDeViaje(distanciaEnKM);
        this.ciudadActual = ciudadDestino;
    }
}