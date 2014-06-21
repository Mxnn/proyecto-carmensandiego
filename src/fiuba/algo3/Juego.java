package fiuba.algo3;

import java.util.ArrayList;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class Juego {
	Policia policia;
	Computadora computadora;
	GeneradorDeCasos generador;
	
	public Juego(String nombreJugador) {
		policia = new Policia(nombreJugador);
		generador= new GeneradorDeCasos();
	}
	
	public void crearPartida (Ladron buscado)
	throws ParserConfigurationException, TransformerException, SAXException, IOException{	
		
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		computadora = new Computadora(elector.generarUnLadronBuscado());
		computadora.setSospechosos(elector.getListaDeLadrones());
		
		ArrayList<Ciudad> ciudadesPorRecorrer = generador.generarUnCaso();
		this.policia.setCiudadActual(ciudadesPorRecorrer.get(0));
		ciudadesPorRecorrer.get(5).esconderAlLadron();
	}
	
	public boolean corroborarQueElLadronBuscadoFueArrestado() throws ExcepcionOrdenDeArrestoNoEmitida {
		Ladron buscado = this.computadora.getLadronBuscado();
		return buscado.estaArrestado();
	}
	
	public boolean elPoliciaLlegoAlFinalDelRecorrido() {
		Ciudad ciudadActualDelPolicia = this.policia.getCiudadActual();
		return (this.policia.yaVisitoTresEdificios() && ciudadActualDelPolicia.escondeAlLadron());
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
	
	public void viajar() {
		
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