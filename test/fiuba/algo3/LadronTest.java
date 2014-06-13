package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class LadronTest {
	@Test
	public void tieneEstaCaracteristicaConSexoCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Sexo.FEMENINO));
	}
	
	@Test
	public void tieneEstaCaracteristicaConSexoIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.Sexo.FEMENINO));
	}
	
	@Test
	public void tieneEstaCaracteristicaConPeloCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Pelo.MARRON));
	}
	
	@Test
	public void tieneEstaCaracteristicaConPeloIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.Pelo.RUBIO));
	}
	
	@Test
	public void tieneEstaCaracteristicaConHobbyCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Hobby.FUTBOL));
	}
	
	@Test
	public void tieneEstaCaracteristicaConHobbyIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.Hobby.BASQUET));
	}
	
	@Test
	public void tieneEstaCaracteristicaConAutoCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Auto.MOTO));
	}
	
	@Test
	public void tieneEstaCaracteristicaConAutoIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.Auto.CONVERTIBLE));
	}
	
	@Test
	public void tieneEstaCaracteristicaConMarcaPersonalCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.MarcaPersonal.TATUAJE));
	}
	
	@Test
	public void tieneEstaCaracteristicaConMarcaPersonalIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.FUTBOL, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.MarcaPersonal.ANILLO));
	}
}