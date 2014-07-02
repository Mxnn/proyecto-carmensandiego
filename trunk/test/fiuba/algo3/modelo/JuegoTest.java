package fiuba.algo3.modelo;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.xml.sax.SAXException;

import fiuba.algo3.modelo.Ladron.Auto;
import fiuba.algo3.modelo.Ladron.Hobby;
import fiuba.algo3.modelo.Ladron.MarcaPersonal;
import fiuba.algo3.modelo.Ladron.Pelo;
import fiuba.algo3.modelo.Ladron.Sexo;
import junit.framework.Assert;

public class JuegoTest {
	private Juego crearUnJuegoParaTests() {
		ArrayList <Ciudad>ciudades = new ArrayList<Ciudad>();
		ciudades.add(new Ciudad("Buenos Aires", new Coordenada(5241.0, 8475.0)));
		ciudades.add(new Ciudad("Madrid", new Coordenada(4781.0, 5379.0)));	
		ciudades.get(0).conectarCiudad(ciudades.get(1));
		ciudades.get(1).conectarCiudad(ciudades.get(0));
		
		ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
		ladrones.add(new Ladron("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));
		ladrones.add(new Ladron("Juana", Sexo.FEMENINO, Pelo.RUBIO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE));	
		
		Juego juego = new Juego("Gonzalo", ciudades, ladrones);
		return juego;
	}
	
	@Test(expected = ExcepcionTiempoAgotado.class)
	public void seLanzaLaExcepcionDeTiempoAgotadoSiSeLeAcabaElTiempoALPoliciaPorPedirPistas() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionTiempoAgotado {
		Juego juego = new Juego("Gonzalo");
		juego.crearPartida();
		
		for (int i = 0; i < 100; i++) {
			juego.verPistaEconomia();
		}
	}
	
	@Test(expected = ExcepcionTiempoAgotado.class)
	public void seLanzaLaExcepcionDeTiempoAgotadoSiSeLeAcabaElTiempoALPoliciaPorViajar() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionTiempoAgotado {
		Juego juego = new Juego("Gonzalo");
		juego.crearPartida();
		
		for (int i = 0; i < 1006; i++) {
			ArrayList<String> ciudadesPorRecorrer = juego.obtenerNombreDeLasCiudadesALasQuePuedoIr();
			juego.viajar(ciudadesPorRecorrer.get(0));
		}
	}
	
	@Test
	public void emitirOrdenDeArrestoDevuelveElNombreDelLadronBUscadoCUandoSeAplicanLosFiltrosCorrectos() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionTiempoAgotado {
		Juego juego = crearUnJuegoParaTests();
		
		juego.viajar("Madrid");
		juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.ROJO);
		
		Assert.assertEquals(juego.emitirOrdenDeArresto(), "Juan");
	}
	
	public void elTiempoDisponibleDelPoliciaSeObtieneCorrectamente() {
		Juego juego = crearUnJuegoParaTests();
		
		Assert.assertEquals(juego.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
	
	public void puedoObtenerElNombreDeLaCiudadEnQueSeEncuentraElPolicia() {
		Juego juego = crearUnJuegoParaTests();
		
		Assert.assertEquals(juego.getCiudadActualDelPolicia(), "Buenos Aires");
	}
}