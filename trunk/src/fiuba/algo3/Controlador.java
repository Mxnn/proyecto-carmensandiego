package fiuba.algo3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Controlador {
	
	private Scanner scan;
	private Juego juego;
	private Vista vista;
	
	Controlador (Juego juego){
		this.scan= new Scanner(System.in);
		this.juego=juego;
		this.vista=new Vista(this,juego);
	}

	public int pedirOpcion() {

		return scan.nextInt();
	}
	public Vista getVista(){
		return vista;
		
	}
	
	public void elegir_opcion_filtro() {
		
		int opcion=pedirOpcion();
		if (opcion==1){
			pedirOpcionFiltrarSexo();
		}
		else if (opcion==2){
			pedirOpcionFiltrarPelo();		
		}
		else if (opcion==3){
			pedirOpcionFiltrarHobby();		
		}		
		else if (opcion==4){
			pedirOpcionFiltrarAuto();		
		}	
		else if (opcion==5){
			pedirOpcionFiltrarMarcaPersonal();		
		}
		else if (opcion==0){
			pedirOpcionComputadora();		
		}
	}

	void pedirOpcionComputadora(){
		int opcion=pedirOpcion();
		if (opcion==1){
			vista.mostrarOpcionFiltrar();
		}
		else if (opcion==2){
			pedirOpcionOrdenDeArresto();		
		}
		else if (opcion==0){
			pedirOpcionMenu();
		}
	}

	void pedirOpcionMenu()  {
		int opcion=pedirOpcion();
		
		if (opcion==1){
			vista.mostrarOpcionPista();
		}
		else if (opcion==2){
			vista.mostrarOpcionViajar(juego.obtenerNombreDeLasCiudadesALasQuePuedoIr());
		}
		else if (opcion==3){
			vista.mostrarOpcionComputadora();		
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
		if(juego.elPoliciaLlegoAlFinalDelRecorrido()){
			
			vista.mostrarResultadoDelJuego();
		}
		vista.mostrarMenu();
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
		vista.mostrarMenu();
	}

	 void pedirOpcionOrdenDeArresto() {
		String nombreDelLadron=juego.emitirOrdenDeArresto();
		if (nombreDelLadron!=""){
			vista.mostrarOrdenDeArrestoEmitida(nombreDelLadron);
		}
		else{
			vista.mostrarOrdenDeArrestoNoEmitida();
		}
 		vista.mostrarMenu();
	}

	 void pedirOpcionFiltrar(){
	
		int opcion=pedirOpcion();
			
		if (opcion==1){
			vista.mostrarOpcionFiltrarSexo();
		}
		else if (opcion==2){
			vista.mostrarOpcionFiltrarPelo();		
		}
		else if (opcion==3){
			vista.mostrarOpcionFiltrarHobby();		
		}		
		else if (opcion==4){
			vista.mostrarOpcionFiltrarAuto();		
		}	
		else if (opcion==5){
			vista.mostrarOpcionFiltrarMarcaPersonal();		
		}
		else if (opcion==0){
			vista.mostrarOpcionComputadora();		
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
 		vista.mostrarMenu();
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
 		vista.mostrarMenu();
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
 		vista.mostrarMenu();
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
 		vista.mostrarMenu();
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
 		vista.mostrarMenu();
	}

	public String getTiempoDisponible() {
		return juego.getTiempoDisponible();
	}

	public void pedirOpcionInicio()  {
		int opcion=pedirOpcion();	
		
		if (opcion==1){
			vista.mostrarMenu();
		}
		else if (opcion==0){
			juego.cerrarJuego();
		}
	}

	public void pedirNombre() {
		String nombre=scan.next();
		
	}

	public String getCiudadActualDelPolicia(){
		return juego.getCiudadActualDelPolicia();
}

	public void preguntarJugarDeNuevo()  {
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
			vista.mostrarMenu();
		}
		else if (opcion==0){
			juego.cerrarJuego();
		}
	}		// TODO Auto-generated method stub
		
}