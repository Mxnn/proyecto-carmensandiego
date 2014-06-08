package fiuba.algo3;

public class Sargento implements Rango{

	private int velocidad;

	public Sargento(){
        this.velocidad = 1500;
	}
	public int calcularTiempoDeViaje (double distancia){
		return (int) (distancia/this.velocidad);
	}

    public String pedirPista(Edificio edificio) {
        return edificio.getPista(this);
    }
}
