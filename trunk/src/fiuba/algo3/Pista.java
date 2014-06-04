package fiuba.algo3;

public class Pista {
	private String facil;
	private String intermedio;
	private String dificil;
	private String pistaBuscada;

	public Pista(String facil, String intermedio, String dificil){
		this.facil = facil;
		this.intermedio = intermedio;
		this.dificil = dificil;
	}

	// GETTERS:

    public String obtenerPista(){
        return pistaBuscada;
    }

    public void setDificultadFacil() {
        pistaBuscada=this.facil;
    }
    public void setDificultadIntermedio() {
        pistaBuscada=this.intermedio;
    }
    public void setDificultadDificil() {
        pistaBuscada=this.dificil;
    }
}
