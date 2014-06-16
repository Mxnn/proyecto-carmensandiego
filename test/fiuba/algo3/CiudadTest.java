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
    public void conectarCiudadConectaCiudades() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        Assert.assertTrue(londres.ciudadEstaConectada(paris));
        Assert.assertTrue((londres.getCiudadesConectadas()).size() == 1);
    }

    @Test
    public void conectarCiudadConectaSolamenteALaCiudadALaCualLeConectoUnaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);

        Assert.assertTrue((paris.getCiudadesConectadas()).size() == 0);
    }

    @Test
    public void desconectarCiudadSacaLaCiudadEnviadaComoCiudadConectada() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        londres.desconectarCiudad(paris);

        Assert.assertTrue((londres.getCiudadesConectadas()).size() == 0);
    }

    @Test
    public void ciudadEstaConectadaDevuelveTrueSiLaCiudadEstaConectada() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);

        Assert.assertTrue(londres.ciudadEstaConectada(paris));
    }

    @Test
    public void ciudadEstaConectadaDevuelveFalseSiLaCiudadNoEstaConectada() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        Assert.assertFalse(londres.ciudadEstaConectada(paris));
    }

    @Test
    public void ladronEstaEnLaCiudadDevuelveTrueSiElLadronEstaEnLaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ladron ladron = new Ladron("Joseph", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        londres.esconderLadron(ladron);

        Assert.assertTrue(londres.ladronEstaEnLaCiudad());
    }

    @Test
    public void ladronEstaEnLaCiudadDevuelveFalseSiElLadronNoEstaEnLaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));

        Assert.assertFalse(londres.ladronEstaEnLaCiudad());
    }

    @Test
    public void getLadronDevuelveElLadronSiElLadronEstaEnLaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ladron ladron = new Ladron("Joseph", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        londres.esconderLadron(ladron);

        Assert.assertTrue(londres.getLadronEscondido().getClass() == Ladron.class);
    }

    @Test
    public void getLadronDevuelveNullSiElLadronNoEstaEnLaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));

        Assert.assertTrue(londres.getLadronEscondido() == null);
    }
}