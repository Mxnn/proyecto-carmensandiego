package fiuba.algo3;

public class Edificio {
    private Pista pista;

    public void setPista(Pista pista) {
        this.pista = pista;
    }
    public String getPistaFacil() {
        return this.pista.getFacil();
    }
    public String getPistaIntermedio() {
        return this.pista.getIntermedio();
    }
    public String getPistaDificil() {
        return this.pista.getDificil();
    }
}
