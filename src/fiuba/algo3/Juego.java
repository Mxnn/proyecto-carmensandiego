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
	public ArrayList<String> ingresarCaracteristicaDelLadron(Ladron.Sexo sexo) {
		this.computadora.setCaracteristicaDelLadron(sexo);
		return generarListaDeSospechososComoString();
	}
	
	public ArrayList<String> ingresarCaracteristicaDelLadron(Ladron.Pelo pelo) {
		this.computadora.setCaracteristicaDelLadron(pelo);
		return generarListaDeSospechososComoString();
	}
	
	public ArrayList<String> ingresarCaracteristicaDelLadron(Ladron.Hobby hobby) {
		this.computadora.setCaracteristicaDelLadron(hobby);
		return generarListaDeSospechososComoString();
	}
	
	public ArrayList<String> ingresarCaracteristicaDelLadron(Ladron.Auto auto) {
		this.computadora.setCaracteristicaDelLadron(auto);
		return generarListaDeSospechososComoString();
	}
	
	public ArrayList<String> ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal marcaPersonal) {
		this.computadora.setCaracteristicaDelLadron(marcaPersonal);
		return generarListaDeSospechososComoString();
	}
	
	public String verPistaEconomia() throws ExcepcionJugadorSinTiempoDisponible {
		return policia.visitarEdificioEconomia();
	}
	
	public String verPistaCultural() throws ExcepcionJugadorSinTiempoDisponible {
		return policia.visitarEdificioCultural();
	}
	
	public String verPistaTransporte() throws ExcepcionJugadorSinTiempoDisponible {
		return policia.visitarEdificioTransporte();
	}
	
	public ArrayList<String> verCiudadesALasQuePuedoIr() {
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
	
	//PRIVADOS:
	private ArrayList<String> generarListaDeSospechososComoString() {
		ArrayList<String> nombreSospechosos = new ArrayList<String>();
		for (Ladron sospechoso : computadora.getSospechososFiltrados()) {
			nombreSospechosos.add(sospechoso.getNombre());
		}
		return nombreSospechosos;
	}
}