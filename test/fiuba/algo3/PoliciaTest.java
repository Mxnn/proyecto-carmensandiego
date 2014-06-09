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
    public void viajarSiTieneTiempoCambiaLaCiudadActualDelPoliciaYLeRestaTiempo() {
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000,5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000,3000));

        Assert.assertTrue(unPolicia.viajar(ciudadDestino));
        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadDestino);
        Assert.assertEquals(unPolicia.getTiempoDisponible(), 151);
    }

    @Test
    public void viajarSiNoLeQuedaTiempoNoCambiaLaCiudadActualNiLeRestaTiempo() {
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000,5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000,3000));
        int tiempoDelPolicia = 1;

        unPolicia.setTiempoDisponible(tiempoDelPolicia);

        Assert.assertFalse(unPolicia.viajar(ciudadDestino));
        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadSalida);
        Assert.assertEquals(unPolicia.getTiempoDisponible(), 1);
    }

}
