package fiuba.algo3;

import java.util.ArrayList;

public class Computadora {
	private Ladron sospechosoBuscado;
	private ArrayList<Ladron> sospechosos;
    private Ladron sospechosoFiltrado;
	
	public Computadora(Ladron buscado) {
		this.sospechosoBuscado = buscado;
		this.sospechosos = new ArrayList<Ladron>();
		this.sospechosos.add(buscado);
	}
	
	public void setSospechoso(Ladron ladron) {
		this.sospechosos.add(ladron);
	}

    private void filtrarSospechososPor(Ladron.Sexo sexo, Ladron.Pelo pelo, Ladron.Hobby hobby, Ladron.Auto auto, Ladron.MarcaPersonal marcaPersonal) {
        this.sospechosoFiltrado = null;
        ArrayList<Ladron> temp = new ArrayList<Ladron>();
        for(Ladron ladron: this.sospechosos) {
            if (ladron.tieneEstaCaracteristica(sexo) &&
                ladron.tieneEstaCaracteristica(pelo) &&
                ladron.tieneEstaCaracteristica(hobby) &&
                ladron.tieneEstaCaracteristica(auto) &&
                ladron.tieneEstaCaracteristica(marcaPersonal) ) {
                temp.add(ladron);
            }
        }

        if (temp.size() == 1) {
            this.sospechosoFiltrado = temp.get(0);
        }
    }

    public boolean filtrarLadron(Ladron.Sexo sexo, Ladron.Pelo pelo, Ladron.Hobby hobby, Ladron.Auto auto, Ladron.MarcaPersonal marcaPersonal) {
        filtrarSospechososPor(sexo, pelo, hobby, auto, marcaPersonal);

        return (this.sospechosoFiltrado == this.sospechosoBuscado);
    }
}