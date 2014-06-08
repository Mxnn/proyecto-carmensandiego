package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class PoliciaTest {
    @Test
    public void unPoliciaIniciaConRangoNovatoPorDefecto() {
        Policia unPolicia = new Policia("Juan", new Ciudad("Praga", new Coordenada(3,5)));

        Assert.assertEquals(unPolicia.getRango().getClass(), Novato.class);
    }

    @Test
    public void unPoliciaIniciaConTiempoDisponibleDistintoDeCero() {
        Policia unPolicia = new Policia("Juan", new Ciudad("Kiev", new Coordenada(3,5)));

        Assert.assertNotSame(unPolicia.getTiempoDisponible(), 0);
    }

    @Test
    public void getTiempoDisponibleDevuelveElTiempoQueLeQuedaAlPolicia() {
        Policia unPolicia = new Policia("Pepe", new Ciudad("Cardiff", new Coordenada(3,5)));

        //Un policia empieza con 154hs
        Assert.assertEquals(unPolicia.getTiempoDisponible(), 154);
    }

    @Test
    public void setRangoCambiaElRangoDelPolicia() {
        Policia unPolicia = new Policia("Andrew", new Ciudad("Brujas", new Coordenada(3,5)));
        Rango detective = new Detective();

        unPolicia.setRango(detective);

        Assert.assertEquals(unPolicia.getRango(), detective);
    }

    @Test
    public void viajarCambiaLaCiudadActualDelPoliciaYLeRestaTiempo() {
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3,5));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(10,5));

        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadDestino);
        Assert.assertNotSame(unPolicia.getTiempoDisponible(), 154);
    }
}