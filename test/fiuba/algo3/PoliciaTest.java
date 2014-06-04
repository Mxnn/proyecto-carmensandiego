package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class PoliciaTest {
    @Test
    public void PoliciaIniciaConRangoDistintoDeNull() {
        Policia unPolicia = new Policia("Juan");

        Assert.assertTrue(unPolicia.getRango() != null);
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

    @Test
    public void policiaDeRangoDetectiveObtienePistaNivelIntermedio() {
        Policia unPolicia = new Policia("Juan");
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
        Rango detective = new Detective();
        Pista unaPista = new Pista("MF", "MI", "MD");
        Edificio aeropuerto = new Aeropuerto();

        aeropuerto.setPista(unaPista);
        unPolicia.setRango(detective);
        ciudadSalida.setEdificioSalida(aeropuerto);
        unPolicia.setCiudadActual(ciudadSalida);
		
        Assert.assertEquals(unPolicia.getRango().consultarEdificio(aeropuerto), "MI");
    }
}