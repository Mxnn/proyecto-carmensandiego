package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class CiudadTest {
    @Test
    public void ciudadSeCreaConEdificiosPorDefecto() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));

        Assert.assertNotNull(ciudad.getEdificioCultural());
        Assert.assertNotNull(ciudad.getEdificioTransporte());
        Assert.assertNotNull(ciudad.getEdificioEconomia());
    }
	
	@Test
	public void getNombreDevuelveElNombreDeLaCiudad() {
		Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
		
		Assert.assertEquals(ciudad.getNombre(), "Buenos Aires");
	}
	
	@Test
    public void ciudadSeCreaSinCiudadesConectadas() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
		
        Assert.assertTrue(ciudad.getCiudadesConectadas().isEmpty());
    }
	
	@Test
    public void ciudadSeCreaSinEsconderAlLadron() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
		
        Assert.assertFalse(ciudad.escondeAlLadron());
    }

    @Test
    public void getCoordenadasDevuelveLasCoordenadasConLasCualesFueCreadaLaCiudad() {
        Coordenada coordenada = new Coordenada(1, 1);
        Ciudad ciudad = new Ciudad("Buenos Aires", coordenada);

        Assert.assertEquals(ciudad.getCoordenadas(), coordenada);
    }

    @Test
    public void setEdificioTransporteCambiaElEdificioDeTransporte() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Edificio nuevoEdificioTransporte = new Edificio();

        ciudad.setEdificioTransporte(nuevoEdificioTransporte);
        Assert.assertEquals(ciudad.getEdificioTransporte(), nuevoEdificioTransporte);
    }

    @Test
    public void setEdificioCulturalCambiaElEdificioDeCultural() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Edificio nuevoEdificioCultural = new Edificio();

        ciudad.setEdificioCultural(nuevoEdificioCultural);
        Assert.assertEquals(ciudad.getEdificioCultural(), nuevoEdificioCultural);
    }

    @Test
    public void setEdificioEconomiaCambiaElEdificioDeEconomia() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Edificio nuevoEdificioEconomia = new Edificio();

        ciudad.setEdificioEconomia(nuevoEdificioEconomia);
        Assert.assertEquals(ciudad.getEdificioEconomia(), nuevoEdificioEconomia);
    }

    @Test
    public void conectarCiudadAgregaUnaCiudadALaActual() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        Assert.assertTrue((londres.getCiudadesConectadas()).size() == 1);
    }
	
	@Test
    public void conectarCiudadConectaUnaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        Assert.assertEquals((londres.getCiudadesConectadas()).get(0), paris);
    }
	
	@Test
    public void getCiudadesConectadasDevuelveATodasLasCiudadesQueSeConectaron() {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5, 7));
		Ciudad londres = new Ciudad("Londres", new Coordenada(4, 9));

        londres.conectarCiudad(paris);
		londres.conectarCiudad(buenosAires);
		
        Assert.assertEquals((londres.getCiudadesConectadas()).get(0), paris);
		Assert.assertEquals((londres.getCiudadesConectadas()).get(1), buenosAires);
    }

    @Test
    public void escondeAlLadronDevuelveTrueSiElLadronEstaEnLaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        
        londres.esconderAlLadron();

        Assert.assertTrue(londres.escondeAlLadron());
    }

    @Test
    public void ladronEstaEnLaCiudadDevuelveFalseSiElLadronNoEstaEnLaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));

        Assert.assertFalse(londres.escondeAlLadron());
    }
}