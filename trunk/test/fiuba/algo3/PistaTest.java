package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class PistaTest {
	@Test
    public void getPistaDevuelveLaPistaPorDefecto() {
        Pista pista = new Pista();

        Assert.assertEquals(pista.getPista(), Pista.PISTA_POR_DEFECTO_LUGAR + Pista.PISTA_POR_DEFECTO_LADRON);
    }

    @Test
    public void getPistaDevuelveLaPistaSeteadaDelLugar() {
        Pista pista = new Pista("MiPista");

        Assert.assertEquals(pista.getPista(), "MiPista");
    }
	
    @Test
    public void getPistaDevuelveLaPistaDelLugarYDelLadronSeteada() {
        Pista pista = new Pista("Mi Pista.");
		pista.setPistaLadron("Tenia Pelo Negro");

        Assert.assertEquals(pista.getPista(), "Mi Pista. Tenia Pelo Negro");
    }    
}
