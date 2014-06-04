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
    public String getFacil() {
        return this.facil;
    }

    public String getIntermedio() {
        return this.intermedio;
    }

    public String getDificil() {
        return this.dificil;
    }
}
