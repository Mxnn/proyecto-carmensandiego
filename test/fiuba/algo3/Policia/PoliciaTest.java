package fiuba.algo3.Policia;

import org.junit.Test;
import org.junit.Assert;

public class PoliciaTest {
    @Test
     public void getPistaDeberiaDevolverLaPistaAcordeAlRangoDelPolicia() {
        Policia unPolicia = policia("Carlos");
        Rango detective = detective();
        Ciudad unaCiudad = ciudad("Buenos Aires", coordenada(1, 1));
        Pista unaPista = pista("GeoFacil", "GeoInteredio", "GeoDificil");

        unPolicia.setRango(detective);
        unaCiudad.setPistaGeografia(unaPista);

        Assert.assertArrayEquals(policia.getPistaGeografia(), "GeoFacil");
    }
    
    @Test
    public void calcularTiempoDeViajeCalculaDependiendoDelRangoDelPolicia() {
        Policia unPolicia = policia("Juan");
        Ciudad ciudadSalida = ciudad("Buenos Aires", coodenada(-34.6158527, -58.4332985));
        Ciudad ciudadDestino = ciudad("Londres", coordenada(51.5286416,-0.1015987));
        Rango novato = notavo();

        unPolicia.setTiempoDisponible(12);
        unPolicia.setRango(novato);
        unPolicia.setCiudadActual(ciudadSalida);
        unPolicia.viajar(ciudadDestino);

        //11140,453 distancia en KM entre Buenos Aires y Londres segun http://www.freemaptools.com/measure-distance.htm y tarda 12HS
        Assert.assertEquals(unPolicia.getTiempoDisponible(), 0);
    }
}
