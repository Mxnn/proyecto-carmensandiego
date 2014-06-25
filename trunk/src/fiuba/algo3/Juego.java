package fiuba.algo3;

import java.util.ArrayList;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Juego  {
	Policia policia;
	Computadora computadora;
	GeneradorDeCasos generador;
	ElectorDeLadron elector;
	
	public Juego(String nombreJugador)
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		policia = new Policia(nombreJugador);
		
		generador = new GeneradorDeCasos();
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		
		elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
	}
	
	public Juego(String nombreJugador, ArrayList<Ciudad> ciudadesPorRecorrer, ArrayList<Ladron> ladrones) {
		policia = new Policia(nombreJugador);
		generador = new GeneradorDeCasos();
		elector = new ElectorDeLadron();
		this.computadora = new Computadora(ladrones.get(0));
		this.computadora.setSospechosos(ladrones);
		this.policia.setCiudadActual(ciudadesPorRecorrer.get(0));
		ciudadesPorRecorrer.get(ciudadesPorRecorrer.size()-1).esconderAlLadron();
	}

	public void crearPartida()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {	
		Ladron buscado = elector.generarUnLadronBuscado();
		this.computadora = new Computadora(buscado);
		this.computadora.setSospechosos(elector.getListaDeLadrones());
		
		ArrayList<Ciudad> ciudadesPorRecorrer = generador.generarUnCaso();
		this.policia.setCiudadActual(ciudadesPorRecorrer.get(0));
		ciudadesPorRecorrer.get(5).esconderAlLadron();
		elector.setPistasDelLadronBuscado(buscado, ciudadesPorRecorrer);
	}
	
	public boolean corroborarQueElLadronBuscadoFueArrestado() throws ExcepcionOrdenDeArrestoNoEmitida {
		Ladron buscado = this.computadora.getLadronBuscado();
		return buscado.estaArrestado();
	}
	
	public boolean elPoliciaLlegoAlFinalDelRecorrido() {
		Ciudad ciudadActualDelPolicia = this.policia.getCiudadActual();
		return (this.policia.yaVisitoTresEdificios() && ciudadActualDelPolicia.escondeAlLadron());
	}
	
	public String getTiempoDisponible (){
		return Integer.toString(policia.getTiempoDisponible());
	}

	public void cerrarJuego() {
		System.exit(0); 
	}
	
	public String getCiudadActualDelPolicia(){
		return policia.getCiudadActual().getNombre();
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
	
	public String verPistaEconomia() throws ExcepcionTiempoAgotado {
		return this.policia.visitarEdificioEconomia();
	}
	
	public String verPistaCultural() throws ExcepcionTiempoAgotado {
		return this.policia.visitarEdificioCultural();
	}
	
	public String verPistaTransporte() throws ExcepcionTiempoAgotado {
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
	
	public void viajar(String nombreCiudadDestino) throws ExcepcionTiempoAgotado {
		Ciudad ciudadDestino = buscarCiudadConectadaConNombre(nombreCiudadDestino);
		policia.viajar(ciudadDestino);
	}
	
	private Ciudad buscarCiudadConectadaConNombre(String nombreCiudadDestino) {
		Ciudad ciudadActual = policia.getCiudadActual();
		Ciudad ciudadbuscada = null;
		for (Ciudad ciudad : ciudadActual.getCiudadesConectadas()) {
			if (ciudad.getNombre() == nombreCiudadDestino) {	
				ciudadbuscada = ciudad;
			}
		}
		return ciudadbuscada;
	}
		
	public String emitirOrdenDeArresto() {
		return this.computadora.emitirOrdenDeArresto();
	}
	
	public void arrestarAlLadron() throws ExcepcionOrdenDeArrestoNoEmitida {
		if (this.computadora.ordenDeArrestoEmitidaContraLadronCorrecto()){
			Ladron buscado = this.computadora.getLadronBuscado();
			this.policia.arrestarAlLadron(buscado);
		}
	}
}