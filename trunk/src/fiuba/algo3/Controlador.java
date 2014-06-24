package fiuba.algo3;

import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {
	
	private Scanner scan;
	private Juego juego;
	private Vista vista;
	
	Controlador (Juego juego){
		this.scan= new Scanner(System.in);
		this.juego=juego;
		this.vista=new Vista(this);
	}

	public int pedirOpcion() {

		return scan.nextInt();
	}
	
	public void elegir_opcion_filtro() throws ExcepcionJugadorSinTiempoDisponible{
		
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

	void pedirOpcionComputadora() throws ExcepcionJugadorSinTiempoDisponible {
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

	void pedirOpcionMenu() throws ExcepcionJugadorSinTiempoDisponible {
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

	private void pedirOpcionPista() throws ExcepcionJugadorSinTiempoDisponible {
		// TODO Auto-generated method stub
		int opcion=pedirOpcion();
		
		if (opcion==1){
				vista.imprimirPista(juego.verPistaEconomia());
		}
		else if (opcion==2){
			vista.imprimirPista(juego.verPistaTransporte());
		}
		else if (opcion==3){
			vista.imprimirPista(juego.verPistaCultural());
		}	
		vista.mostrarMenu();
	}

	void pedirOpcionViajar(ArrayList<String> NombreDeLasCiudadesALasQuePuedoIr) throws ExcepcionJugadorSinTiempoDisponible {
		int opcion=pedirOpcion();
		
		juego.viajar(NombreDeLasCiudadesALasQuePuedoIr.get(opcion-1));
	}

	 void pedirOpcionOrdenDeArresto() {
		// TODO Auto-generated method stub
		
	}

	 void pedirOpcionFiltrar() throws ExcepcionJugadorSinTiempoDisponible {
	
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

     void pedirOpcionFiltrarMarcaPersonal() throws ExcepcionJugadorSinTiempoDisponible {
 		int opcion=pedirOpcion();			
		
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
 			vista.mostrarOpcionFiltrar();		
 		}				
	}

	 void pedirOpcionFiltrarAuto() throws ExcepcionJugadorSinTiempoDisponible {
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

	 void pedirOpcionFiltrarHobby() throws ExcepcionJugadorSinTiempoDisponible {
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

	void pedirOpcionFiltrarPelo() throws ExcepcionJugadorSinTiempoDisponible {

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

	void pedirOpcionFiltrarSexo() throws ExcepcionJugadorSinTiempoDisponible {

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

}