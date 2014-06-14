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

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL);
    }

    @Test
    public void setRangoCambiaElRangoDelPolicia() {
        Policia unPolicia = new Policia("Andrew", new Ciudad("Brujas", new Coordenada(3,5)));
        Rango detective = new Detective();

        unPolicia.setRango(detective);

        Assert.assertEquals(unPolicia.getRango(), detective);
    }

    @Test
    public void viajarAUnaCiudadConectadaSiTieneTiempoCambiaLaCiudadActual() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        ciudadSalida.conectarCiudad(ciudadDestino);
		unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadDestino);
    }
	
	@Test
    public void viajarAUnaCiudadConectadaSiTieneTiempoLeRestaTiempo() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        ciudadSalida.conectarCiudad(ciudadDestino);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 3);
    }

	@Test
    public void viajarAUnaCiudadConectadaSiTieneTiempoDevuelveTrue() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        ciudadSalida.conectarCiudad(ciudadDestino);

        Assert.assertTrue(unPolicia.viajar(ciudadDestino));
    }

    @Test
    public void viajarAUnaCiudadNoConectadaSiTieneTiempoDevuelveFalse() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        Assert.assertFalse(unPolicia.viajar(ciudadDestino));
    }

    @Test (expected=ExcepcionJugadorSinTiempoDisponible.class)
    public void viajarAUnaCiudadConectadaSiNoLeQuedaTiempoLanzaExcepcion() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        ciudadSalida.conectarCiudad(ciudadDestino);
        unPolicia.setTiempoDisponible(1);

        unPolicia.viajar(ciudadDestino);
    }
	
	@Test (expected=ExcepcionJugadorSinTiempoDisponible.class)
    public void viajarAUnaCiudadConectadaSiNoLeQuedaTiempoLanzaExcepcionYNoCambiaLaCiudadActual() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        unPolicia.setTiempoDisponible(1);
        ciudadSalida.conectarCiudad(ciudadDestino);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadSalida);
    }

	@Test (expected=ExcepcionJugadorSinTiempoDisponible.class)
    public void viajarAUnaCiudadConectadaSiNoLeQuedaTiempoLanzaExcepcionYNoLeRestaTiempo() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));
        int tiempoDelPolicia = 1;

        unPolicia.setTiempoDisponible(tiempoDelPolicia);
        ciudadSalida.conectarCiudad(ciudadDestino);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), tiempoDelPolicia);
    }
	
	@Test
	public void visitarUnEdificioRestaUnaHora() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio", ciudadSalida);

        unPolicia.visitarEdificioEconomia();

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 1);
	}
	
	@Test
	public void visitarDosEdificiosRestaTresHoras() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio", ciudadSalida);

        unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 3);
	}
	
	@Test
	public void visitarTresEdificiosRestaSeisHoras() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio", ciudadSalida);

        unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
		unPolicia.visitarEdificioTransporte();

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 6);
	}

    @Test(expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void visitarEdificioSinTiempoDisponibleLanzaExcepcion() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio", ciudadSalida);

        unPolicia.setTiempoDisponible(0);
        unPolicia.visitarEdificioEconomia();
    }
}