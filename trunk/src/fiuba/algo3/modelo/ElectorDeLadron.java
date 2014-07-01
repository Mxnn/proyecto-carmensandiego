package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

import fiuba.algo3.modelo.Ladron.Auto;
import fiuba.algo3.modelo.Ladron.Hobby;
import fiuba.algo3.modelo.Ladron.MarcaPersonal;
import fiuba.algo3.modelo.Ladron.Pelo;
import fiuba.algo3.modelo.Ladron.Sexo;

public class ElectorDeLadron {
	public final static String NOMBRE_ARCHIVO_INFO_LADRONES = "archivosXML/CaracteristicasLadrones.xml";

	private ArrayList<Ladron> listaDeLadrones;
	
	public ElectorDeLadron() {
		listaDeLadrones = new ArrayList<Ladron>();
	}
	
	public void leerXMLDeLadrones()	
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		
		File archivo = new File(NOMBRE_ARCHIVO_INFO_LADRONES);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);

		NodeList listaNodosLadrones = doc.getElementsByTagName("Ladron");

		for (int i = 0; i < listaNodosLadrones.getLength(); i++) {
			Element elementoLadron = (Element)listaNodosLadrones.item(i);

			String nombre = elementoLadron.getAttribute("Nombre");		
			NodeList listaNodosCaracteristicas = elementoLadron.getElementsByTagName("Caracteristica");

			Element elementoCaracteristica = (Element)listaNodosCaracteristicas.item(0);		
			Sexo sexo = Sexo.valueOf(elementoCaracteristica.getAttribute("Sexo"));
			
			elementoCaracteristica = (Element)listaNodosCaracteristicas.item(1);		
			Pelo pelo = Pelo.valueOf(elementoCaracteristica.getAttribute("Pelo"));
			
			elementoCaracteristica = (Element)listaNodosCaracteristicas.item(2);		
			Hobby hobby = Hobby.valueOf(elementoCaracteristica.getAttribute("Hobby"));
			
			elementoCaracteristica = (Element)listaNodosCaracteristicas.item(3);		
			Auto auto = Auto.valueOf(elementoCaracteristica.getAttribute("Auto"));
			
			elementoCaracteristica = (Element)listaNodosCaracteristicas.item(4);
			MarcaPersonal marcaPersonal = MarcaPersonal.valueOf(elementoCaracteristica.getAttribute("MarcaPersonal"));
			
			this.listaDeLadrones.add(new Ladron(nombre, sexo, pelo, hobby, auto, marcaPersonal));
		}
	}
	
	public ArrayList<Ladron> getListaDeLadrones() {
		return listaDeLadrones;
	}
	
	public Ladron generarUnLadronBuscado() {
		Random rand = new Random();
		int posicion = rand.nextInt(this.listaDeLadrones.size());
		Ladron buscado = listaDeLadrones.get(posicion);
		return buscado;
	}
}
		