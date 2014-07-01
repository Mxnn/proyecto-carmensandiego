package fiuba.algo3.modelo;

import org.junit.Test;
import junit.framework.Assert;

public class SargentoTest {
    @Test
    public void pedirPistaDevuelveLaPistaDeDificultadDificil() {
        Sargento sargento = new Sargento();
        Edificio edificio = new Edificio();
        Pista pistaNivelDificil = new Pista("PD");

        edificio.setPistas(new Pista("PF"), new Pista("PI"), pistaNivelDificil);

        Assert.assertEquals(sargento.pedirPista(edificio), pistaNivelDificil.getPista());
    }

    @Test
    public void calcularTiempoDeViajeCalculaElViajeConLaVelocidadCorrecta() {
        Sargento sargento = new Sargento();

        Assert.assertEquals(sargento.calcularTiempoDeViaje(1500.0), 1);
    }

    @Test
    public void calcularTiempoDeViajeDevuelve1SiLaDistanciaEsMenoraLaVelocidadDelPolicia() {
        Sargento sargento = new Sargento();

        Assert.assertEquals(sargento.calcularTiempoDeViaje(100.0), 1);
    }
	
	@Test
	public void determinarRangoSiguienteDevuelveNullPorqueNoTengoLaCantidadDeCasosNecesarios() {
		Sargento sargento = new Sargento();
		
		Assert.assertNull(sargento.determinarRangoSiguiente(0));
	}
	
	@Test
	public void determinarRangoSiguienteDevuelveNullSiTengoMuchosCasos() {
		Sargento sargento = new Sargento();
		
		Assert.assertNull(sargento.determinarRangoSiguiente(541872154));
	}
}
