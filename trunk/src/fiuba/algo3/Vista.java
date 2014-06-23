package fiuba.algo3;

import java.util.*;

public class Vista {
	
	private Juego juego;
	private Controlador controlador; 

	public Vista(Juego juego, Controlador controlador)
	{	
		this.juego=juego;
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
		int opcion=controlador.pedirOpcion();
		
		if (opcion==1){
			mostrarOpcionPista();
		}
		else if (opcion==2){
			mostrarOpcionViajar(juego.obtenerNombreDeLasCiudadesALasQuePuedoIr());
		}
		else if (opcion==3){
			mostrarOpcionComputadora();		
		}
	}

	private void mostrarOpcionComputadora() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que desea hacer?");
		System.out.println ("1. Filtrar sospechosos.");		
		System.out.println ("2. Pedir orden de arresto.");				
		imprimirOpcionRegresar();
		System.out.println ("Ingrese el numero de la opcion que desee");	
		int opcion=controlador.pedirOpcion();
		
		if (opcion==1){
		
			mostrarOpcionFiltrar();
		}
		else if (opcion==2){
			mostrarOpcionOrdenDeArresto();		
		}
		else if (opcion==0){
			mostrarMenu();
		}
	}

	private void mostrarOpcionOrdenDeArresto() {
		// TODO Auto-generated method stub
		
	}

	private void mostrarOpcionFiltrar() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que tipo de caracteristica del ladron desea filtrar?");
		System.out.println ("1. Sexo.");		
		System.out.println ("2. Pelo.");				
		System.out.println ("3. Hobby.");	
		System.out.println ("4. Auto.");
		System.out.println ("5. MarcaPersonal.");
		imprimirOpcionRegresar();
		System.out.println ("Ingrese el numero de la opcion que desee");	
		int opcion=controlador.pedirOpcion();
		
		if (opcion==1){
			mostrarOpcionFiltrarSexo();
		}
		else if (opcion==2){
			mostrarOpcionFiltrarPelo();		
		}
		else if (opcion==3){
			mostrarOpcionFiltrarHobby();		
		}		
		else if (opcion==4){
			mostrarOpcionFiltrarAuto();		
		}	
		else if (opcion==5){
			mostrarOpcionFiltrarMarcaPersonal();		
		}
		else if (opcion==0){
			mostrarOpcionComputadora();		
		}
	}

	private void mostrarOpcionFiltrarMarcaPersonal() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que tipo de marca personal tiene el ladron?");
		System.out.println ("1. Anillo.");		
		System.out.println ("2. Cicatriz.");				
		System.out.println ("3. Joyas.");	
		System.out.println ("4. Tatuaje.");		
		imprimirOpcionRegresar();	
		int opcion=controlador.pedirOpcion();			
		
		if (opcion==1){
			juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.ANILLO);
		}
		else if (opcion==2){
			juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.CICATRIZ);	
		}	
		else if (opcion==3){
			juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.JOYAS);		
		}	
		else if (opcion==4){
			juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.TATUAJE);		
		}	
		else if (opcion==0){
			mostrarOpcionFiltrar();		
		}				
		
	}

	private void mostrarOpcionFiltrarAuto() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que tipo de auto tiene el ladron?");
		System.out.println ("1. Convertible.");		
		System.out.println ("2. Limusina.");				
		System.out.println ("3. Moto.");
		imprimirOpcionRegresar();			
		int opcion=controlador.pedirOpcion();			
		
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
			mostrarOpcionFiltrar();		
		}		
	}	
		
	

	private void mostrarOpcionFiltrarHobby() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que tipo de hobby tiene el ladron?");
		System.out.println ("1. Alpinismo.");		
		System.out.println ("2. Croquet.");				
		System.out.println ("3. Tennis.");
		imprimirOpcionRegresar();			
		int opcion=controlador.pedirOpcion();			
		
		if (opcion==1){
			juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.ALPINISMO);
		}
		else if (opcion==2){
			juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.CROQUET);	
		}	
		else if (opcion==3){
			juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.TENNIS);		
		}	
		else if (opcion==0){
			mostrarOpcionFiltrar();		
		}		
	}

	private void mostrarOpcionFiltrarSexo() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("De que sexo es el ladron?");
		System.out.println ("1. Masculino.");		
		System.out.println ("2. Femenino.");
		imprimirOpcionRegresar();			
		int opcion=controlador.pedirOpcion();	
		
		if (opcion==1){
			juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
		}
		else if (opcion==2){
			juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.FEMENINO);	
		}	
		else if (opcion==0){
			mostrarOpcionFiltrar();		
		}		
	}

	private void mostrarOpcionFiltrarPelo() throws ExcepcionJugadorSinTiempoDisponible {
		System.out.println ("Que color de pelo tiene el ladron?");
		System.out.println ("1. Negro.");		
		System.out.println ("2. Rubio.");				
		System.out.println ("3. Rojo.");	
		System.out.println ("4. Marron.");	
		imprimirOpcionRegresar()	;
		int opcion=controlador.pedirOpcion();
		
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
			mostrarOpcionFiltrar();		
		}		
	}

	private void mostrarOpcionViajar(ArrayList<String> nombresCiudades) throws ExcepcionJugadorSinTiempoDisponible {
		imprimirCiudadActual();
		imprimirTiempoDisponible();			
		System.out.println ("A donde desea viajar?");	
		int numeroOpcion=1;
		for(String ciudad:nombresCiudades){
			System.out.println (numeroOpcion+". "+ciudad+".");
			numeroOpcion+=1;
		}
		imprimirOpcionRegresar();	
		int opcion=controlador.pedirOpcion();
		
		juego.viajar(nombresCiudades.get(opcion-1));
		}

	private void mostrarOpcionPista() throws ExcepcionJugadorSinTiempoDisponible {
		imprimirCiudadActual();
		imprimirTiempoDisponible();
		System.out.println ("Que lugar desea visitar?");
		System.out.println ("1. Bolsa.");		
		System.out.println ("2. Aeropuerto.");				
		System.out.println ("3. Museo.");
		imprimirOpcionRegresar()	;
		System.out.println ("Ingrese el numero de la opcion que desee");
		int opcion=controlador.pedirOpcion();
		
		if (opcion==1){
			System.out.println(juego.verPistaEconomia());
		}
		else if (opcion==2){
			System.out.println(juego.verPistaTransporte());
		}
		else if (opcion==3){
			System.out.println(juego.verPistaCultural());
		}	
		mostrarMenu();
	}

	private void imprimirTiempoDisponible() {
		System.out.println ("Tiempo Disponible:"+juego.getTiempoDisponible ());
	}
	
	private void imprimirCiudadActual() {
		System.out.println ("Ciudad Actual:"+juego.getTiempoDisponible ());
	}
		
	private void imprimirOpcionRegresar() {	
	System.out.println ("0. Regresar.");
	}
}
