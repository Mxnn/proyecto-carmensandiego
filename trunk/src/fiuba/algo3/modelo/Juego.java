package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class Juego  {
	GeneradorDeCasos generador;
	ElectorDeLadron elector;
	Policia policia;
	Computadora computadora;
	Ladron buscado;
	boolean ladronEncontrado;

	public Juego(String nombreJugador)
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		this.policia = new Policia(nombreJugador);

		this.generador = new GeneradorDeCasos();
		this.generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		this.elector = new ElectorDeLadron();
		this.elector.leerXMLDeLadrones();
	}
	
	//Constructor para usar en pruebas: (no hace falta crearPartida)
	public Juego(String nombreJugador, ArrayList<Ciudad> ciudadesPorRecorrer, ArrayList<Ladron> ladrones) {
		this.policia = new Policia(nombreJugador);
		this.generador = new GeneradorDeCasos();
		this.elector = new ElectorDeLadron();
		this.computadora = new Computadora(ladrones);
		this.buscado = ladrones.get(0);
		this.ladronEncontrado = false;
		
		this.policia.setCiudadActual(ciudadesPorRecorrer.get(0));
		ciudadesPorRecorrer.get(ciudadesPorRecorrer.size()-1).esconderAlLadron();
	}
	
	public void crearPartida() {
		
		this.ladronEncontrado = false;
		this.policia.resetear();
		
		this.buscado = this.elector.generarUnLadronBuscado();
		this.computadora = new Computadora(this.elector.getListaDeLadrones());

		ArrayList<Ciudad> ciudadesPorRecorrer = this.generador.generarUnCaso();
		elector.setPistasDelLadronBuscado(this.buscado, ciudadesPorRecorrer);
		
		this.policia.setCiudadActual(ciudadesPorRecorrer.get(0));
	}
	
	public void ingresarNombreJugador(String nombreJugador) {
		this.policia.setNombre(nombreJugador);
	}
	
	public void cerrar() {
		System.exit(0);
	}
	
	public String getSexoLadronBuscado() {
		return this.buscado.generarUnaPistaSobreElSexo();
	}
	
	public int getTiempoDisponible() {
		return this.policia.getTiempoDisponible();
	}

	public String getCiudadActualDelPolicia() {
		return policia.getCiudadActual().getNombre();
	}
	
	public boolean encontreAlLadron() {
		return this.ladronEncontrado;
	}

	public boolean elLadronBuscadoFueArrestado() {
		boolean arrestoRecibido = this.buscado.estaArrestado();
		boolean ordenRecibida = this.buscado.tieneOrdenDeArresto();
		if (arrestoRecibido && ordenRecibida) {
			this.policia.resolvioUnCaso();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean elPoliciaRecibioAscenso() {
		return policia.ascender();
	}

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

	public String verPistaEconomia() throws ExcepcionTiempoAgotado {
		String pista = this.policia.visitarEdificioEconomia();
		arrestarAlLadronSiLoEncontre(pista);
		return pista;
	}

	public String verPistaCultural() throws ExcepcionTiempoAgotado {
		String pista = this.policia.visitarEdificioCultural();
		arrestarAlLadronSiLoEncontre(pista);
		return pista;
	}

	public String verPistaTransporte() throws ExcepcionTiempoAgotado {
		String pista = this.policia.visitarEdificioTransporte();
		arrestarAlLadronSiLoEncontre(pista);
		return pista;
	}

	public ArrayList<String> obtenerNombreDeLasCiudadesALasQuePuedoIr() {
		ArrayList<String> nombreCiudades = new ArrayList<String>();
		Ciudad ciudadActual = policia.getCiudadActual();
		for (Ciudad ciudad : ciudadActual.getCiudadesConectadas()) {
			nombreCiudades.add(ciudad.getNombre());
		}
		Collections.sort(nombreCiudades);
		return nombreCiudades;
	}

	public void viajar(String nombreCiudadDestino) throws ExcepcionTiempoAgotado {
		Ciudad ciudadDestino = buscarCiudadConectadaConNombre(nombreCiudadDestino);
		policia.viajar(ciudadDestino);
	}

	public String emitirOrdenDeArresto() {
		return this.computadora.emitirOrdenDeArresto();
	}
	
	public boolean ordenDeArrestoEmitida() {
		return this.computadora.ordenDeArrestoEmitida();
	}
	
	//PRIVADOS:
	private void arrestarAlLadronSiLoEncontre(String pista) {
		if (pista == "") {
			this.ladronEncontrado = true;
			this.policia.arrestarA(this.buscado);
		}
	}
	
	private Ciudad buscarCiudadConectadaConNombre(String nombreCiudadDestino) {
		ArrayList<String> nombreCiudades = new ArrayList<String>();
		Ciudad ciudadActual = policia.getCiudadActual();
		Ciudad ciudadbuscada = null;
		for (Ciudad ciudad : ciudadActual.getCiudadesConectadas()) {
			if (ciudad.getNombre() == nombreCiudadDestino) {
				ciudadbuscada = ciudad;
			}
		}
		return ciudadbuscada;
	}
}
