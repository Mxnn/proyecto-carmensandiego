package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class IntegradoresTest {
    @Test
    public void calcularTiempoDeViajeCalculaDependiendoDelRangoDelPolicia() {
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
        Policia unPolicia = new Policia("Juan", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Londres", new Coordenada(900.0, 0.0));
        Rango novato = new Novato();
        int tiempoDisponible;

        unPolicia.setRango(novato);
        tiempoDisponible = unPolicia.getTiempoDisponible();
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), (tiempoDisponible - 1));
    }

    @Test
    public void policiaDeRangoDetectiveObtienePistaNivelIntermedio() {
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
        Policia unPolicia = new Policia("Juan", ciudadSalida);
        Rango detective = new Detective();
        Edificio aeropuerto = new Edificio("Aeropuerto");

        aeropuerto.setPistas(new Pista("AF"), new Pista("AI"), new Pista("AD"));
        unPolicia.setRango(detective);
        ciudadSalida.setEdificioSalida(aeropuerto);

        Assert.assertEquals(unPolicia.getRango().pedirPista(aeropuerto), "AI");
    }
}
