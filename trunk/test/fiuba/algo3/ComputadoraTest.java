package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;
import java.util.ArrayList;

public class ComputadoraTest {
	@Test
	public void setSospechosoGuardaATodosLosLadronesIncluidoElBuscado() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.FUTBOL, Ladron.Auto.CAMIONETA, Ladron.MarcaPersonal.CICATRIZ);
		Ladron sospechoso2 = new Ladron("Celeste", Ladron.Sexo.FEMENINO, Ladron.Pelo.ROJO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Ladron sospechoso3 = new Ladron("Carmen", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.ANILLO);
		computadora.setSospechoso(sospechoso1);
		computadora.setSospechoso(sospechoso2);
		computadora.setSospechoso(sospechoso3);
		
		ArrayList<Ladron> sospechosos = computadora.getSospechosos();
		Assert.assertEquals(sospechosos.get(0), buscado);
		Assert.assertEquals(sospechosos.get(1), sospechoso1);
		Assert.assertEquals(sospechosos.get(2), sospechoso2);
		Assert.assertEquals(sospechosos.get(3), sospechoso3);
	}
	
	@Test
	public void filtrarSexoEliminaALosSospechososQueNoTienenLaCaracteristicaElegida() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.FUTBOL, Ladron.Auto.CAMIONETA, Ladron.MarcaPersonal.CICATRIZ);
		Ladron sospechoso2 = new Ladron("Celeste", Ladron.Sexo.FEMENINO, Ladron.Pelo.ROJO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Ladron sospechoso3 = new Ladron("Carmen", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.ANILLO);
		computadora.setSospechoso(sospechoso1);
		computadora.setSospechoso(sospechoso2);
		computadora.setSospechoso(sospechoso3);
		
		computadora.filtrarCaracteristica(Ladron.Sexo.MASCULINO);
		
		ArrayList<Ladron> sospechosos = computadora.getSospechosos();
		Assert.assertEquals(sospechosos.get(0), buscado);
		Assert.assertEquals(sospechosos.get(1), sospechoso1);
		Assert.assertTrue(sospechosos.size() == 2);
	}
	
	public void filtrarPeloEliminaALosSospechososQueNoTienenLaCaracteristicaElegida() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.FUTBOL, Ladron.Auto.CAMIONETA, Ladron.MarcaPersonal.CICATRIZ);
		Ladron sospechoso2 = new Ladron("Celeste", Ladron.Sexo.FEMENINO, Ladron.Pelo.ROJO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Ladron sospechoso3 = new Ladron("Carmen", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.ANILLO);
		computadora.setSospechoso(sospechoso1);
		computadora.setSospechoso(sospechoso2);
		computadora.setSospechoso(sospechoso3);
		
		computadora.filtrarCaracteristica(Ladron.Pelo.ROJO);
		
		ArrayList<Ladron> sospechosos = computadora.getSospechosos();
		Assert.assertEquals(sospechosos.get(0), sospechoso2);
		Assert.assertTrue(sospechosos.size() == 1);
	}
	
	public void filtrarHobbyEliminaALosSospechososQueNoTienenLaCaracteristicaElegida() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.FUTBOL, Ladron.Auto.CAMIONETA, Ladron.MarcaPersonal.CICATRIZ);
		Ladron sospechoso2 = new Ladron("Celeste", Ladron.Sexo.FEMENINO, Ladron.Pelo.ROJO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Ladron sospechoso3 = new Ladron("Carmen", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.ANILLO);
		computadora.setSospechoso(sospechoso1);
		computadora.setSospechoso(sospechoso2);
		computadora.setSospechoso(sospechoso3);
		
		computadora.filtrarCaracteristica(Ladron.Hobby.BASQUET);
		
		ArrayList<Ladron> sospechosos = computadora.getSospechosos();
		Assert.assertEquals(sospechosos.get(0), buscado);
		Assert.assertEquals(sospechosos.get(1), sospechoso2);
		Assert.assertTrue(sospechosos.size() == 2);
	}
	
	public void filtrarAutoEliminaALosSospechososQueNoTienenLaCaracteristicaElegida() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.FUTBOL, Ladron.Auto.CAMIONETA, Ladron.MarcaPersonal.CICATRIZ);
		Ladron sospechoso2 = new Ladron("Celeste", Ladron.Sexo.FEMENINO, Ladron.Pelo.ROJO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Ladron sospechoso3 = new Ladron("Carmen", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.ANILLO);
		computadora.setSospechoso(sospechoso1);
		computadora.setSospechoso(sospechoso2);
		computadora.setSospechoso(sospechoso3);
		
		computadora.filtrarCaracteristica(Ladron.Auto.MOTO);
		
		ArrayList<Ladron> sospechosos = computadora.getSospechosos();
		Assert.assertEquals(sospechosos.get(0), sospechoso2);
		Assert.assertTrue(sospechosos.size() == 1);
	}
	
	public void filtrarMarcaPersonalEliminaALosSospechososQueNoTienenLaCaracteristicaElegida() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.FUTBOL, Ladron.Auto.CAMIONETA, Ladron.MarcaPersonal.CICATRIZ);
		Ladron sospechoso2 = new Ladron("Celeste", Ladron.Sexo.FEMENINO, Ladron.Pelo.ROJO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Ladron sospechoso3 = new Ladron("Carmen", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.ANILLO);
		computadora.setSospechoso(sospechoso1);
		computadora.setSospechoso(sospechoso2);
		computadora.setSospechoso(sospechoso3);
		
		computadora.filtrarCaracteristica(Ladron.MarcaPersonal.ANILLO);
		
		ArrayList<Ladron> sospechosos = computadora.getSospechosos();
		Assert.assertEquals(sospechosos.get(0), sospechoso3);
		Assert.assertTrue(sospechosos.size() == 1);
	}
	
	public void filtrarUnaCaracteristicaQueNoTienenLosSospechososNoHaceNada() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.FUTBOL, Ladron.Auto.CAMIONETA, Ladron.MarcaPersonal.CICATRIZ);
		Ladron sospechoso2 = new Ladron("Celeste", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Ladron sospechoso3 = new Ladron("Carmen", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.ANILLO);
		computadora.setSospechoso(sospechoso1);
		computadora.setSospechoso(sospechoso2);
		computadora.setSospechoso(sospechoso3);
		
		ArrayList<Ladron> sospechososAntes = computadora.getSospechosos();
		computadora.filtrarCaracteristica(Ladron.Pelo.ROJO);
		ArrayList<Ladron> sospechososDespues = computadora.getSospechosos();
		
		Assert.assertEquals(sospechososAntes, sospechososDespues);
	}
	
	public void siElUnicoLadronQueTengoComoSospechosoEsElBuscadoPuedoEmitirOrdenDeArresto() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		
		Assert.assertTrue(computadora.puedoEmitirOrdenDeArresto());
	}
	
	public void siElUnicoLadronQueTengoComoSospechosoNOEsElBuscadoNOPuedoEmitirOrdenDeArresto() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.FUTBOL, Ladron.Auto.CAMIONETA, Ladron.MarcaPersonal.CICATRIZ);
		computadora.setSospechoso(sospechoso1);
		
		computadora.filtrarCaracteristica(Ladron.Pelo.NEGRO);
		
		Assert.assertFalse(computadora.puedoEmitirOrdenDeArresto());
	}
}