package fiuba.algo3;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class CarmenSanDiego {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionJugadorSinTiempoDisponible {

		Juego juego=new Juego("Policia");
		juego.crearPartida();
		Controlador controlador= new Controlador(juego);
		Vista vista=controlador.getVista();
		vista.mostrarInicio();

	}

}
