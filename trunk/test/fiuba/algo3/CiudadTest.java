package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class CiudadTest {
    @Test
    public void ciudadComienzaConEdificiosPorDefectoCreados() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1,1));

        Assert.assertTrue(ciudad.getEdificioBiblioteca() != null);
        Assert.assertTrue(ciudad.getEdificioSalida() != null);
        Assert.assertTrue(ciudad.getEdificioEconomia() != null);
    }

    @Test
    public void getCoordenadasDevuelveLasCoordenadasConLasCualesFueCreadaLaCiudad() {
        Coordenada coordenada = new Coordenada(1,1);
        Ciudad ciudad = new Ciudad("Buenos Aires", coordenada);

        Assert.assertEquals(ciudad.getCoordenadas(), coordenada);
    }

    @Test
    public void setEdificioSalidaCambiaElEdificioDeSalida() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1,1));
        Edificio nuevoEdificioSalida = new Edificio("AeropuertoNuevo");

        ciudad.setEdificioSalida(nuevoEdificioSalida);
        Assert.assertEquals(ciudad.getEdificioSalida(), nuevoEdificioSalida);
    }

    @Test
    public void setEdificioBibliotecaCambiaElEdificioDeBiblioteca() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1,1));
        Edificio nuevoEdificioBiblioteca = new Edificio("BibliotecaNuevo");

        ciudad.setEdificioSalida(nuevoEdificioBiblioteca);
        Assert.assertEquals(ciudad.getEdificioSalida(), nuevoEdificioBiblioteca);
    }

    @Test
    public void setEdificioEconomiaCambiaElEdificioDeEconomia() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1,1));
        Edificio nuevoEdificioEconomia = new Edificio("EconomiaNuevo");

        ciudad.setEdificioSalida(nuevoEdificioEconomia);
        Assert.assertEquals(ciudad.getEdificioSalida(), nuevoEdificioEconomia);
    }
}
