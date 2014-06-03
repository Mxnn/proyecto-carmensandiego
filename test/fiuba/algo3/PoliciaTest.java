package fiuba.algo3;

import org.junit.Test;
import org.junit.Assert;

public class PoliciaTest {
    @Test
     public void getPistaDeberiaDevolverLaPistaAcordeAlRangoDelPolicia() {
        Policia unPolicia = new Policia("Carlos");
        Rango detective = new Detective();
        Ciudad unaCiudad = new Ciudad("Buenos Aires", new Coordenada(-34.6158527, -58.4332985));
        Pista unaPista = new Pista("SPFacil", "SPIntermedio", "SPDificil");

        unPolicia.setRango(detective);
        unaCiudad.setPistaSimbolosPatrios(unaPista);

        Assert.assertEquals(unPolicia.solicitarPistaSimbolosPatrios(), "SPIntermedio");
    }
    
    @Test
    public void calcularTiempoDeViajeCalculaDependiendoDelRangoDelPolicia() {
        Policia unPolicia = new Policia("Juan");
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(-34.6158527, -58.4332985));
        Ciudad ciudadDestino = new Ciudad("Londres", new Coordenada(51.5286416,-0.1015987));
        Rango novato = new Novato();
        int tiempoDisponible;

        unPolicia.setRango(novato);
        tiempoDisponible = unPolicia.getTiempoDisponible();
        unPolicia.setCiudadActual(ciudadSalida);
        unPolicia.viajar(ciudadDestino);

        /*11140,453 distancia en KM entre Buenos Aires y Londres segun http://www.freemaptools.com/measure-distance.htm
        y tarda 12 HS viajando a 900km/h */
        Assert.assertEquals(unPolicia.getTiempoDisponible(), (tiempoDisponible - 12));
    }
}
