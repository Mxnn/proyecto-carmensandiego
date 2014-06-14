package fiuba.algo3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
import org.xml.sax.SAXException;


public class GeneradorDeCasos {


	public void crearCasoDePrueba1() throws ParserConfigurationException, TransformerException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		ArrayList<Ciudad> listaDeCiudades=new ArrayList<Ciudad>();

		Ciudad ciudadInicial= new Ciudad("Buenos Aires", new Coordenada(-3000.0, -9000.0));
		ciudadInicial.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a drachmas."), new Pista("Me consulto si convenia invertir en la insustria de los olivos."), new Pista("Estaba pensando invertir en los higos."));
		ciudadInicial.getEdificioTransporte().setPistas(new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera azul y blanca."), new Pista("Me pregunto sobre algun tour para visitar el mar Egeo."), new Pista("Me pregunto sobre algun tour para conocer las montañas pindo."));
		ciudadInicial.getEdificioCultural().setPistas(new Pista("Pidio un libro sobre los espartanos."), new Pista("Me dijo que estaba muy interesado en Platon."), new Pista("Me pregunto si tenia algun libro sobre restos arqueologicos"));
		listaDeCiudades.add (ciudadInicial);

		Ciudad ciudad1= new Ciudad("Atenas", new Coordenada(4500.0, -3540.0));
		ciudad1.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a liras"), new Pista("Menciono que queria adquirir el monopolio del mecado del calzado."), new Pista("Me pregutno cuanto el costaria visitar el volcan etna."));
		ciudad1.getEdificioTransporte().setPistas(new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera verde, blanca y roja."), new Pista("Pidio un diccionario Italiano."), new Pista("Fua a un pais en el que estan gobernados por un presidente."));
		ciudad1.getEdificioCultural().setPistas(new Pista("Estaba interesado en el Coliseo."), new Pista("Estaba mirando una pinturas renacentistas"), new Pista("Queria saber mas sobre una civilizacion antigua llamada etrusca"));
		listaDeCiudades.add (ciudad1);

		Ciudad ciudad2= new Ciudad("Roma", new Coordenada(7841.0, 1486.0));
		ciudad2.getEdificioEconomia().setPistas(new Pista("Fue a un pais muy criticado por su falsificacion de mercancias"), new Pista("Me comento que iba a ir a un pais que es la primera potencia comercial del mundo."), new Pista("Cambio su dinero a yuanes."));
		ciudad2.getEdificioTransporte().setPistas(new Pista("Se ha ido en un avion que llevaba una bandera roja"), new Pista("Estaba viendo un documental sobre los pandas gigantes."), new Pista("Estaba viendo un video sobre los juegos olimpicos del 2008."));
		ciudad2.getEdificioCultural().setPistas(new Pista("Comento que queria visitar la ciudad prohibida."), new Pista("El dijo que tenia ganas de pintar los montes de Kunlun."), new Pista("Me pregunto acerca de la dinastia Ming."));
		listaDeCiudades.add (ciudad2);

		Ciudad ciudad3= new Ciudad("Pekin", new Coordenada(1800.0, 8472.0));
		ciudad3.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a Kinas."), new Pista("Queria invertir en la industria del oro."), new Pista("Pregunto si tenia futuro invertir en mandioca."));
		ciudad3.getEdificioTransporte().setPistas(new Pista("El tomo un avion cuya ala estaba adornada por una bandera roja, amarilla y negra."), new Pista("Me dijo que iba a un pais donde se hablaba Inglés, tok pisin y motu ."), new Pista("El dijo que iba a una barbacoa con el primer ministro."));
		ciudad3.getEdificioCultural().setPistas(new Pista("Me pidio un libro sobre volcanes."), new Pista("El comento que queria escalar el monte Wilthalm."), new Pista("Me pidio un libro del monte Karkar."));
		listaDeCiudades.add (ciudad3);

		Ciudad ciudad4= new Ciudad("Port Moresby", new Coordenada(-4627.0, -1243.0));
		ciudad4.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a Rupias"), new Pista("Queria invertir en las citronella"), new Pista("Me consulto cuanto el saldria algun artefacto de los Veddas"));
		ciudad4.getEdificioTransporte().setPistas(new Pista("Se marcho hacia Asia Meriodional."), new Pista("Fue a un pais donde se habla Cingalés y tamil"), new Pista("Se marcho en un vehiculo que llevaba una bandera adornada con un leon dorado"));
		ciudad4.getEdificioCultural().setPistas(new Pista("Estaba investigando la cultura y la mitologia cingaleses"), new Pista("Estaba buscando articulos sobre las tensiones entre tamiles y cingaleses"), new Pista("Me comento que fue a un pais donde habia division religiosa pero la mayoria eran budistas."));
		listaDeCiudades.add (ciudad4);

		Ciudad ciudad5= new Ciudad("Colombo", new Coordenada(-1437, 6740.0));
		ciudad5.getEdificioEconomia().setPistas(new Pista("Solo se que algo muy extraño esta pasando en la ciudad."), new Pista("Solo se que algo muy extraño esta pasando en la ciudad."), new Pista("Solo se que algo muy extraño esta pasando en la ciudad."));
		ciudad5.getEdificioTransporte().setPistas(new Pista("Solo se que algo muy extraño esta pasando en la ciudad."), new Pista("Solo se que algo muy extraño esta pasando en la ciudad."), new Pista("Solo se que algo muy extraño esta pasando en la ciudad."));
		ciudad5.getEdificioCultural().setPistas(new Pista("Solo se que algo muy extraño esta pasando en la ciudad."), new Pista("Solo se que algo muy extraño esta pasando en la ciudad."), new Pista("Solo se que algo muy extraño esta pasando en la ciudad."));
		listaDeCiudades.add (ciudad5);

		/*
		for(int i=0; i< listaDeCiudades.size(); i++) {
			Element ciudadSerializada= listaDeCiudades.get(i).serializar(doc);
			Assert.assertNotNull(ciudadSerializada );
			doc.appendChild(ciudadSerializada);
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivoDestino = new File("C:\\Algoritmos3TpFinal\\archivoDeCasos1.xml");
		StreamResult result = new StreamResult(archivoDestino);
		transformer.transform(source, result);

		File archivo = new File("C:\\Algoritmos3TpFinal\\archivoDeCasos1.xml");
		Assert.assertTrue(archivo.exists());


		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();

		*/
	}


}
