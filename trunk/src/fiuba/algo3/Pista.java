package fiuba.algo3;

public class Pista {
	private String facil;
	private String intermedio;
	private String dificil;
	
	public Pista(String facil, String intermedio, String dificil){
		this.facil = facil;
		this.intermedio = intermedio;
		this.dificil = dificil;
	}
	
	// GETTERS:
	public String getPista(Novato rango) {
		return this.facil;
	}
	
	public String getPista(Detective rango) {
		return this.intermedio;
	}
	
	public String getPista(Investigador rango) {
		return this.dificil;
	}
	
	public String getPista(Sargento rango) {
		return this.dificil;
	}

    public String getPista(Rango rango) {
        return this.facil;
    }
}