package fiuba.algo3;

import java.util.ArrayList;

import org.junit.Test;
import junit.framework.Assert;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import org.xml.sax.SAXException;

public class ElectorDeLadronTest {
	@Test
	public void leerXMLDeLadronesGeneraUnaListaConTodosLosLadrones()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		ArrayList<Ladron> ladrones = elector.getListaDeLadrones();
		
		Assert.assertTrue(ladrones.size() == 10);
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnNombre()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertEquals(ladron.getNombre(), "Nick Brunch");
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnSexo()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Sexo.MASCULINO));
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnPelo()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Pelo.NEGRO));
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnHobby()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Hobby.ALPINISMO));
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnAuto()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Auto.MOTO));
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnMarcaPersonal()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.MarcaPersonal.ANILLO));
	}
	
	private ArrayList<Ciudad> crearUnArrayDeCiudadesPorDefecto() {
		Ciudad primerCiudad = new Ciudad("Primera", new Coordenada(1.0, 1.0));
		Ciudad segundaCiudad = new Ciudad("Segunda", new Coordenada(2.0, 1.0));
		Ciudad tercerCiudad = new Ciudad("Tercera", new Coordenada(3.0, 1.0));
		Ciudad cuartaCiudad = new Ciudad("Cuarta", new Coordenada(4.0, 1.0));
		Ciudad quintaCiudad = new Ciudad("Quinta", new Coordenada(5.0, 1.0));
		Ciudad sextaCiudad = new Ciudad("Sexta", new Coordenada(6.0, 1.0));
		
		ArrayList<Ciudad> ciudadesPorRecorrer = new ArrayList<Ciudad>();
		ciudadesPorRecorrer.add(primerCiudad);
		ciudadesPorRecorrer.add(segundaCiudad);
		ciudadesPorRecorrer.add(tercerCiudad);
		ciudadesPorRecorrer.add(cuartaCiudad);
		ciudadesPorRecorrer.add(quintaCiudad);
		ciudadesPorRecorrer.add(sextaCiudad);
		
		return ciudadesPorRecorrer;
	}
	
	@Test
	public void laPistaSobreElPeloDelLadronBuscadoSeGuardaEnElEdificioCulturalDeLaPrimerCiudad() {
		ArrayList<Ciudad> ciudadesPorRecorrer = crearUnArrayDeCiudadesPorDefecto();
		
		Ladron buscado = new Ladron("Buscado", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.TENNIS, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		
		ElectorDeLadron elector = new ElectorDeLadron();
		
		elector.setPistasDelLadronBuscado(buscado, ciudadesPorRecorrer);
		
		Ciudad primera = ciudadesPorRecorrer.get(0);
		Edificio cultural = primera.getEdificioCultural();
		Novato novato = new Novato();
		
		Assert.assertEquals(cultural.getPista(novato), Pista.PISTA_POR_DEFECTO_LUGAR + " " + "Tenia el pelo negro");
	}
	
	@Test
	public void laPistaSobreElHobbyDelLadronBuscadoSeGuardaEnElEdificioTransporteDeLaSegundaCiudad() {
		ArrayList<Ciudad> ciudadesPorRecorrer = crearUnArrayDeCiudadesPorDefecto();
		
		Ladron buscado = new Ladron("Buscado", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.TENNIS, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		
		ElectorDeLadron elector = new ElectorDeLadron();
		
		elector.setPistasDelLadronBuscado(buscado, ciudadesPorRecorrer);
		
		Ciudad primera = ciudadesPorRecorrer.get(1);
		Edificio cultural = primera.getEdificioTransporte();
		Novato novato = new Novato();
		
		Assert.assertEquals(cultural.getPista(novato), Pista.PISTA_POR_DEFECTO_LUGAR + " " + "Dijo que era bueno en tennis");
	}
	
	@Test
	public void laPistaSobreElAutoDelLadronBuscadoSeGuardaEnElEdificioTransporteDeLaTercerCiudad() {
		ArrayList<Ciudad> ciudadesPorRecorrer = crearUnArrayDeCiudadesPorDefecto();
		
		Ladron buscado = new Ladron("Buscado", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.TENNIS, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		
		ElectorDeLadron elector = new ElectorDeLadron();
		
		elector.setPistasDelLadronBuscado(buscado, ciudadesPorRecorrer);
		
		Ciudad primera = ciudadesPorRecorrer.get(2);
		Edificio cultural = primera.getEdificioTransporte();
		Novato novato = new Novato();
		
		Assert.assertEquals(cultural.getPista(novato), Pista.PISTA_POR_DEFECTO_LUGAR + " " + "Conducia un convertible");
	}
	
	@Test
	public void laPistaSobreLaMarcaPersonalDelLadronBuscadoSeGuardaEnElEdificioEconomiaDeLaQuintaCiudad() {
		ArrayList<Ciudad> ciudadesPorRecorrer = crearUnArrayDeCiudadesPorDefecto();
		
		Ladron buscado = new Ladron("Buscado", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.TENNIS, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		
		ElectorDeLadron elector = new ElectorDeLadron();
		
		elector.setPistasDelLadronBuscado(buscado, ciudadesPorRecorrer);
		
		Ciudad primera = ciudadesPorRecorrer.get(4);
		Edificio cultural = primera.getEdificioEconomia();
		Novato novato = new Novato();
		
		Assert.assertEquals(cultural.getPista(novato), Pista.PISTA_POR_DEFECTO_LUGAR + " " + "Vi que llevaba una cicatriz");
	}
}
