package fiuba.algo3;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ListaDeCiudades {

    private ArrayList<Ciudad> ciudades;


	public ListaDeCiudades() {

        ciudades= new ArrayList<Ciudad>();

	}
	
	public void  add (Ciudad ciudad){
		ciudades.add (ciudad);
		
	}
	public Ciudad  get(int i){
		return ciudades.get (i);
		
	}	
	public static void hidratar(Document doc, ArrayList <String>NombresDeCiudadesVisitadasPorDelicuente) {
	// tiene q devovler la lista de ciudades lo pongo asi para q ande
		ListaDeCiudades listaDeCiudadesVisitadasPorDelicuente= new ListaDeCiudades();
		Element elementoListaDeTodasLasciudades=(Element)doc.getElementsByTagName("TODASLASCIUDADES").item(0);
		Element elementoJugadores = (Element)doc.getElementsByTagName("Ciudad").item(0);		
		for(int i=0; i< elementoJugadores.getChildNodes().getLength(); i++) {
			Ciudad ciudad = Ciudad.hidratar(elementoJugadores.getChildNodes().item(i));
			if (i-1 != elementoJugadores.getChildNodes().getLength()){
				
				Element elementoPista = (Element)doc.getElementsByTagName("Pista").item(0);	
				ArrayList <Pista> listaDePistas= new ArrayList <Pista> ();
				for(int j=0; j< elementoPista.getChildNodes().getLength(); j++) {
					listaDePistas.add (Pista.hidratar(elementoPista.getChildNodes().item(i)));
				}
			}
		}
	}
}
				/*
				for(int j=0; j< elementoPista.getChildNodes().getLength(); j++) {
					if (i<3){
						}
					else if (i<6){
					}
					else {
						
					

	}	
	
}*/