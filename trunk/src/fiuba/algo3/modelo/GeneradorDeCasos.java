package fiuba.algo3.modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GeneradorDeCasos {
	public final static String NOMBRE_ARCHIVO_INFO_CIUDADES = "archivosXML/PistasDeCiudades.xml";
	public final static int CANTIDAD_DE_CIUDADES_POR_RECORRER = 6;
	public final static String PISTA_ESTA_CERCA_EL_LADRON = "Algo muy raro esta pasando en la ciudad.";

	private ArrayList<Ciudad> ciudades;
	private ArrayList<ArrayList<Pista>> pistasDeLasCiudades;

	public GeneradorDeCasos() {
		ciudades = new ArrayList<Ciudad>();
		pistasDeLasCiudades = new ArrayList<ArrayList<Pista>>();
	}

	public void leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		File archivo = new File(NOMBRE_ARCHIVO_INFO_CIUDADES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		NodeList listaNodosCiudades = doc.getElementsByTagName("Ciudad");

		for (int i = 0; i < listaNodosCiudades.getLength(); i++) {
			Element elementoCiudad = (Element)listaNodosCiudades.item(i);

			String nombre = elementoCiudad.getAttribute("Nombre");
			String coordenadaXstr = elementoCiudad.getAttribute("CoordenadaX");
			String coordenadaYstr = elementoCiudad.getAttribute("CoordenadaY");

			double coordenadaX = Double.parseDouble(coordenadaXstr);
			double coordenadaY = Double.parseDouble(coordenadaYstr);

			Ciudad ciudad = new Ciudad(nombre, new Coordenada(coordenadaX, coordenadaY));
			this.ciudades.add(ciudad);

			ArrayList<Pista> pistasPorCiudad = new ArrayList<Pista>();
			NodeList listaNodosPistas = elementoCiudad.getElementsByTagName("Pista");

			for (int j = 0; j < listaNodosPistas.getLength(); j++) {
				Element elementoPista = (Element)listaNodosPistas.item(j);
				Pista pista = new Pista(elementoPista.getAttribute("String"));
				pistasPorCiudad.add(pista);
			}
			this.pistasDeLasCiudades.add(pistasPorCiudad);
		}
	}
	
	public void  generarUnCaso(Ladron buscado, Policia policia) {
		limpiarCiudades();
		
		Random rand = new Random();
		ArrayList<Ciudad> ciudadesPorRecorrer = new ArrayList<Ciudad>();
		ArrayList<ArrayList<Pista>> pistasDeLaCiudadesPorRecorrer = new ArrayList<ArrayList<Pista>>();

		while (CANTIDAD_DE_CIUDADES_POR_RECORRER > ciudadesPorRecorrer.size()) {
			int posicion = rand.nextInt(this.ciudades.size());
			Ciudad ciudadAgregada = this.ciudades.get(posicion);
			if (!ciudadesPorRecorrer.contains(ciudadAgregada)){
				ciudadesPorRecorrer.add(ciudadAgregada);
				pistasDeLaCiudadesPorRecorrer.add(pistasDeLasCiudades.get(posicion));
			}
		}
		
		agregarCiudadesSiguientes(ciudadesPorRecorrer);
		setearPistasDeLaCiudadSiguiente(ciudadesPorRecorrer, pistasDeLaCiudadesPorRecorrer);
		setearPistasDelLadronBuscado(buscado, ciudadesPorRecorrer);
		seleccionarCiudadDondeHierenAlPolicia(ciudadesPorRecorrer);
		policia.setCiudadActual(ciudadesPorRecorrer.get(0));
		esconderAlLadron(ciudadesPorRecorrer);
	}	
	
	private void limpiarCiudades() {
		for (Ciudad ciudad : this.ciudades) {
			ciudad.resetear();
		}
	}
	
	private void agregarCiudadesSiguientes(ArrayList<Ciudad> ciudadesPorRecorrer) {
		for (int i = 0; i < CANTIDAD_DE_CIUDADES_POR_RECORRER; i++) {
			Ciudad ciudad = ciudadesPorRecorrer.get(i);
			if (i + 1 < CANTIDAD_DE_CIUDADES_POR_RECORRER) {	
				ciudad.conectarCiudad(ciudadesPorRecorrer.get(i + 1));
			}
			conectarCiudadesRandom(ciudad, ciudadesPorRecorrer);
		}
	}
	
	private void conectarCiudadesRandom(Ciudad ciudadActual, ArrayList<Ciudad> ciudadesPorRecorrer) {
		Random rand = new Random();
		while (ciudadActual.cantidadDeCiudadesConectadas() < 4) {
			int posicionRandom = rand.nextInt(this.ciudades.size());
			Ciudad ciudadPorAgregar = this.ciudades.get(posicionRandom);
			if (!ciudadesPorRecorrer.contains(ciudadPorAgregar)) {
				ciudadActual.conectarCiudad(ciudadPorAgregar);
			}
		}
    }
	
	private void esconderAlLadron(ArrayList<Ciudad> ciudadesPorRecorrer) {
		Ciudad ultima = ciudadesPorRecorrer.get(CANTIDAD_DE_CIUDADES_POR_RECORRER - 1);
		ultima.esconderAlLadron();
	}	
		
	private void setearPistasDeLaCiudadSiguiente(ArrayList<Ciudad> ciudadesPorRecorrer, ArrayList<ArrayList<Pista>> pistasDeLaCiudadesPorRecorrer) {	
		for (int i = 0; i < CANTIDAD_DE_CIUDADES_POR_RECORRER; i++) {
			Ciudad ciudadActual = ciudadesPorRecorrer.get(i);

			Edificio edificioEconomicoActual = new Edificio();
			Edificio edificioTransporteActual = new Edificio();
			Edificio edificioCulturalActual = new Edificio();

			if (i + 1 < CANTIDAD_DE_CIUDADES_POR_RECORRER) {
				ArrayList<Pista> pistasDeLaCiudadSiguiente = pistasDeLaCiudadesPorRecorrer.get(i + 1);

				edificioEconomicoActual.setPistas(pistasDeLaCiudadSiguiente.get(0), pistasDeLaCiudadSiguiente.get(1), pistasDeLaCiudadSiguiente.get(2));
				edificioTransporteActual.setPistas(pistasDeLaCiudadSiguiente.get(3), pistasDeLaCiudadSiguiente.get(4), pistasDeLaCiudadSiguiente.get(5));
				edificioCulturalActual.setPistas(pistasDeLaCiudadSiguiente.get(6), pistasDeLaCiudadSiguiente.get(7), pistasDeLaCiudadSiguiente.get(8));
			} else {
				Pista pistaElLadronEstaCerca = new Pista(PISTA_ESTA_CERCA_EL_LADRON);
				edificioEconomicoActual.setPistas(pistaElLadronEstaCerca, pistaElLadronEstaCerca, pistaElLadronEstaCerca);
				edificioTransporteActual.setPistas(pistaElLadronEstaCerca, pistaElLadronEstaCerca, pistaElLadronEstaCerca);
				edificioCulturalActual.setPistas(pistaElLadronEstaCerca, pistaElLadronEstaCerca, pistaElLadronEstaCerca);
			}
			ciudadActual.setEdificioEconomia(edificioEconomicoActual);
			ciudadActual.setEdificioTransporte(edificioTransporteActual);
			ciudadActual.setEdificioCultural(edificioCulturalActual);
		}
	}
	
	private void setearPistasDelLadronBuscado(Ladron buscado, ArrayList<Ciudad> ciudadesPorRecorrer) {
		Ciudad ciudad = ciudadesPorRecorrer.get(0);
		Edificio edificio = ciudad.getEdificioCultural();
		edificio.setPistaLadron(buscado.generarUnaPistaSobreElPelo());
		
		ciudad = ciudadesPorRecorrer.get(1);
		edificio = ciudad.getEdificioTransporte();
		edificio.setPistaLadron(buscado.generarUnaPistaSobreElHobby());
		
		ciudad = ciudadesPorRecorrer.get(2);
		edificio = ciudad.getEdificioTransporte();
		edificio.setPistaLadron(buscado.generarUnaPistaSobreElAuto());
		
		ciudad = ciudadesPorRecorrer.get(4);
		edificio = ciudad.getEdificioEconomia();
		edificio.setPistaLadron(buscado.generarUnaPistaSobreLaMarcaPersonal());
	}
	
	private void seleccionarCiudadDondeHierenAlPolicia(ArrayList<Ciudad> ciudadesPorRecorrer) {
		Random rand = new Random();
		int posicionRandom = rand.nextInt(this.ciudades.size());
		Ciudad ciudad = ciudadesPorRecorrer.get(posicionRandom);
		ciudad.setHierenAlPolicia();
	}
	
	/***********************************************************************************************/
	/*                            PARA TESTEAR COMO SE LEE EL ARCHIVO                             */
	/***********************************************************************************************/
	public ArrayList<Ciudad> getCiudades() {
		return this.ciudades;
	}

	public ArrayList<ArrayList<Pista>> getPistasPorCiudad() {
		return this.pistasDeLasCiudades;
	}
	
	public int estoyLeyendoTodasLasCiudades()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		File archivo = new File(NOMBRE_ARCHIVO_INFO_CIUDADES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		return doc.getElementsByTagName("Ciudad").getLength();
	}

	public String leoElNombreDeLaPrimerCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		File archivo = new File(NOMBRE_ARCHIVO_INFO_CIUDADES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		Element elementoCiudad = (Element)doc.getElementsByTagName("Ciudad").item(0);
		return elementoCiudad.getAttribute("Nombre");
	}

	public String leoLaCoordenadaXDeLaPrimerCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		File archivo = new File(NOMBRE_ARCHIVO_INFO_CIUDADES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		Element elementoCiudad = (Element)doc.getElementsByTagName("Ciudad").item(0);
		return elementoCiudad.getAttribute("CoordenadaX");
	}

	public double leoLaCoordenadaXDeLaPrimerCiudadYLaPasoADouble()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		File archivo = new File(NOMBRE_ARCHIVO_INFO_CIUDADES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		Element elementoCiudad = (Element)doc.getElementsByTagName("Ciudad").item(0);
		String coordenadaX = elementoCiudad.getAttribute("CoordenadaX");
		return Double.parseDouble(coordenadaX);
	}

	public String leoLaCoordenadaYDeLaPrimerCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		File archivo = new File(NOMBRE_ARCHIVO_INFO_CIUDADES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		Element elementoCiudad = (Element)doc.getElementsByTagName("Ciudad").item(0);
		return elementoCiudad.getAttribute("CoordenadaY");
	}

	public double leoLaCoordenadaYDeLaPrimerCiudadYLaPasoADouble()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		File archivo = new File(NOMBRE_ARCHIVO_INFO_CIUDADES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		Element elementoCiudad = (Element)doc.getElementsByTagName("Ciudad").item(0);
		String coordenadaY = elementoCiudad.getAttribute("CoordenadaY");
		return Double.parseDouble(coordenadaY);
	}

	public Ciudad puedoInstanciarUnaCiudadConElNombre()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		File archivo = new File(NOMBRE_ARCHIVO_INFO_CIUDADES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		Element elementoCiudad = (Element)doc.getElementsByTagName("Ciudad").item(0);
		String nombre = elementoCiudad.getAttribute("Nombre");
		Ciudad ciudad = new Ciudad(nombre, new Coordenada(1.0, 2.0));
		return ciudad;
	}

	public int estoyLeyendoTodasLasPistasDeUnaCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		File archivo = new File(NOMBRE_ARCHIVO_INFO_CIUDADES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		Element elementoCiudad = (Element)doc.getElementsByTagName("Ciudad").item(0);

		return ( elementoCiudad.getElementsByTagName("Pista") ).getLength();
	}
}