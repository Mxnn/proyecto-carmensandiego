package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;
import junit.framework.TestCase;

public class IntegradoresTest {
	final double KMPORHORA_NOVATO = 900.0;
	final double KMPORHORA_DETECTIVE = 1100.0;
	final double KMPORHORA_INVESTIGADOR = 1300.0;
	final double KMPORHORA_SARGENTO = 1500.0;

    @Test
    public void calcularTiempoDeViajeConNovatoEnDistanciaQueLlevaUnaHora() {
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(KMPORHORA_NOVATO, KMPORHORA_NOVATO));
        Policia unPolicia = new Policia("Juan", ciudadSalida);
		
        Ciudad ciudadDestino = new Ciudad("Londres", new Coordenada(KMPORHORA_NOVATO, 0.0));
        int tiempoDisponible;
        tiempoDisponible = unPolicia.getTiempoDisponible();
		
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), tiempoDisponible - 1);
    }

	@Test
    public void calcularTiempoDeViajeConDetectiveEnDistanciaQueLlevaUnaHora() {
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(KMPORHORA_DETECTIVE, KMPORHORA_DETECTIVE));
        Policia unPolicia = new Policia("Juan", ciudadSalida);
		unPolicia.setRango(new Detective());
		
        Ciudad ciudadDestino = new Ciudad("Londres", new Coordenada(KMPORHORA_DETECTIVE, 0.0));
        int tiempoDisponible;
        tiempoDisponible = unPolicia.getTiempoDisponible();
		
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), tiempoDisponible - 1);
    }
	
	@Test
    public void calcularTiempoDeViajeConInvestigadorEnDistanciaQueLlevaUnaHora() {
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(KMPORHORA_INVESTIGADOR, KMPORHORA_INVESTIGADOR));
        Policia unPolicia = new Policia("Juan", ciudadSalida);
		unPolicia.setRango(new Investigador());
		
        Ciudad ciudadDestino = new Ciudad("Londres", new Coordenada(KMPORHORA_INVESTIGADOR, 0.0));
        int tiempoDisponible;
        tiempoDisponible = unPolicia.getTiempoDisponible();
		
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), tiempoDisponible - 1);
    }
	
	@Test
    public void calcularTiempoDeViajeConSargentoEnDistanciaQueLlevaUnaHora() {
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(KMPORHORA_SARGENTO, KMPORHORA_SARGENTO));
        Policia unPolicia = new Policia("Juan", ciudadSalida);
		unPolicia.setRango(new Sargento());
		
        Ciudad ciudadDestino = new Ciudad("Londres", new Coordenada(KMPORHORA_SARGENTO, 0.0));
        int tiempoDisponible;
        tiempoDisponible = unPolicia.getTiempoDisponible();
		
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), tiempoDisponible - 1);
    }
	
	@Test
    public void policiaDeRangoNovatoObtienePistaNivelFacil() {
		Edificio aeropuerto = new Edificio("Aeropuerto");
        aeropuerto.setPistas(new Pista("AF"), new Pista("AI"), new Pista("AD"));
		
		Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
		ciudadSalida.setEdificioTransporte(aeropuerto);
		
        Policia unPolicia = new Policia("Juan", ciudadSalida);

        Assert.assertEquals(unPolicia.visitarEdificioTransporte(), "AF");
    }
	
    @Test
    public void policiaDeRangoDetectiveObtienePistaNivelIntermedio() {
		Edificio aeropuerto = new Edificio("Aeropuerto");
        aeropuerto.setPistas(new Pista("AF"), new Pista("AI"), new Pista("AD"));
		
		Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
		ciudadSalida.setEdificioTransporte(aeropuerto);
		
        Policia unPolicia = new Policia("Juan", ciudadSalida);
        Rango detective = new Detective();
        unPolicia.setRango(detective);

        Assert.assertEquals(unPolicia.visitarEdificioTransporte(), "AI");
    }
	
	@Test
    public void policiaDeRangoInvestigadorObtienePistaNivelIntermedio() {
		Edificio aeropuerto = new Edificio("Aeropuerto");
        aeropuerto.setPistas(new Pista("AF"), new Pista("AI"), new Pista("AD"));
		
		Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
		ciudadSalida.setEdificioTransporte(aeropuerto);
		
        Policia unPolicia = new Policia("Juan", ciudadSalida);
        Rango investigador = new Investigador();
        unPolicia.setRango(investigador);

        Assert.assertEquals(unPolicia.visitarEdificioTransporte(), "AI");
    }
	
	@Test
    public void policiaDeRangoSargentoObtienePistaNivelDificil() {
		Edificio aeropuerto = new Edificio("Aeropuerto");
        aeropuerto.setPistas(new Pista("AF"), new Pista("AI"), new Pista("AD"));
		
		Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
		ciudadSalida.setEdificioTransporte(aeropuerto);
		
        Policia unPolicia = new Policia("Juan", ciudadSalida);
        Rango sargento = new Sargento();
        unPolicia.setRango(sargento);

        Assert.assertEquals(unPolicia.visitarEdificioTransporte(), "AD");
    }
}
