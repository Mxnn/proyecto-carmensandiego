package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;
import java.lang.Math;

public class CoordenadaTest {
    @Test
    public void calcularDistanciaEntrePuntosDistintosAmbosPositivosDevuelveLaDistanciaCorrecta() {
        Coordenada coord1 = new Coordenada(1.0, 1.0);
        Coordenada coord2 = new Coordenada(5.0, 5.0);

        Assert.assertEquals(coord1.calcularDistancia(coord2), Math.sqrt(32));
    }

    @Test
    public void calcularDistanciaDeDosPuntosIgualesEsCero() {
        Coordenada cord1 = new Coordenada(5.0, 5.0);
        Coordenada cord2 = new Coordenada(5.0, 5.0);

        Assert.assertEquals(cord2.calcularDistancia(cord1), 0.0);
    }

    @Test
    public void calcularDistanciaEntrePuntosDistintosConNegativosDevuelveLaDistanciaCorrecta() {
        Coordenada cord1 = new Coordenada(-5.0, -5.0);
        Coordenada cord2 = new Coordenada(5.0, 5.0);

        Assert.assertEquals(cord2.calcularDistancia(cord1), Math.sqrt(200));
    }
	
	@Test
    public void calcularDistanciaEntrePuntosDistintosAmbosNegativosDevuelveLaDistanciaCorrecta() {
        Coordenada cord1 = new Coordenada(-5.0, -5.0);
        Coordenada cord2 = new Coordenada(-1.0, -1.0);

        Assert.assertEquals(cord2.calcularDistancia(cord1), Math.sqrt(32));
    }
}