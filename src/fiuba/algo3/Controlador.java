package fiuba.algo3;

import java.util.Scanner;

public class Controlador {
	
	
	
	private Scanner scan;

	Controlador (){
		this.scan= new Scanner(System.in);
	}
	
	 int edad = scan.nextInt();

	public int pedirOpcion() {

		return scan.nextInt();
	}

}
