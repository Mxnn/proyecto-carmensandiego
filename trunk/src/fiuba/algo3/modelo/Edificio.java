package fiuba.algo3.modelo;

public class Edificio {
    private Pista pistaNivelFacil;
    private Pista pistaNivelIntermedia;
    private Pista pistaNivelDificil;

    public Edificio() {
		this.pistaNivelFacil = new Pista();
		this.pistaNivelIntermedia = new Pista();
		this.pistaNivelDificil = new Pista();
    }

    public void setPistas(Pista unaPistaNivelFacil, Pista unaPistaNivelIntermedia, Pista unaPistaNivelDificil) {
        this.pistaNivelFacil = unaPistaNivelFacil;
        this.pistaNivelIntermedia = unaPistaNivelIntermedia;
        this.pistaNivelDificil = unaPistaNivelDificil;
    }
    
    public void setPistaLadron(String pista){
    	pistaNivelFacil.setPistaLadron(pista);
    	pistaNivelIntermedia.setPistaLadron(pista);
    	pistaNivelDificil.setPistaLadron(pista);
    }
    public String getPista(Novato novato) {
        return this.pistaNivelFacil.getPista();
    }
    public String getPista(Detective detective) {
        return this.pistaNivelIntermedia.getPista();
    }
    public String getPista(Investigador investigador) {
        return this.pistaNivelIntermedia.getPista();
    }
    public String getPista(Sargento sargento) {
        return this.pistaNivelDificil.getPista();
    }
}
