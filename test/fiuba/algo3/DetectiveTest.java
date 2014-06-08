package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class DetectiveTest {
    @Test
    public void pedirPistaDevuelveLaPistaDeDificultadIntermedia() {
        Detective detective = new Detective();
        Edificio edificio = new Edificio("Aeropuerto");
        Pista pistaNivelIntermedia = new Pista("PI");

        edificio.setPistas(new Pista("PF"), pistaNivelIntermedia, new Pista("PD"));

        Assert.assertEquals(detective.pedirPista(edificio), pistaNivelIntermedia.getPista());
    }

    @Test
    public void calcularTiempoDeViajeCalculaElViajeConLaVelocidadCorrecta() {
        Detective detective = new Detective();

        Assert.assertEquals(detective.calcularTiempoDeViaje(1100.0), 1);
    }
}
