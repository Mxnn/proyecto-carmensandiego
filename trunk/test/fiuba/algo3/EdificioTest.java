package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class EdificioTest {
    @Test
    public void unEdificioDevuelveLaPistaDeDifucultadFacilParaUnRangoNovato() {
        Edificio edificio = new Edificio("Cualquiera");
        Pista unaPistaNivelFacil = new Pista("EF");
        Novato novato = new Novato();

        edificio.setPistas(unaPistaNivelFacil, new Pista("EF"), new Pista("ED"));

        Assert.assertEquals(edificio.getPista(novato), "EF");
    }

    @Test
    public void unEdificioDevuelveLaPistaDeDificultadIntermediaParaUnRangoDetective() {
        Edificio edificio = new Edificio("Cualquiera");
        Pista unaPistaNivelIntermedio = new Pista("EI");
        Detective detective = new Detective();

        edificio.setPistas(new Pista("EF"), unaPistaNivelIntermedio, new Pista("ED"));

        Assert.assertEquals(edificio.getPista(detective), "EI");
    }

    @Test
    public void unEdificioDevuelveLaPistaDeDificultadIntermediaParaUnRangoInvestigador() {
        Edificio edificio = new Edificio("Cualquiera");
        Pista unaPistaNivelIntermedio = new Pista("EI");
        Investigador investigador = new Investigador();

        edificio.setPistas(new Pista("EF"), unaPistaNivelIntermedio, new Pista("ED"));

        Assert.assertEquals(edificio.getPista(investigador), "EI");
    }

    @Test
    public void unEdificioDevuelveLaPistaDeDificultadDificilParaUnRangoSargento() {
        Edificio edificio = new Edificio("Cualquiera");
        Pista unaPistaNivelDificil = new Pista("ED");
        Sargento sargento = new Sargento();

        edificio.setPistas(new Pista("EF"), new Pista("EI"), unaPistaNivelDificil);

        Assert.assertEquals(edificio.getPista(sargento), "ED");
    }
}
