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
        
	public ArrayList<Ciudad> generarUnCaso() {
		limpiarCiudades();
		
		Random rand = new Random();
		ArrayList<Ciudad> ciudadesPorRecorrer = new ArrayList<Ciudad>();
		ArrayList<ArrayList<Pista>> pistasDeLaCiudadesPorRecorrer = new ArrayList<ArrayList<Pista>>();

                
		while (CANTIDAD_DE_CIUDADES_POR_RECORRER > ciudadesPorRecorrer.size()) {
			int posicion = rand.nextInt(ciudades.size());
			Ciudad ciudadAgregada=ciudades.get(posicion);
			if (!ciudadesPorRecorrer.contains(ciudadAgregada)){
				ciudadesPorRecorrer.add(ciudadAgregada);
				pistasDeLaCiudadesPorRecorrer.add(pistasDeLasCiudades.get(posicion));
			}
		}

		for (int i = 0; i < ciudadesPorRecorrer.size(); i++){
			Ciudad ciudadActual = ciudadesPorRecorrer.get(i);
            setearCiudadesConectadasPorRecorrer(ciudadActual, ciudadesPorRecorrer);

			Edificio EdificioEconomicoActual = ciudadActual.getEdificioEconomia();
			Edificio EdificioTransporteActual = ciudadActual.getEdificioTransporte();
			Edificio EdificioCulturalActual = ciudadActual.getEdificioCultural();

			if (i + 1 < ciudadesPorRecorrer.size()){
				ArrayList<Pista> pistasDeLaCiudadSiguiente = pistasDeLaCiudadesPorRecorrer.get(i+1);

				EdificioEconomicoActual.setPistas(pistasDeLaCiudadSiguiente.get(0), pistasDeLaCiudadSiguiente.get(1), pistasDeLaCiudadSiguiente.get(2));
				EdificioTransporteActual.setPistas(pistasDeLaCiudadSiguiente.get(3), pistasDeLaCiudadSiguiente.get(4), pistasDeLaCiudadSiguiente.get(5));
				EdificioCulturalActual.setPistas(pistasDeLaCiudadSiguiente.get(6), pistasDeLaCiudadSiguiente.get(7), pistasDeLaCiudadSiguiente.get(8));
			} else {
				Pista pistaElLadronEstaCerca = new Pista(PISTA_ESTA_CERCA_EL_LADRON);
				EdificioEconomicoActual.setPistas(pistaElLadronEstaCerca, pistaElLadronEstaCerca, pistaElLadronEstaCerca);
				EdificioTransporteActual.setPistas(pistaElLadronEstaCerca, pistaElLadronEstaCerca, pistaElLadronEstaCerca);
				EdificioCulturalActual.setPistas(pistaElLadronEstaCerca, pistaElLadronEstaCerca, pistaElLadronEstaCerca);
			}
		}
		for (Ciudad ciudad :ciudades){
                        
			if (!ciudadesPorRecorrer.contains(ciudad)){
				conectarCiudadesRandom(ciudad, ciudadesPorRecorrer);
			}
		}
		
		esconderAlLadron(ciudadesPorRecorrer);
		
		return ciudadesPorRecorrer;
	}

    public void setearCiudadesConectadasPorRecorrer(Ciudad ciudadActual, ArrayList<Ciudad> ciudadesPorRecorrer){
		int posicionCiudadActual= ciudadesPorRecorrer.indexOf(ciudadActual);
		if (posicionCiudadActual <=4){
        
			Ciudad ciudadPorAgregar=ciudadesPorRecorrer.get(posicionCiudadActual+1);
			ciudadActual.conectarCiudad( ciudadPorAgregar);
		}
		if (posicionCiudadActual >=1){
			Ciudad ciudadPorAgregar=ciudadesPorRecorrer.get(posicionCiudadActual-1);
			ciudadActual.conectarCiudad( ciudadPorAgregar);
		}
		conectarCiudadesRandom(ciudadActual,ciudadesPorRecorrer);
                
	}
    
    public void conectarCiudadesRandom(Ciudad ciudadActual ,ArrayList<Ciudad> ciudadesPorRecorrer){
		Random rand = new Random();
		while (ciudadActual.cantidadDeCiudadesConectadas() < 4){
		int posicionRandom = rand.nextInt(ciudades.size());
		Ciudad ciudadPorAgregar= ciudades.get(posicionRandom);
			if (!ciudadesPorRecorrer.contains(ciudadPorAgregar)){
				ciudadActual.conectarCiudad(ciudadPorAgregar);
                
			}
		}
    }
	
	private void limpiarCiudades() {
		for (Ciudad ciudad : this.ciudades) {
		ciudad.resetear();
		}
	}
	
	private void esconderAlLadron(ArrayList<Ciudad> ciudadesPorRecorrer) {
		Ciudad ultima = ciudadesPorRecorrer.get(CANTIDAD_DE_CIUDADES_POR_RECORRER - 1);
		ultima.esconderAlLadron();
	}
	
	private void elegirCiudadDondeHiereAlLadron(ArrayList<Ciudad> ciudadesPorRecorrer) {
		Random rand = new Random();
		int posicionRandom = rand.nextInt(ciudades.size());
		
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