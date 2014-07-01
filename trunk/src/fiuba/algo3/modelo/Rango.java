package fiuba.algo3.modelo;

public interface Rango {
	public int calcularTiempoDeViaje(double distancia);
    public String pedirPista(Edificio edificio);
	public Rango determinarRangoSiguiente(int cantidadDeCasos);
}
