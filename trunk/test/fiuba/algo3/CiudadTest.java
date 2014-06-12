package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class CiudadTest {
    @Test
    public void ciudadComienzaConEdificiosPorDefectoCreados() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));

        Assert.assertTrue(ciudad.getEdificioCultural() != null);
        Assert.assertTrue(ciudad.getEdificioTransporte() != null);
        Assert.assertTrue(ciudad.getEdificioEconomia() != null);
    }

    @Test
    public void getCoordenadasDevuelveLasCoordenadasConLasCualesFueCreadaLaCiudad() {
        Coordenada coordenada = new Coordenada(1,1);
        Ciudad ciudad = new Ciudad("Buenos Aires", coordenada);

        Assert.assertEquals(ciudad.getCoordenadas(), coordenada);
    }

    @Test
    public void setEdificioTransporteCambiaElEdificioDeTransporte() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Edificio nuevoEdificioTransporte = new Edificio("Aeropuerto");

        ciudad.setEdificioTransporte(nuevoEdificioTransporte);
        Assert.assertEquals(ciudad.getEdificioTransporte(), nuevoEdificioTransporte);
    }

    @Test
    public void setEdificioCulturalCambiaElEdificioDeCultural() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Edificio nuevoEdificioCultural = new Edificio("Biblioteca");

        ciudad.setEdificioCultural(nuevoEdificioCultural);
        Assert.assertEquals(ciudad.getEdificioCultural(), nuevoEdificioCultural);
    }

    @Test
    public void setEdificioEconomiaCambiaElEdificioDeEconomia() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Edificio nuevoEdificioEconomia = new Edificio("Bolsa");

        ciudad.setEdificioEconomia(nuevoEdificioEconomia);
        Assert.assertEquals(ciudad.getEdificioEconomia(), nuevoEdificioEconomia);
    }
}
