package fiuba.algo3;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Ladron;
import fiuba.algo3.modelo.ExcepcionOrdenDeArrestoNoEmitida;
import fiuba.algo3.modelo.ExcepcionTiempoAgotado;

public class Controlador {
	
	private Scanner scan;
	private Juego juego;
	private Vista vista;
	
	Controlador (Juego juego){
		this.scan= new Scanner(System.in);
		this.juego=juego;
	}
	

	public int pedirOpcion() {

		return scan.nextInt();
	}
	public void setVista(Vista vista){
		this.vista=vista;
	}
	
	void pedirOpcionComputadora(){
		int opcion=pedirOpcion();
		if (opcion==1){
			vista.mostrarOpcionFiltrar();
			pedirOpcionFiltrar();
		}
		else if (opcion==2){
			pedirOpcionOrdenDeArresto();		
		}
	}

	void pedirOpcionMenu()  {
		int opcion=pedirOpcion();
		
		if (opcion==1){
			vista.mostrarOpcionPista(juego.getCiudadActualDelPolicia(),juego.getSexoLadronBuscado());
			this.pedirOpcionPista();
		}
		else if (opcion==2){
			ArrayList<String> ciudadesConectadas=juego.obtenerNombreDeLasCiudadesALasQuePuedoIr();
			vista.mostrarOpcionViajar(ciudadesConectadas,juego.getCiudadActualDelPolicia(),juego.getSexoLadronBuscado());
			this.pedirOpcionViajar(ciudadesConectadas);
		}
		else if (opcion==3){
			vista.mostrarOpcionComputadora();
			this.pedirOpcionComputadora();
		}
		else if (opcion==0){
			System.exit(0);
		}
	}

	void pedirOpcionPista()  {
		// TODO Auto-generated method stub
		int opcion=pedirOpcion();
		
		try {
			
			if (opcion==1){
				vista.imprimirPista(juego.verPistaEconomia());
			}
			else if (opcion==2){
				vista.imprimirPista(juego.verPistaTransporte());
			}
			else if (opcion==3){
				vista.imprimirPista(juego.verPistaCultural());
			}	
		}
		catch (ExcepcionTiempoAgotado e) {
			vista.mostrarElJugadorSeQuedoSinTiempo();
			vista.mostrarJugarDeNuevo();		
		}
	}

	void pedirOpcionViajar(ArrayList<String> NombreDeLasCiudadesALasQuePuedoIr)   {
		int opcion=pedirOpcion();
		if (opcion !=0){
			try {
				juego.viajar(NombreDeLasCiudadesALasQuePuedoIr.get(opcion-1));
			} 
			catch (ExcepcionTiempoAgotado e) {
				vista.mostrarElJugadorSeQuedoSinTiempo();
				vista.mostrarJugarDeNuevo();
			}
		}
	}

	 void pedirOpcionOrdenDeArresto() {
		String nombreDelLadron=juego.emitirOrdenDeArresto();
		if (nombreDelLadron!=""){
			vista.mostrarOrdenDeArrestoEmitida(nombreDelLadron);
		}
		else{
			vista.mostrarOrdenDeArrestoNoEmitida();
		}
	}

	 void pedirOpcionFiltrar(){
	
		int opcion=pedirOpcion();
			
		if (opcion==1){
			vista.mostrarOpcionFiltrarSexo();
			pedirOpcionFiltrarSexo();
		}
		else if (opcion==2){
			vista.mostrarOpcionFiltrarPelo();
			pedirOpcionFiltrarPelo();
		}
		else if (opcion==3){
			vista.mostrarOpcionFiltrarHobby();	
			pedirOpcionFiltrarHobby();
		}		
		else if (opcion==4){
			vista.mostrarOpcionFiltrarAuto();
			pedirOpcionFiltrarAuto();
		}	
		else if (opcion==5){
			vista.mostrarOpcionFiltrarMarcaPersonal();	
			pedirOpcionFiltrarMarcaPersonal();
		}
	}

