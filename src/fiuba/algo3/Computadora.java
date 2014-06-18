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
		this.sospechososFiltrados.add(ladronBuscado);
		this.ordenDeArrestoEmitida = false;
	}

	//SETTERS:
	public void setSospechoso(Ladron ladron) {
		this.sospechosos.add(ladron);
		this.sospechososFiltrados.add(ladron);
	}

	public boolean setCaracteristicaDelLadron(Ladron.Sexo sexo) {
		if (!this.ordenDeArrestoEmitida) {
			this.sexoDelLadron = sexo;
			filtrarSospechosos();
			return true;
		}
		return false;
	}

	public boolean setCaracteristicaDelLadron(Ladron.Pelo pelo) {
		if (!this.ordenDeArrestoEmitida) {
			this.peloDelLadron = pelo;
			filtrarSospechosos();
			return true;
		}
        return false;
	}

    public boolean setCaracteristicaDelLadron(Ladron.Hobby hobby) {
		if (!this.ordenDeArrestoEmitida) {
			this.hobbyDelLadron = hobby;
			filtrarSospechosos();
			return true;
		}
        return false;
	}

    public boolean setCaracteristicaDelLadron(Ladron.Auto auto) {
		if (!this.ordenDeArrestoEmitida) {
			this.autoDelLadron = auto;
			filtrarSospechosos();
			return true;
		}
        return false;
	}

    public boolean setCaracteristicaDelLadron(Ladron.MarcaPersonal marcaPersonal) {
		if (!this.ordenDeArrestoEmitida) {
			this.marcaPersonalDelLadron = marcaPersonal;
			filtrarSospechosos();
			return true;
		}
        return false;
	}
	
	public void emitirOrdenDeArresto() {
		this.ordenDeArrestoEmitida = true;
	}
	
	//GETTERS:
    public ArrayList<Ladron> getSospechososFiltrados() {
        return this.sospechososFiltrados;
    }

    public boolean hayUnSoloSospechoso() {
        return sospechososFiltrados.size() == 1;
    }
	
	public boolean ordenDeArrestoEmitidaContraLadronCorrecto() throws ExcepcionOrdenDeArrestoNoEmitida {
		if (this.ordenDeArrestoEmitida) {
			return ladronBuscado == sospechososFiltrados.get(0);
		}
		throw new ExcepcionOrdenDeArrestoNoEmitida();
	}
	
	public Ladron getLadronEncontrado() throws ExcepcionOrdenDeArrestoNoEmitida {
		if (this.ordenDeArrestoEmitida) {
			return this.sospechososFiltrados.get(0);
		}
		throw new ExcepcionOrdenDeArrestoNoEmitida();
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
