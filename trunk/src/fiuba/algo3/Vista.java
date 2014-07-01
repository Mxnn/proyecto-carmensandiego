package fiuba.algo3;

import java.util.*;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

import fiuba.algo3.modelo.Juego;

public class Vista {
	Juego juego;
	
	public Vista(Juego juego) {
		this.juego = juego;
	}
	
	public void mostrarErrorAlAbrirArchivo() {
		System.out.println ("Hubo un error al cargar los datos del juego.");
	}
	
	private void mostrarTiempoYCiudad() {
		System.out.println ("Ciudad Actual:" + this.juego.getCiudadActualDelPolicia());
		System.out.println ("Tiempo Disponible:" + this.juego.getTiempoDisponible());
	}
		
	private void imprimirOpcionRegresar() {	
		System.out.println ("0. Regresar.");
	}
	
	/********************************************************************************/
	/*                     ***       PANTALLAS INICIO       ***                     */
	/********************************************************************************/
	public void mostrarPantallaBienvenida(){
		System.out.println("*    Carmen Sandiego    *");
		System.out.println("1. Iniciar juego nuevo.");		
		System.out.println("0. Salir.");						
	}
	
	public void mostrarPedidoDeNombre() {
		System.out.println("Cuartel general.");
		System.out.println("Por favor identificate:");			
	}
	
	void mostrarPresentacionDelCaso() {
		System.out.format("Se han robado un tesoro muy importante en un museo de %s.", this.juego.getCiudadActualDelPolicia());		
		System.out.println("Es tu deber atrapar a este criminal antes que se acabe el tiempo");
		System.out.format("Se ha visto a un sospechoso del sexo %s en la escena del crimen.", this.juego.getSexoLadronBuscado());
	}
	
	public void mostrarMenuPrincipal() {
		mostrarTiempoYCiudad();
		System.out.println("Que desea hacer?");
		System.out.println("1. Pedir Pista.");		
		System.out.println("2. Viajar.");				
		System.out.println("3. Acceder a la computadora.");
		System.out.println("0. Salir.");		
	}
	
	public void mostrarJugarDeNuevo() {
		System.out.println("Desea seguir jugando?");
		System.out.println("1. Jugar otra partida.");
		System.out.println("0. Salir.");		
	}
	
	/********************************************************************************/
	/*                   ***       OPCIONES COMPUTADORA       ***                   */
	/********************************************************************************/
	void mostrarOpcionComputadora()  {
		System.out.println ("1. Anadir caracteristica del sospechoso.");		
		System.out.println ("2. Pedir orden de arresto.");				
		imprimirOpcionRegresar();
	}

	void mostrarOrdenDeArrestoEmitida(String nombreLadron) {
		System.out.format("Se ha emitido una orden de arrestro contra %s.", nombreLadron);
	}
	
	void mostrarOrdenDeArrestoNoEmitida() {
		System.out.println ("Lamentablemente la informacion brindada no permite determinar a quien emitir la orden de arresto.");
	}
	
	void mostrarOpcionFiltrar() {
		System.out.println ("1. Sexo.");		
		System.out.println ("2. Pelo.");				
		System.out.println ("3. Hobby.");	
		System.out.println ("4. Auto.");
		System.out.println ("5. MarcaPersonal.");
		imprimirOpcionRegresar();
	}

	void mostrarOpcionFiltrarMarcaPersonal() {
		System.out.println ("1. Anillo.");		
		System.out.println ("2. Cicatriz.");				
		System.out.println ("4. Tatuaje.");		
	}

	void mostrarOpcionFiltrarAuto() {
		System.out.println ("1. Convertible.");		
		System.out.println ("2. Limusina.");				
		System.out.println ("3. Moto.");
	}	
		
	void mostrarOpcionFiltrarHobby() {
		System.out.println ("1. Alpinismo.");		
		System.out.println ("2. Croquet.");				
		System.out.println ("3. Tennis.");			
	}

	void mostrarOpcionFiltrarSexo() {
		System.out.println ("1. Masculino.");		
		System.out.println ("2. Femenino.");		
	}

	void mostrarOpcionFiltrarPelo()  {
		System.out.println ("1. Negro.");		
		System.out.println ("2. Rubio.");				
		System.out.println ("3. Rojo.");	
		System.out.println ("4. Marron.");	
	}

	/********************************************************************************/
	/*                     ***        OPCIONES VIAJAR       ***                     */
	/********************************************************************************/
	void mostrarOpcionViajar() {
		mostrarTiempoYCiudad();
		
		System.out.println ("A donde desea viajar?");
		
		ArrayList<String> nombresCiudades = this.juego.obtenerNombreDeLasCiudadesALasQuePuedoIr();
		for (int i = 0; i < nombresCiudades.size(); i++) {
			System.out.format("%d. %s.", i + 1, nombresCiudades.get(i));
		}
		
		imprimirOpcionRegresar();	
	}

	/********************************************************************************/
	/*              ***        OPCIONES DE VISITAR EDIFICIOS       ***              */
	/********************************************************************************/
	void mostrarOpcionPista()  {
		mostrarTiempoYCiudad();
		System.out.println ("Que lugar desea visitar?");
		System.out.println ("1. Bolsa.");		
		System.out.println ("2. Aeropuerto.");				
		System.out.println ("3. Museo.");
		imprimirOpcionRegresar();
	}

	public void imprimirPista(String pista) {
		System.out.println(pista);
	}	
	
	/********************************************************************************/
	/*              ***        MENSAJES DE PARTIDA TERMINADA       ***              */
	/********************************************************************************/
	public void mostrarResultadoAtrapoAlLadronCorrecto()  {
		System.out.println ("Felicidades atrapo al ladron!");
	}
	
	public void mostrarResultadoAtrapoAlLadronIncorrecto()  {
		System.out.println ("La orden fue emitida hacia una persona inocente. El ladron se escapo");
	}	
	
	public void mostrarErrorOrdenDeArrestoNoEmitida(){
		System.out.println ("Se encontro al culpable pero no se habia emitido una orden de arresto. El ladron se escapo");
	}
	
	public void mostrarElJugadorSeQuedoSinTiempo() {
		System.out.println ("El Policia no pudo atrapar al culpable antes que se le acabara el tiempo. El ladron escapo.");
	}
	
	public void imprimirMensajeDeAscenso() {
		System.out.println ("Felicidades! Conseguiste un ascenso.");
	}
}
