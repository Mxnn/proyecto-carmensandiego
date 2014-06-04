package fiuba.algo3;

public class Sargento implements Rango{

	private int velosidad;

	public Sargento(){
		velosidad=1500;
	}
	public int calcularTiempoDeViaje (double distancia){
		return (int) (distancia/ velosidad);

	}

    public void setDificultadPista(Pista pista) {
        pista.setDificultadDificil();
    }
}
