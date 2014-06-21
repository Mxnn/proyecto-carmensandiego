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
	private boolean ordenDeArrestoEmitida;

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
		this.ordenDeArrestoEmitida = false;
	}

	//SETTERS:
	public void setSospechosos(ArrayList<Ladron> ladrones) {
		this.sospechosos = ladrones;
		this.sospechosos.add(this.ladronBuscado);
	}

	public void setCaracteristicaDelLadron(Ladron.Sexo sexo) {
		this.sexoDelLadron = sexo;
	}

	public void setCaracteristicaDelLadron(Ladron.Pelo pelo) {
		this.peloDelLadron = pelo;
	}

    public void setCaracteristicaDelLadron(Ladron.Hobby hobby) {
		this.hobbyDelLadron = hobby;
	}

    public void setCaracteristicaDelLadron(Ladron.Auto auto) {
		this.autoDelLadron = auto;
	}

    public void setCaracteristicaDelLadron(Ladron.MarcaPersonal marcaPersonal) {
		this.marcaPersonalDelLadron = marcaPersonal;
	}
	
	//GETTERS:
	public boolean ordenDeArrestoEmitidaContraLadronCorrecto() throws ExcepcionOrdenDeArrestoNoEmitida {
		if (this.ordenDeArrestoEmitida) {
			return ladronBuscado.tieneOrdenDeArresto();
		}
		throw new ExcepcionOrdenDeArrestoNoEmitida();
	}
	
	public Ladron getLadronBuscado() throws ExcepcionOrdenDeArrestoNoEmitida {
		if (this.ordenDeArrestoEmitida) {
			return this.ladronBuscado;
		}
		throw new ExcepcionOrdenDeArrestoNoEmitida();
	}
	
	public String emitirOrdenDeArresto() {
		filtrarSospechosos();
		if (this.sospechososFiltrados.size() == 1){	
			Ladron sospechosoAlQueEmitirOrden = this.sospechososFiltrados.get(0);
			sospechosoAlQueEmitirOrden.recibirOrdenDeArresto();
			this.ordenDeArrestoEmitida = true;
			return sospechosoAlQueEmitirOrden.getNombre();
		}
		return "";
	}
	
	//PRIVADOS:
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
}
