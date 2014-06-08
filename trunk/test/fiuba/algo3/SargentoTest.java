package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class SargentoTest {
    @Test
    public void pedirPistaDevuelveLaPistaDeDificultadDificil() {
        Sargento sargento = new Sargento();
        Edificio edificio = new Edificio("Aeropuerto");
        Pista pistaNivelDificil = new Pista("PD");

        edificio.setPistas(new Pista("PF"), new Pista("PI"), pistaNivelDificil);

        Assert.assertEquals(sargento.pedirPista(edificio), pistaNivelDificil.getPista());
    }

    @Test
    public void calcularTiempoDeViajeCalculaElViajeConLaVelocidadCorrecta() {
        Sargento sargento = new Sargento();

        Assert.assertEquals(sargento.calcularTiempoDeViaje(1500.0), 1);
    }
}
