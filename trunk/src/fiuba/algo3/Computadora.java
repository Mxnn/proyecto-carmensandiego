package fiuba.algo3;

import java.util.ArrayList;

public class Computadora {
    private Ladron ladronBuscado;
	private ArrayList<Ladron> sospechosos;
    private Ladron.Sexo sexoDelLadron;
    private Ladron.Pelo peloDelLadron;
    private Ladron.Hobby hobbyDelLadron;
    private Ladron.Auto autoDelLadron;
    private Ladron.MarcaPersonal marcaPersonalDelLadron;
    private ArrayList<Ladron> sospechososFiltrados;

	public Computadora(Ladron ladronBuscado) {
        this.ladronBuscado = ladronBuscado;
		this.sospechosos = new ArrayList<Ladron>();
        this.sospechosos.add(ladronBuscado);
        this.sexoDelLadron = null;
        this.peloDelLadron = null;
        this.hobbyDelLadron = null;
        this.autoDelLadron = null;
        this.marcaPersonalDelLadron = null;
        this.sospechososFiltrados = new ArrayList<Ladron>();
	}

	public void setSospechoso(Ladron ladron) {
		this.sospechosos.add(ladron);
	}

	public void setCaracteristicaDelLadron (Ladron.Sexo sexo){
        this.sexoDelLadron = sexo;
	}

	public void setCaracteristicaDelLadron (Ladron.Pelo pelo){
        this.peloDelLadron = pelo;
	}

    public void setCaracteristicaDelLadron (Ladron.Hobby hobby){
        this.hobbyDelLadron = hobby;
	}

    public void setCaracteristicaDelLadron (Ladron.Auto auto){
        this.autoDelLadron = auto;
	}

    public void setCaracteristicaDelLadron (Ladron.MarcaPersonal marcaPersonal){
        this.marcaPersonalDelLadron = marcaPersonal;
	}

    private boolean ladronCumpleConLosFiltros(Ladron ladron) {
        return (sexoDelLadron == null || ladron.tieneEstaCaracteristica(sexoDelLadron)) &&
                (peloDelLadron == null ||  ladron.tieneEstaCaracteristica(peloDelLadron) )&&
                (hobbyDelLadron == null || ladron.tieneEstaCaracteristica(hobbyDelLadron)) &&
                (autoDelLadron == null || ladron.tieneEstaCaracteristica(autoDelLadron) )&&
                (marcaPersonalDelLadron == null || ladron.tieneEstaCaracteristica(marcaPersonalDelLadron));
    }

    private void filtrarSospechosos() {
        this.sospechososFiltrados.clear();
        for(Ladron ladron: this.sospechosos) {
            if (ladronCumpleConLosFiltros(ladron)){
                this.sospechososFiltrados.add(ladron);
            }
        }
    }

    public ArrayList<Ladron> getSospechososFiltrados() {
        return this.sospechososFiltrados;
    }

    public boolean emitirOrdenDeArresto() {
        filtrarSospechosos();
        return (sospechososFiltrados.size() == 1 && sospechososFiltrados.get(0) == ladronBuscado);
    }
}
