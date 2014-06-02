package fiuba.algo3.Policia;

import org.junit.Test;
import org.junit.Assert;

public class PoliciaTest {
    @Test
     public void getPistaDeberiaDevolverLaPistaAcordeAlRangoDelPolicia() {
        Policia unPolicia = Policia("Carlos");
        Rango detective = Detective();
        Ciudad unaCiudad = Ciudad("Buenos Aires", Coordenada(1, 1));
        Pista unaPista = Pista("AeroFacil", "AeroIntermedio", "AeroDificil");

        unPolicia.setRango(detective);
        unaCiudad.setPistaAeropuerto(unaPista);

        Assert.assertArrayEquals(unPolicia.entrarAeropuerto(), "AeroIntermedio");
    }
    
    @Test
    public void calcularTiempoDeViajeCalculaDependiendoDelRangoDelPolicia() {
        Policia unPolicia = Policia("Juan");
        Ciudad ciudadSalida = Ciudad("Buenos Aires", coodenada(-34.6158527, -58.4332985));
        Ciudad ciudadDestino = Ciudad("Londres", coordenada(51.5286416,-0.1015987));
        Rango novato = Novato();
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
