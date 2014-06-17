package fiuba.algo3;

import java.util.ArrayList;

public class Computadora {
	private Ladron sospechosoBuscado;
	private ArrayList<Ladron> sospechosos;
    private Ladron.Sexo sexoDelLadron;
    private Ladron.Pelo peloDelLadron;
    private Ladron.Hobby hobbyDelLadron;
    private Ladron.Auto autoDelLadron;
    private Ladron.MarcaPersonal marcaPersonalDelLadron;

	public Computadora(Ladron buscado) {
		this.sospechosoBuscado = buscado;
		this.sospechosos = new ArrayList<Ladron>();
		this.sospechosos.add(buscado);
	}

	public void setSospechoso(Ladron ladron) {
		this.sospechosos.add(ladron);
	}

	public void setCaracteritica (Ladron.Sexo sexo){
        this.sexoDelLadron=sexo;
	}

	public void setCaracteritica (Ladron.Pelo pelo){
        this.peloDelLadron=pelo;
	}

    public void setCaracteritica (Ladron.Hobby hobby){
        this.hobbyDelLadron=hobby;
	}

    public void setCaracteritica (Ladron.Auto auto){
        this.autoDelLadron=auto;
	}

    public void setCaracteritica (Ladron.MarcaPersonal marcaPersonal){
        this.marcaPersonalDelLadron=marcaPersonal;
	}

    public  ArrayList<Ladron> obtenerSospechosos() {
        ArrayList<Ladron> temp = new ArrayList<Ladron>();
        for(Ladron ladron: this.sospechosos) {
            if ((sexoDelLadron==null || ladron.tieneEstaCaracteristica(sexoDelLadron)) &&
                (peloDelLadron==null ||  ladron.tieneEstaCaracteristica(peloDelLadron) )&&
                (hobbyDelLadron==null || ladron.tieneEstaCaracteristica(hobbyDelLadron)) &&
                (autoDelLadron==null || ladron.tieneEstaCaracteristica(autoDelLadron) )&&
                (marcaPersonalDelLadron==null || ladron.tieneEstaCaracteristica(marcaPersonalDelLadron) ) ){
                temp.add(ladron);
            }
        }

        return temp;
    }

    public boolean emitirOrdenDeArresto() {
        sospechosos=obtenerSospechosos();
        if (sospechosos.size() ==1){
          return (sospechosos.get(0) == this.sospechosoBuscado);
        }
        return false;

    }
}