     void pedirOpcionFiltrarMarcaPersonal()  {
 		int opcion=pedirOpcion();			
		
 		if (opcion==1){
 			juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.ANILLO);
 		}
 		else if (opcion==2){
 			juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.CICATRIZ);	
 		}	
 		else if (opcion==3){
 			juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.TATUAJE);		
 		}	
 		else if (opcion==0){
 			vista.mostrarOpcionFiltrar();		
 		}	
	}

	 void pedirOpcionFiltrarAuto() {
		int opcion=pedirOpcion();			
			
		if (opcion==1){
			juego.ingresarCaracteristicaDelLadron(Ladron.Auto.CONVERTIBLE);
		}
		else if (opcion==2){
			juego.ingresarCaracteristicaDelLadron(Ladron.Auto.LIMUSINA);	
		}	
		else if (opcion==3){
			juego.ingresarCaracteristicaDelLadron(Ladron.Auto.MOTO);		
		}	
		else if (opcion==0){
			vista.mostrarOpcionFiltrar();		
		}		
	}

	 void pedirOpcionFiltrarHobby()  {
		int opcion=pedirOpcion();			
	
		if(opcion==1){
			juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.ALPINISMO);
		}
		else if (opcion==2){
			juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.CROQUET);	
		}	
		else if (opcion==3){
			juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.TENNIS);		
		}	
		else if (opcion==0){
			vista.mostrarOpcionFiltrar();		
		}				
	}

	void pedirOpcionFiltrarPelo()  {

		int opcion=pedirOpcion();
		
		if (opcion==1){
			juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		}
		else if (opcion==2){
			juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.RUBIO);	
		}
		else if (opcion==3){
			juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.ROJO);		
		}		
		else if (opcion==4){
			juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.MARRON);	
		}
		else if (opcion==0){
			vista.mostrarOpcionFiltrar();		
		}		
	}

	void pedirOpcionFiltrarSexo()  {

		int opcion=pedirOpcion();	
		
		if (opcion==1){
			juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
		}
		else if (opcion==2){
			juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.FEMENINO);	
		}	
		else if (opcion==0){
			vista.mostrarOpcionFiltrar();		
		}		
	}

	public String getTiempoDisponible() {
		return juego.getTiempoDisponible();
	}

	public void pedirOpcionInicio()  {
		int opcion=pedirOpcion();	
		
		if (opcion==1){
			vista.mostrarPresentacion(juego.getCiudadActualDelPolicia(),juego.getSexoLadronBuscado());
		}
		else if (opcion==0){
			juego.cerrarJuego();
		}
	}

	public String getCiudadActualDelPolicia(){
		return juego.getCiudadActualDelPolicia();
	}

	public boolean preguntarJugarDeNuevo()  {
		int opcion=pedirOpcion();	

		if (opcion==1){
			try {
				juego.crearPartida();
			} catch (ParserConfigurationException e) {
				vista.mostrarErrorAlAbrirArchivo();
				juego.cerrarJuego();
			} catch (TransformerException e) {
				vista.mostrarErrorAlAbrirArchivo();
				juego.cerrarJuego();
			} catch (SAXException e) {
				vista.mostrarErrorAlAbrirArchivo();
				juego.cerrarJuego();
			} catch (IOException e) {
				vista.mostrarErrorAlAbrirArchivo();
				juego.cerrarJuego();
			}	
			return true;
		}
		
		else{
			return false;
		}
	}		

	public void arrestarAlLadron(){
		try {
			juego.arrestarAlLadron();
			if (juego.corroborarQueElLadronBuscadoFueArrestado()){
				vista.mostrarResultadoAtrapoAlLadronCorrecto();				
			}
			else{
				vista.mostrarResultadoAtrapoAlLadronCorrecto();				
			}
		} 
		catch (ExcepcionOrdenDeArrestoNoEmitida e) {
			vista.mostrarErrorOrdenDeArrestoNoEmitida();
		} 
	}	
	
	public void jugar() {
		vista.mostrarPresentacion(juego.getCiudadActualDelPolicia(),juego.getSexoLadronBuscado());
		while (!juego.elPoliciaLlegoAlFinalDelRecorrido()){
			vista.mostrarMenu(juego.getCiudadActualDelPolicia(),juego.getSexoLadronBuscado());
			this.pedirOpcionMenu();
		}
		arrestarAlLadron();
		juego.resetearCiudades();
	}
	
	public void iniciar(){
		vista.mostrarInicio();
		while (preguntarJugarDeNuevo()){
			jugar();
			vista.mostrarJugarDeNuevo();

		}
	}
}