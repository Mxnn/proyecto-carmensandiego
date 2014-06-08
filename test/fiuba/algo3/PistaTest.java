package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class PistaTest {
    @Test
    public void getPistaDevuelveLaPistaSeteada() {
        Pista pista = new Pista("MiPista");

        Assert.assertEquals(pista.getPista(), "MiPista");
    }
}
