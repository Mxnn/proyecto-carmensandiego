package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class PoliciaTest {
    @Test
    public void getPistaDeberiaDevolverLaPistaAcordeAlRangoDelPolicia() {
        Policia unPolicia = new Policia("Carlos");
        Rango novato = new Novato();
        Ciudad unaCiudad = new Ciudad("Buenos Aires", new Coordenada(100.0, 100.0));
        Pista unaPista = new Pista("SPFacil", "SPIntermedio", "SPDificil");

        unPolicia.setRango(novato);
        unaCiudad.setPistaSimbolosPatrios(unaPista);
        unPolicia.setCiudadActual(unaCiudad);

        Assert.assertEquals(unPolicia.solicitarPistaSimbolosPatrios(), "SPFacil");
    }

    @Test
    public void calcularTiempoDeViajeCalculaDependiendoDelRangoDelPolicia() {
        Policia unPolicia = new Policia("Juan");
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
        Ciudad ciudadDestino = new Ciudad("Londres", new Coordenada(900.0, 0.0));
        Rango novato = new Novato();
        int tiempoDisponible;

        unPolicia.setRango(novato);
        tiempoDisponible = unPolicia.getTiempoDisponible();
        unPolicia.setCiudadActual(ciudadSalida);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), (tiempoDisponible - 1));
    }
}