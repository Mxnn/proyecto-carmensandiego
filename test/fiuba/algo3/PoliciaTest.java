package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class PoliciaTest {
	final int TIEMPO_DISPONIBLE_INICIAL = 154;

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

        Assert.assertEquals(unPolicia.getTiempoDisponible(), TIEMPO_DISPONIBLE_INICIAL);
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
	
	@Test
	public void viajarDevuelveFalseCuandoSeTerminaElTiempo() {
		Coordenada coordenadaSalida = new Coordenada(-11000.0, -9000.0);
		Ciudad ciudadSalida = new Ciudad("Buenos Aires", coordenadaSalida);
        Policia unPolicia = new Policia("Juan", ciudadSalida);
		Rango novato = new Novato();
		
		unPolicia.setRango(novato);
		unPolicia.setTiempoDisponible(1);
		
		Coordenada coordenadaDestino = new Coordenada(200000, 8000.0);
        Ciudad ciudadDestino = new Ciudad("Tokio", coordenadaDestino);
		double distanciaViaje = coordenadaSalida.calcularDistancia(coordenadaDestino);
		int tiempoNecesario = novato.calcularTiempoDeViaje(distanciaViaje);
		
		Assert.assertFalse(unPolicia.viajar(ciudadDestino));
	}	
}
