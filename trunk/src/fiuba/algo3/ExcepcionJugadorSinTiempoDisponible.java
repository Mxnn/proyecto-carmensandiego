package fiuba.algo3;

public class ExcepcionJugadorSinTiempoDisponible extends Exception {
    public ExcepcionJugadorSinTiempoDisponible() {
        super("El jugador se quedo sin tiempo");
    }
}
