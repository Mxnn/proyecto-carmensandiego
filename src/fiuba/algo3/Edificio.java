package fiuba.algo3;

public class Edificio {
    private String nombre;
    private Pista pistaDificultadFacil;
    private Pista pistaDificultadIntermedia;
    private Pista pistaDificultadDificil;

    public Edificio(String nombre) {
        this.nombre = nombre;
    }

    public void setPistas(Pista unaPistaDificultadFacil, Pista unaPistaDificultadIntermedia, Pista unaPistaDificultadDificil) {
        this.pistaDificultadFacil = unaPistaDificultadFacil;
        this.pistaDificultadIntermedia = unaPistaDificultadIntermedia;
        this.pistaDificultadDificil = unaPistaDificultadDificil;
    }

    public String getPista(Novato novato) {
        return this.pistaDificultadFacil.getPista();
    }
    public String getPista(Detective detective) {
        return this.pistaDificultadIntermedia.getPista();
    }
    public String getPista(Investigador investigador) {
        return this.pistaDificultadIntermedia.getPista();
    }
    public String getPista(Sargento sargento) {
        return this.pistaDificultadDificil.getPista();
    }
}
