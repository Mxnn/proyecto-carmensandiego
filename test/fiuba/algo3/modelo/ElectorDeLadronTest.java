package fiuba.algo3.modelo;

import java.util.ArrayList;

import org.junit.Test;
import junit.framework.Assert;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import org.xml.sax.SAXException;

import fiuba.algo3.modelo.Ladron.Auto;
import fiuba.algo3.modelo.Ladron.Hobby;
import fiuba.algo3.modelo.Ladron.MarcaPersonal;
import fiuba.algo3.modelo.Ladron.Pelo;
import fiuba.algo3.modelo.Ladron.Sexo;

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
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Sexo.MASCULINO));
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnPelo()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Pelo.NEGRO));
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnHobby()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Hobby.ALPINISMO));
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnAuto()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Auto.MOTO));
	}
	
	@Test
	public void comprueboQueElPrimerLadronCorrespondeEnMarcaPersonal()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Ladron ladron = elector.getListaDeLadrones().get(0);
		
		Assert.assertTrue(ladron.tieneEstaCaracteristica(MarcaPersonal.ANILLO));
	}
	
	@Test
	public void generarUnLadronDevuelveUnLadron()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		Assert.assertNotNull(elector.generarUnLadronBuscado());
	}
	
	@Test
	public void comprueboQueCuandoSeGeneraUnLadronEsteNoTieneOrdenDeArrestoPorMasQueAntesLaHayaRecibido()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		ArrayList<Ladron> ladrones = elector.getListaDeLadrones();
		for (Ladron ladron : ladrones) {
			ladron.recibirOrdenDeArresto();
		}
		
		Ladron buscado = elector.generarUnLadronBuscado();
		
		Assert.assertFalse(buscado.tieneOrdenDeArresto());
	}
	
	@Test
	public void comprueboQueCuandoSeGeneraUnLadronEsteNoTieneArrestoPorMasQueAntesLaHayaRecibido()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		ElectorDeLadron elector = new ElectorDeLadron();
		elector.leerXMLDeLadrones();
		
		ArrayList<Ladron> ladrones = elector.getListaDeLadrones();
		for (Ladron ladron : ladrones) {
			ladron.recibirArresto();
		}
		
		Ladron buscado = elector.generarUnLadronBuscado();
		
		Assert.assertFalse(buscado.estaArrestado());
	}
}