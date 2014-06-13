package fiuba.algo3;

public class Juego {
	Policia policia;
	Computadora computadora;
	
	public Juego(String nombreJugador, Ciudad ciudadInicial, Ladron buscado) {
		policia = new Policia(nombreJugador, ciudadInicial);
		computadora = new Computadora(buscado);
	}
}