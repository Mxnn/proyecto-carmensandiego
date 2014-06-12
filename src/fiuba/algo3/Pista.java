package fiuba.algo3;

public class Pista {
	public static final String PISTA_POR_DEFECTO = "No se nada sobre ese sujeto.";
	
	private String pista;

	public Pista() {
		this.pista = PISTA_POR_DEFECTO;
	}
	
    public Pista(String pista) {
        this.pista = pista;
    }

    public String getPista() {
        return this.pista;
    }
}
