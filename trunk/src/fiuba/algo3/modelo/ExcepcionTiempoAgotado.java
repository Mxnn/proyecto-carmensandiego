package fiuba.algo3.modelo;

public class ExcepcionTiempoAgotado extends Exception {
    public ExcepcionTiempoAgotado() {
        super("El jugador se quedo sin tiempo");
    }
}
