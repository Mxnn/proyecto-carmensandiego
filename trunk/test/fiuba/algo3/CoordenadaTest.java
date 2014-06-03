package fiuba.algo3;

import org.junit.Test;
import org.junit.Assert;

public class CoordenadaTest {
    @Test
    public void calcularDistanciaBuenosAiresLondres() {
        Coordenada buenosAires = new Coordenada(-34.6158527, -58.4332985);
		Coordenada londres = new Coordenada(51.5286416, -0.1015987);
		
        Assert.assertEquals(buenosAires.calcularDistancia(londres), 11140,453);
    }
	
	@Test
    public void calcularDistanciaLondresBuenosAires() {
        Coordenada buenosAires = new Coordenada(-34.6158527, -58.4332985);
		Coordenada londres = new Coordenada(51.5286416, -0.1015987);
		
        Assert.assertEquals(londres.calcularDistancia(buenosAires), 11140,453);
    }
	
	@Test
    public void calcularDistanciaBuenosAiresNewYork() {
        Coordenada buenosAires = new Coordenada(-34.6158527, -58.4332985);
		Coordenada newYork = new Coordenada(40.7056308, -73.9780035);
		
        Assert.assertEquals(buenosAires.calcularDistancia(newYork), 8534,702);
    }
	
	@Test
    public void calcularDistanciaNewYorkBuenosAires() {
        Coordenada buenosAires = new Coordenada(-34.6158527, -58.4332985);
		Coordenada newYork = new Coordenada(40.7056308, -73.9780035);
		
        Assert.assertEquals(newYork.calcularDistancia(buenosAires), 8534,702);
    }
}
