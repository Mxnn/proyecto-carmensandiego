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

    @Test
    public void setCiudadLimitrofeAgregaCiudadLimitrofe() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        Assert.assertTrue(londres.esCiudadLimitrofe(paris));
        Assert.assertTrue((londres.getCiudadesLimitrofes()).size() == 1);
    }

    @Test
    public void setCiudadLimitrofeAgregaConexionSolamenteALaCiudadALaCualLeConectoUnaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);

        Assert.assertTrue((paris.getCiudadesLimitrofes()).size() == 0);
    }

    @Test
    public void desconectarCiudadSacaLaCiudadEnviadaComoCiudadLimitrofe() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        londres.desconectarCiudad(paris);

        Assert.assertTrue((londres.getCiudadesLimitrofes()).size() == 0);
    }

    @Test
    public void esCiudadLimitrofeDevuelveTrueSiLaCiudadEsLimitrofe() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);

        Assert.assertTrue(londres.esCiudadLimitrofe(paris));
    }

}
