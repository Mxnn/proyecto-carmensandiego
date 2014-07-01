package fiuba.algo3.modelo;

import java.util.ArrayList;

import org.junit.Test;
import junit.framework.Assert;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import org.xml.sax.SAXException;

import fiuba.algo3.modelo.Ladron.Sexo;
import fiuba.algo3.modelo.Ladron.Pelo;
import fiuba.algo3.modelo.Ladron.Hobby;
import fiuba.algo3.modelo.Ladron.Auto;
import fiuba.algo3.modelo.Ladron.MarcaPersonal;

public class GeneradorDeCasosTest {
	@Test
	public void testEstoyLeyendoTodasLasCiudades()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception	{
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertTrue(generador.estoyLeyendoTodasLasCiudades() == 14);
	}

	@Test
	public void testEstoyLeyendoTodasLasPistasDeUnaCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception	{
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertTrue(generador.estoyLeyendoTodasLasPistasDeUnaCiudad() == 9);
	}

	@Test
	public void testEstoyLeyendoElNombreDeLaPrimerCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception	{
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoElNombreDeLaPrimerCiudad(), "Atenas");
	}

	@Test
	public void testEstoyLeyendoLaCoordenadaXDeLaPrimerCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception	{
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoLaCoordenadaXDeLaPrimerCiudad(), "4500.0");
	}

	@Test
	public void testEstoyLeyendoLaCoordenadaXDeLaPrimerCiudadComoDouble()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception	{
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoLaCoordenadaXDeLaPrimerCiudadYLaPasoADouble(), 4500.0);
	}

	@Test
	public void testEstoyLeyendoLaCoordenadaYDeLaPrimerCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception	{
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoLaCoordenadaYDeLaPrimerCiudad(), "-3540.0");
	}

	@Test
	public void testEstoyLeyendoLaCoordenadaYDeLaPrimerCiudadComoDouble()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception	{
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoLaCoordenadaYDeLaPrimerCiudadYLaPasoADouble(), -3540.0);
	}

	@Test
	public void testPuedoInstanciarUnaCiudadConElNombre()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception	{
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Ciudad ciudadGenerada = generador.puedoInstanciarUnaCiudadConElNombre();

		Assert.assertEquals(ciudadGenerada.getNombre(), "Atenas");
	}

	@Test
    public void seLevantanTodasLasCiudadesDelXML()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<Ciudad> ciudades = generador.getCiudades();

		Assert.assertTrue(ciudades.size() == 14);
	}

	@Test
    public void laPrimerCiudadLevantadGuardaElNombreCorrecto()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<Ciudad> ciudades = generador.getCiudades();

		Assert.assertEquals(ciudades.get(0).getNombre(), "Atenas");
	}

	@Test
    public void laSegundaCiudadLevantadGuardaElNombreCorrecto()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<Ciudad> ciudades = generador.getCiudades();

		Assert.assertEquals(ciudades.get(13).getNombre(), "Paris");
	}

	@Test
    public void seLevantanTodasLasPistasPorCiudadDelXML()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		Assert.assertTrue(pistasDeLasCiudades.size() == 14);
	}

	@Test
    public void seLevantanTodasLasPistasDeUnaCiudadDelXML()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(0);

		Assert.assertTrue(pistasDeUnaCiudad.size() == 9);
	}

	@Test
    public void laPrimerPistaDeLaPrimerCiudadDelXMLCoincide()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(0);

		Assert.assertEquals(pistasDeUnaCiudad.get(0).getPista(), "Cambio su dinero a drachmas.");
	}

	@Test
    public void laUltimaPistaDeLaPrimerCiudadDelXMLCoincide()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(0);

		Assert.assertEquals(pistasDeUnaCiudad.get(8).getPista(), "Me pregunto si tenia algun libro sobre restos arqueologicos");
	}

	@Test
    public void laPrimerPistaDeLaUltimaCiudadDelXMLCoincide()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(13);

		Assert.assertEquals(pistasDeUnaCiudad.get(0).getPista(), "Cambio su dinero a Euros.");
	}

	@Test
    public void laUltimaPistaDeLaUltimaCiudadDelXMLCoincide()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(13);

		Assert.assertEquals(pistasDeUnaCiudad.get(8).getPista(), "Estaba llendo una biblografia de Luis XIV, el rey Sol.");
	}
	
	private Policia crearUnCasoParaTest() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		Policia policia = new Policia("Juan");
		Ladron buscado = new Ladron("Pepe", Sexo.MASCULINO, Pelo.RUBIO, Hobby.CROQUET, Auto.MOTO, MarcaPersonal.ANILLO);
		
		GeneradorDeCasos generador = new GeneradorDeCasos();
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		
		generador.generarUnCaso(buscado, policia);
		
		return policia;
	}
	
	@Test
    public void	generarUnCasoSeteaLaPrimerCiudadConLasCiudadesSiguientes()
    throws ParserConfigurationException, TransformerException, SAXException, IOException {

		Policia policiaCasoDePrueba = crearUnCasoParaTest();
		
		Ciudad ciudadInicial = policiaCasoDePrueba.getCiudadActual();
		ArrayList<Ciudad> ciudadesSiguientes = ciudadInicial.getCiudadesConectadas();
		
		Assert.assertTrue(ciudadesSiguientes.size() == GeneradorDeCasos.CANTIDAD_DE_CIUDADES_CONECTADAS);
	}
}
