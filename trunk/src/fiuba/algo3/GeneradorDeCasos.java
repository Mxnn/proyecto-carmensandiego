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
		ciudadInicial.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a drachmas."), new Pista("Me consulto si convenia invertir en la industria de los olivos."), new Pista("Estaba pensando invertir en los higos."));
		ciudadInicial.getEdificioTransporte().setPistas(new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera azul y blanca."), new Pista("Me pregunto sobre algun tour para visitar el mar Egeo."), new Pista("Me pregunto sobre algun tour para conocer las montanias pindo."));
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
		ciudad3.getEdificioTransporte().setPistas(new Pista("El tomo un avion cuya ala estaba adornada por una bandera roja, amarilla y negra."), new Pista("Me dijo que iba a un pais donde se hablaba ingles, tok pisin y motu ."), new Pista("El dijo que iba a una barbacoa con el primer ministro."));
		ciudad3.getEdificioCultural().setPistas(new Pista("Me pidio un libro sobre volcanes."), new Pista("El comento que queria escalar el monte Wilthalm."), new Pista("Me pidio un libro del monte Karkar."));
		listaDeCiudades.add (ciudad3);

		Ciudad ciudad4= new Ciudad("Port Moresby", new Coordenada(-4627.0, -1243.0));
		ciudad4.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a Rupias"), new Pista("Queria invertir en las citronella"), new Pista("Me consulto cuanto el saldria algun artefacto de los Veddas"));
		ciudad4.getEdificioTransporte().setPistas(new Pista("Se marcho hacia Asia Meriodional."), new Pista("Fue a un pais donde se habla cingales y tamil"), new Pista("Se marcho en un vehiculo que llevaba una bandera adornada con un leon dorado"));
		ciudad4.getEdificioCultural().setPistas(new Pista("Estaba investigando la cultura y la mitologia cingaleses"), new Pista("Estaba buscando articulos sobre las tensiones entre tamiles y cingaleses"), new Pista("Me comento que fue a un pais donde habia division religiosa pero la mayoria eran budistas."));
		listaDeCiudades.add (ciudad4);

		Ciudad ciudad5= new Ciudad("Colombo", new Coordenada(-1437.0, 6740.0));
		ciudad5.getEdificioEconomia().setPistas(new Pista("Solo se que algo muy extranio esta pasando en la ciudad."), new Pista("Solo se que algo muy extranio esta pasando en la ciudad."), new Pista("Solo se que algo muy extranio esta pasando en la ciudad."));
		ciudad5.getEdificioTransporte().setPistas(new Pista("Solo se que algo muy extranio esta pasando en la ciudad."), new Pista("Solo se que algo muy extranio esta pasando en la ciudad."), new Pista("Solo se que algo muy extranio esta pasando en la ciudad."));
		ciudad5.getEdificioCultural().setPistas(new Pista("Solo se que algo muy extranio esta pasando en la ciudad."), new Pista("Solo se que algo muy extranio esta pasando en la ciudad."), new Pista("Solo se que algo muy extranio esta pasando en la ciudad."));
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
	public void crearCasoDePrueba2() throws ParserConfigurationException, TransformerException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		ArrayList<Ciudad> listaDeCiudades=new ArrayList<Ciudad>();

        Ciudad ciudadInicial= new Ciudad("Colombo", new Coordenada(-1437, 6740.0));
        ciudadInicial.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a dolares."), new Pista("Fue a el pais mas avanzado en armamento militar en el Sudeste de Asia"), new Pista("Queria invertir en la indutria del caucho."));
        ciudadInicial.getEdificioTransporte().setPistas(new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera roja y blanca."), new Pista("Me comento que al pais al que fue se habla en Inglés, Malayo, Mandarín, Tamil"), new Pista("Estaba investigando sobre el parlamento de este pais."));
        ciudadInicial.getEdificioCultural().setPistas(new Pista("Dijo que queria tirarse de cabeza en el puerto Calder."), new Pista("Me pregunto donde podia conseguir un documental sobre el pez piedra."), new Pista("Estaba leyendo sobre las ex colonias britanicas"));
        listaDeCiudades.add (ciudadInicial);

        Ciudad ciudad1= new Ciudad("Syngapur", new Coordenada(7506.0, -2540.0));
        ciudad1.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a Dolares"), new Pista("Queria saber si el mercado de la lana tenia futuro."), new Pista("Me comento que hay un gran distrinto de negocios en la proxima ciudad que iba a visitar."));
        ciudad1.getEdificioTransporte().setPistas(new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera azul y roja con estrellas blancas."), new Pista("Pidio un diccionario Ingles."), new Pista("Estaba investigando sobre las ex colonias de Reino Unido"));
        ciudad1.getEdificioCultural().setPistas(new Pista("Queria dar la vuelta a una isla-continente en baco"), new Pista("Quiso comprar un tour para ir a la casa de la opera."), new Pista("Me dijo que iba a ver por primera vez a un Koala."));
        listaDeCiudades.add (ciudad1);

        Ciudad ciudad2= new Ciudad("Sydney", new Coordenada(7841.0, 1486.0));
        ciudad2.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a Rublo"), new Pista("Queria comprar un tour para ir a los Montes Urales."), new Pista("Queria comprar un tour para ir al Lago Ladoga"));
        ciudad2.getEdificioTransporte().setPistas(new Pista("Tomo un vehiculo que tenia una bandera roja."), new Pista("Quiso comprar un diccionario Ruso"), new Pista("Estaba investigando sobre la Republica federal semiparlamentaria."));
        ciudad2.getEdificioCultural().setPistas(new Pista("Se ha informado sobre las visitas con guia al Kremlin"), new Pista("Me comento que iba a ir al pais mas grande del mundo."), new Pista("Me pidio un biblografia de Ivan el terrible."));
        listaDeCiudades.add (ciudad2);

        Ciudad ciudad3= new Ciudad("Moscu", new Coordenada(8450.0, 6432.0));
        ciudad3.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a dinares"), new Pista("Queria invertir en la industria del petroleo."), new Pista("Compro un tour para recorrer el rio Tigris"));
        ciudad3.getEdificioTransporte().setPistas(new Pista("Tomo un vehiculo que tenia una bandera roja, blanca y negra."), new Pista("Compro un diccionario arabe y kurdo."), new Pista("Estaba invetigando sobre la Republica Federal Parlamenaria"));
        ciudad3.getEdificioCultural().setPistas(new Pista("Comento que tenia puesto ropa especial para ir al desierto sirio."), new Pista("Estaba emosionado por ver el rio Eufrates"), new Pista("Fue a visitar unas ruinas de los sumerias."));
        listaDeCiudades.add (ciudad3);

        Ciudad ciudad4= new Ciudad("Badgad", new Coordenada(6427.0, -1243.0));
        ciudad4.getEdificioEconomia().setPistas(new Pista("Cambio su dinero a Soles."), new Pista("Queria saber si daria fruto invertir en la agricultura."), new Pista("Queria saber si daria fruto invertir en la mineria."));
        ciudad4.getEdificioTransporte().setPistas(new Pista("Tomo un vehiculo que tenia una bandera roja y blanca."), new Pista("Comento que iba a asistir en una recepcion ofrecida por el presidente"), new Pista("Dijo que iba a ir a un pais que era un ex colonia española."));
        ciudad4.getEdificioCultural().setPistas(new Pista("Dijo que iba a visitar el Machu Picchu"), new Pista("Estaba viendo un diccionario de Español."), new Pista("Comento que tenia puesto ropa especial para ir a las Pirámides de Caral."));
        listaDeCiudades.add (ciudad4);

        Ciudad ciudad5= new Ciudad("Lima", new Coordenada(-3570, -4714.0));
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
