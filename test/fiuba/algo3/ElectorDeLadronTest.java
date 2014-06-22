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
}
