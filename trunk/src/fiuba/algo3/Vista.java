package fiuba.algo3;

import java.io.IOException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Vista {
	private Controlador controlador;
	private Juego juego; 

	public Vista( Controlador controlador, Juego juego)
	{	
		this.juego=juego;
		this.controlador=controlador;
	}
	
	public void mostrarInicio(){
		System.out.println ("Carmen San Diego");
		System.out.println ("1. Iniciar juego nuevo");		
		System.out.println ("0. Salir.");						

	}
	
	public void mostrarMenu() {
		imprimirCiudadActual();
		imprimirTiempoDisponible();
		System.out.println ("Que desea hacer?");
		System.out.println ("1. Pedir Pista.");		
		System.out.println ("2. Viajar.");				
		System.out.println ("3. Acceder a la computadora.");
		System.out.println ("0. Salir.");		

	}

	void mostrarPresentacion(){
		System.out.println ("Se han robado un tesoro muy importante en el museo de "+ juego.getCiudadActualDelPolicia());		
		System.out.println ("Es tu deber atrapar a este criminal antes que se acabe el tiempo");
		System.out.println ("Se ha visto a un sospechoso del sexo "+ juego.getSexoLadronBuscado()+ " en la escena del crimen");

	}
	void mostrarOpcionComputadora()  {
		System.out.println ("Que desea hacer?");
		System.out.println ("1. Filtrar sospechosos.");		
		System.out.println ("2. Pedir orden de arresto.");				
		imprimirOpcionRegresar();
	}

	void mostrarOrdenDeArrestoEmitida(String nombreLadron) {
		System.out.println ("Se ha emitido una orden de arrestro contra "+nombreLadron);
	}
	
	void mostrarOrdenDeArrestoNoEmitida() {
		System.out.println ("Lamentablemente necesitamos mas informacion para poder emitir una orden de arresto");
	}
	
	void mostrarOpcionFiltrar(){
		System.out.println ("Que tipo de caracteristica del ladron desea filtrar?");
		System.out.println ("1. Sexo.");		
		System.out.println ("2. Pelo.");				
		System.out.println ("3. Hobby.");	
		System.out.println ("4. Auto.");
		System.out.println ("5. MarcaPersonal.");
		imprimirOpcionRegresar();
	}

	void mostrarOpcionFiltrarMarcaPersonal()  {
		System.out.println ("Que tipo de marca personal tiene el ladron?");
		System.out.println ("1. Anillo.");		
		System.out.println ("2. Cicatriz.");				
		System.out.println ("3. Joyas.");	
		System.out.println ("4. Tatuaje.");		
		imprimirOpcionRegresar();	
	}

	void mostrarOpcionFiltrarAuto() {
		System.out.println ("Que tipo de auto tiene el ladron?");
		System.out.println ("1. Convertible.");		
		System.out.println ("2. Limusina.");				
		System.out.println ("3. Moto.");
		imprimirOpcionRegresar();	
	}	
		

	void mostrarOpcionFiltrarHobby() {
		System.out.println ("Que tipo de hobby tiene el ladron?");
		System.out.println ("1. Alpinismo.");		
		System.out.println ("2. Croquet.");				
		System.out.println ("3. Tennis.");
		imprimirOpcionRegresar();			
	}

	void mostrarOpcionFiltrarSexo() {
		System.out.println ("De que sexo es el ladron?");
		System.out.println ("1. Masculino.");		
		System.out.println ("2. Femenino.");
		imprimirOpcionRegresar();			
	}

	void mostrarOpcionFiltrarPelo()  {
		System.out.println ("Que color de pelo tiene el ladron?");
		System.out.println ("1. Negro.");		
		System.out.println ("2. Rubio.");				
		System.out.println ("3. Rojo.");	
		System.out.println ("4. Marron.");	
		imprimirOpcionRegresar();
	}

	void mostrarOpcionViajar(ArrayList<String> nombresCiudades)  {
		imprimirCiudadActual();
		imprimirTiempoDisponible();			
		System.out.println ("A donde desea viajar?");	
		Collections.sort(nombresCiudades);
		int numeroOpcion=1;
		for(String ciudad:nombresCiudades){
			System.out.println (numeroOpcion+". "+ciudad+".");
			numeroOpcion+=1;
		}
		imprimirOpcionRegresar();	

	}

	void mostrarOpcionPista()  {
		imprimirCiudadActual();
		imprimirTiempoDisponible();
		System.out.println ("Que lugar desea visitar?");
		System.out.println ("1. Bolsa.");		
		System.out.println ("2. Aeropuerto.");				
		System.out.println ("3. Museo.");
		imprimirOpcionRegresar()	;

	}

	public void imprimirPista(String pista) {
		System.out.println (pista);
	}	
	
	private void imprimirTiempoDisponible() {
		System.out.println ("Tiempo Disponible:"+juego.getTiempoDisponible ());
	}
	
	private void imprimirCiudadActual() {
		System.out.println ("Ciudad Actual:"+juego.getCiudadActualDelPolicia() );
	}
		
	private void imprimirOpcionRegresar() {	
		System.out.println ("0. Regresar.");
	}

	public void mostrarPedidoDeNombre() {
		System.out.println ("Cuartel general");
		System.out.println ("Por favor identificate");			
	}

	public void mostrarResultadoAtrapoAlLadronCorrecto()  {
		System.out.println ("Felicidades atrapo al ladron!");
	}
	
	public void mostrarResultadoAtrapoAlLadronIncorrecto()  {
		System.out.println ("La orden fue emitida hacia una persona inocente. El ladron se escapo");
	}	
	
	public void mostrarErrorOrdenDeArrestoNoEmitida(){
		System.out.println ("Se encontro al culpable pero no se habia emitido una orden de arresto. El ladron se escapo");
	}
	
	public void mostrarErrorAlAbrirArchivo() {
		System.out.println ("Hubo un error al cargar los datos del juego.");
	}

	public void mostrarElJugadorSeQuedoSinTiempo() {
		System.out.println ("El Policia no pudo atrapar al culpable antes que se le acabara el tiempo.El ladron escapo.");
	}
	
	public void mostrarJugarDeNuevo(){
		System.out.println ("Desea segui jugando?");
		System.out.println ("1. Jugar otra partida");
		System.out.println ("0. Salir");		
	}
}
