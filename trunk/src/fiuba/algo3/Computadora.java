package fiuba.algo3;

import java.util.ArrayList;

public class Computadora {
	Ladron buscado;
	ArrayList<Ladron> sospechosos;
	
	public Computadora(Ladron buscado) {
		this.buscado = buscado;
		sospechosos = new ArrayList();
		sospechosos.add(buscado);
	}
	
	public void setSospechoso(Ladron ladron) {
		sospechosos.add(ladron);
	}
	
	public ArrayList<Ladron> getSospechosos() {
		return sospechosos;
	}
	
	public void filtrarCaracteristica(Ladron.Sexo sexo) {
		ArrayList<Ladron> sospechososFiltrados = new ArrayList();
		
		int cantidadSospechosos = sospechosos.size();
		for (int i = 0; i < cantidadSospechosos ; i++) {
			Ladron ladron = sospechosos.get(i);
			if (ladron.tieneEstaCaracteristica(sexo)) {
				sospechososFiltrados.add(ladron);
			}
		}
		
		sospechosos = sospechososFiltrados;
	}
	
	public void filtrarCaracteristica(Ladron.Pelo pelo) {
		ArrayList<Ladron> sospechososFiltrados = new ArrayList();
		
		int cantidadSospechosos = sospechosos.size();
		for (int i = 0; i < cantidadSospechosos ; i++) {
			Ladron ladron = sospechosos.get(i);
			if (ladron.tieneEstaCaracteristica(pelo)) {
				sospechososFiltrados.add(ladron);
			}
		}
		
		sospechosos = sospechososFiltrados;
	}
	
	public void filtrarCaracteristica(Ladron.Hobby hobby) {
		ArrayList<Ladron> sospechososFiltrados = new ArrayList();
		
		int cantidadSospechosos = sospechosos.size();
		for (int i = 0; i < cantidadSospechosos ; i++) {
			Ladron ladron = sospechosos.get(i);
			if (ladron.tieneEstaCaracteristica(hobby)) {
				sospechososFiltrados.add(ladron);
			}
		}
		
		sospechosos = sospechososFiltrados;
	}
	
	public void filtrarCaracteristica(Ladron.Auto auto) {
		ArrayList<Ladron> sospechososFiltrados = new ArrayList();
		
		int cantidadSospechosos = sospechosos.size();
		for (int i = 0; i < cantidadSospechosos ; i++) {
			Ladron ladron = sospechosos.get(i);
			if (ladron.tieneEstaCaracteristica(auto)) {
				sospechososFiltrados.add(ladron);
			}
		}
		
		sospechosos = sospechososFiltrados;
	}
	
	public void filtrarCaracteristica(Ladron.MarcaPersonal marcaPersonal) {
		ArrayList<Ladron> sospechososFiltrados = new ArrayList();
		
		int cantidadSospechosos = sospechosos.size();
		for (int i = 0; i < cantidadSospechosos ; i++) {
			Ladron ladron = sospechosos.get(i);
			if (ladron.tieneEstaCaracteristica(marcaPersonal)) {
				sospechososFiltrados.add(ladron);
			}
		}
		
		sospechosos = sospechososFiltrados;
	}
	
	public boolean puedoEmitirOrdenDeArresto() {
		return (sospechosos.size() == 1) && (sospechosos.get(0) == buscado);
	}
}