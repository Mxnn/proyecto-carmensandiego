package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class EdificioTest {
    @Test
	public void unEdificioSeCreaConPistasFacilesPorDefecto() {
		Edificio edificio = new Edificio();
		Novato rango = new Novato();
		
		Assert.assertNotNull(edificio.getPista(rango));
	}
	
	@Test
	public void unEdificioSeCreaConPistasIntermediasPorDefecto() {
		Edificio edificio = new Edificio();
		Detective rango = new Detective();
		
		Assert.assertNotNull(edificio.getPista(rango));
	}
	
	@Test
	public void unEdificioSeCreaConPistasDificilesPorDefecto() {
		Edificio edificio = new Edificio();
		Sargento rango = new Sargento();
		
		Assert.assertNotNull(edificio.getPista(rango));
	}
	
	@Test
    public void unEdificioDevuelveLaPistaDeDificultadFacilParaUnRangoNovato() {
        Edificio edificio = new Edificio();
        Pista unaPistaNivelFacil = new Pista("EF");
        Novato novato = new Novato();

        edificio.setPistas(unaPistaNivelFacil, new Pista("EI"), new Pista("ED"));

        Assert.assertEquals(edificio.getPista(novato), "EF");
    }

    @Test
    public void unEdificioDevuelveLaPistaDeDificultadIntermediaParaUnRangoDetective() {
        Edificio edificio = new Edificio();
        Pista unaPistaNivelIntermedio = new Pista("EI");
        Detective detective = new Detective();

        edificio.setPistas(new Pista("EF"), unaPistaNivelIntermedio, new Pista("ED"));

        Assert.assertEquals(edificio.getPista(detective), "EI");
    }

    @Test
    public void unEdificioDevuelveLaPistaDeDificultadIntermediaParaUnRangoInvestigador() {
        Edificio edificio = new Edificio();
        Pista unaPistaNivelIntermedio = new Pista("EI");
        Investigador investigador = new Investigador();

        edificio.setPistas(new Pista("EF"), unaPistaNivelIntermedio, new Pista("ED"));

        Assert.assertEquals(edificio.getPista(investigador), "EI");
    }

    @Test
    public void unEdificioDevuelveLaPistaDeDificultadDificilParaUnRangoSargento() {
        Edificio edificio = new Edificio();
        Pista unaPistaNivelDificil = new Pista("ED");
        Sargento sargento = new Sargento();

        edificio.setPistas(new Pista("EF"), new Pista("EI"), unaPistaNivelDificil);

        Assert.assertEquals(edificio.getPista(sargento), "ED");
    }
	
	@Test
    public void elConstructorDelEdificioSeteaPistaFacilPorDefecto() {
        Edificio edificio = new Edificio();
        Novato novato = new Novato();

        Assert.assertEquals(edificio.getPista(novato), Pista.PISTA_POR_DEFECTO_LUGAR);
    }
	
	@Test
    public void elConstructorDelEdificioSeteaPistaIntermediaPorDefecto() {
        Edificio edificio = new Edificio();
        Detective detective = new Detective();

        Assert.assertEquals(edificio.getPista(detective), Pista.PISTA_POR_DEFECTO_LUGAR);
    }
	
	@Test
    public void elConstructorDelEdificioSeteaPistaDificilPorDefecto() {
        Edificio edificio = new Edificio();
        Sargento sargento = new Sargento();

        Assert.assertEquals(edificio.getPista(sargento), Pista.PISTA_POR_DEFECTO_LUGAR);
    }
}
