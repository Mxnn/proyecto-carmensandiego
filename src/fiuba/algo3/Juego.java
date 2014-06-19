package fiuba.algo3;

import java.util.ArrayList;

public class Juego {
	Policia policia;
	Computadora computadora;
	
	public Juego(String nombreJugador, Ciudad ciudadInicial, Ladron buscado) {
		policia = new Policia(nombreJugador, ciudadInicial);
		computadora = new Computadora(buscado);
	}
	
	public void setSospechoso(Ladron sospechoso) {
		this.computadora.setSospechoso(sospechoso);
	}
	
	//ACCIONES PERMITIDAS AL JUGADOR:
	public void ingresarCaracteristicaDelLadron(Ladron.Sexo sexo) {
		this.computadora.setCaracteristicaDelLadron(sexo);
	}
	
	public void ingresarCaracteristicaDelLadron(Ladron.Pelo pelo) {
		this.computadora.setCaracteristicaDelLadron(pelo);
	}
	
	public void ingresarCaracteristicaDelLadron(Ladron.Hobby hobby) {
		this.computadora.setCaracteristicaDelLadron(hobby);
	}
	
	public void ingresarCaracteristicaDelLadron(Ladron.Auto auto) {
		this.computadora.setCaracteristicaDelLadron(auto);
	}
	
	public void ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal marcaPersonal) {
		this.computadora.setCaracteristicaDelLadron(marcaPersonal);
	}
	
	public String verPistaEconomia() throws ExcepcionJugadorSinTiempoDisponible {
		return this.policia.visitarEdificioEconomia();
	}
	
	public String verPistaCultural() throws ExcepcionJugadorSinTiempoDisponible {
		return this.policia.visitarEdificioCultural();
	}
	
	public String verPistaTransporte() throws ExcepcionJugadorSinTiempoDisponible {
		return this.policia.visitarEdificioTransporte();
	}
	
	public ArrayList<String> obtenerNombreDeLasCiudadesALasQuePuedoIr() {
		ArrayList<String> nombreCiudades = new ArrayList<String>();
		Ciudad ciudadActual = policia.getCiudadActual();
		for (Ciudad ciudad : ciudadActual.getCiudadesConectadas()) {
			nombreCiudades.add(ciudad.getNombre());
		}
		return nombreCiudades;
	}
	
	public void emitirOrdenDeArresto() throws ExcepcionJugadorSinTiempoDisponible {
		if (computadora.hayUnSoloSospechoso()) {
			policia.emitirOrdenDeArresto(this.computadora);
		}
	}
}