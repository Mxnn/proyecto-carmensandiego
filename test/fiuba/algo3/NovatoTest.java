package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class NovatoTest {
    @Test
    public void pedirPistaDevuelveLaPistaDeDificultadFacil() {
        Novato novato = new Novato();
        Edificio edificio = new Edificio("Aeropuerto");
        Pista pistaFacil = new Pista("PF");

        edificio.setPistas(pistaFacil, new Pista("PI"), new Pista("PD"));

        Assert.assertEquals(novato.pedirPista(edificio), pistaFacil.getPista());
    }

    @Test
    public void calcularTiempoDeViajeCalculaElViajeConLaVelocidadCorrecta() {
        Novato novato = new Novato();

        Assert.assertEquals(novato.calcularTiempoDeViaje(900.0), 1);
    }
}
