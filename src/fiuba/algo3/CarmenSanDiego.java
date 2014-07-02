package fiuba.algo3;

import fiuba.algo3.modelo.Juego;

public class CarmenSanDiego {

	public static void main(String[] args) {
		Juego juego = null;
		try {
			juego = new Juego("Policia");
		} catch (Exception e) {
			System.out.println("Hubo un error al cargar los datos del juego.");
			System.exit(0);
		}
		
		if (juego != null) {
			Controlador controlador = new Controlador(juego);
			Vista vista = new Vista(juego);
		
			controlador.setVista(vista);
		
			controlador.iniciar();
		}
	}
}
