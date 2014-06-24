package fiuba.algo3;

import java.util.*;

public class Vista {
	
	private Controlador controlador; 

	public Vista( Controlador controlador)
	{	

		this.controlador=controlador;
	}
	
	public void mostrarMenu() throws ExcepcionJugadorSinTiempoDisponible{
		imprimirCiudadActual();
		imprimirTiempoDisponible();
		System.out.println ("Que desea hacer?");
		System.out.println ("1. Pedir Pista.");		
		System.out.println ("2. Viajar.");				
		System.out.println ("3. Acceder a la computadora.");
		System.out.println ("4. Salir.");		
		System.out.println ("Ingrese el numero de la opcion que desee");
		controlador.pedirOpcionMenu();
	}

	void mostrarOpcionComputadora() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que desea hacer?");
		System.out.println ("1. Filtrar sospechosos.");		
		System.out.println ("2. Pedir orden de arresto.");				
		imprimirOpcionRegresar();
		System.out.println ("Ingrese el numero de la opcion que desee");	

		controlador.pedirOpcionComputadora();
	}

	private void mostrarOpcionOrdenDeArresto() {
		// TODO Auto-generated method stub
		
	}

	void mostrarOpcionFiltrar() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que tipo de caracteristica del ladron desea filtrar?");
		System.out.println ("1. Sexo.");		
		System.out.println ("2. Pelo.");				
		System.out.println ("3. Hobby.");	
		System.out.println ("4. Auto.");
		System.out.println ("5. MarcaPersonal.");
		imprimirOpcionRegresar();
		System.out.println ("Ingrese el numero de la opcion que desee");	
		
		controlador.pedirOpcionFiltrar();

	}

	void mostrarOpcionFiltrarMarcaPersonal() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que tipo de marca personal tiene el ladron?");
		System.out.println ("1. Anillo.");		
		System.out.println ("2. Cicatriz.");				
		System.out.println ("3. Joyas.");	
		System.out.println ("4. Tatuaje.");		
		imprimirOpcionRegresar();	
		
		controlador.pedirOpcionFiltrarMarcaPersonal();

		
	}

	void mostrarOpcionFiltrarAuto() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que tipo de auto tiene el ladron?");
		System.out.println ("1. Convertible.");		
		System.out.println ("2. Limusina.");				
		System.out.println ("3. Moto.");
		imprimirOpcionRegresar();	
		controlador.pedirOpcionFiltrarAuto();
	}	
		

	void mostrarOpcionFiltrarHobby() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que tipo de hobby tiene el ladron?");
		System.out.println ("1. Alpinismo.");		
		System.out.println ("2. Croquet.");				
		System.out.println ("3. Tennis.");
		imprimirOpcionRegresar();			
		controlador.pedirOpcionFiltrarHobby();
		

	}

	void mostrarOpcionFiltrarSexo() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("De que sexo es el ladron?");
		System.out.println ("1. Masculino.");		
		System.out.println ("2. Femenino.");
		imprimirOpcionRegresar();			
		controlador.pedirOpcionFiltrarSexo();

	}

	void mostrarOpcionFiltrarPelo() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que color de pelo tiene el ladron?");
		System.out.println ("1. Negro.");		
		System.out.println ("2. Rubio.");				
		System.out.println ("3. Rojo.");	
		System.out.println ("4. Marron.");	
		imprimirOpcionRegresar()	;
		
		controlador.pedirOpcionFiltrarPelo();

	}

	void mostrarOpcionViajar(ArrayList<String> nombresCiudades) throws ExcepcionJugadorSinTiempoDisponible {
		imprimirCiudadActual();
		imprimirTiempoDisponible();			
		System.out.println ("A donde desea viajar?");	
		int numeroOpcion=1;
		for(String ciudad:nombresCiudades){
			System.out.println (numeroOpcion+". "+ciudad+".");
			numeroOpcion+=1;
		}
		imprimirOpcionRegresar();	
		controlador.pedirOpcionViajar(nombresCiudades) ;
	}

	void mostrarOpcionPista() throws ExcepcionJugadorSinTiempoDisponible {
		imprimirCiudadActual();
		imprimirTiempoDisponible();
		System.out.println ("Que lugar desea visitar?");
		System.out.println ("1. Bolsa.");		
		System.out.println ("2. Aeropuerto.");				
		System.out.println ("3. Museo.");
		imprimirOpcionRegresar()	;
		System.out.println ("Ingrese el numero de la opcion que desee");
	}

	public void imprimirPista(String pista) {
		System.out.println (pista);
	}	
	
	private void imprimirTiempoDisponible() {
		System.out.println ("Tiempo Disponible:"+controlador.getTiempoDisponible ());
	}
	
	private void imprimirCiudadActual() {
		System.out.println ("Ciudad Actual:"+controlador.getTiempoDisponible ());
	}
		
	private void imprimirOpcionRegresar() {	
	System.out.println ("0. Regresar.");
	}
}