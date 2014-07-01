package fiuba.algo3.modelo;

import org.junit.Test;
import junit.framework.Assert;
import java.util.ArrayList;

import fiuba.algo3.modelo.Ladron.Sexo;
import fiuba.algo3.modelo.Ladron.Pelo;
import fiuba.algo3.modelo.Ladron.Hobby;
import fiuba.algo3.modelo.Ladron.Auto;
import fiuba.algo3.modelo.Ladron.MarcaPersonal;

public class ComputadoraTest {
	@Test
	public void elFiltroDeSexoDejaElSospechosoCorrespondiente() {
		Ladron hombre = new Ladron("hombre", Sexo.MASCULINO, Pelo.NEGRO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron mujer = new Ladron("mujer", Sexo.FEMENINO, Pelo.RUBIO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(hombre);
		sospechosos.add(mujer);
		
		Computadora computadora = new Computadora(sospechosos);
		
		computadora.setCaracteristicaDelLadron(Sexo.FEMENINO);
		
		Assert.assertEquals(computadora.emitirOrdenDeArresto(), "mujer");
	}
	
	@Test
	public void elFiltroDePeloDejaElSospechosoCorrespondiente() {
		Ladron peloNegro = new Ladron("negro", Sexo.MASCULINO, Pelo.NEGRO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron peloRubio = new Ladron("rubio", Sexo.MASCULINO, Pelo.RUBIO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron peloRojo = new Ladron("rojo", Sexo.MASCULINO, Pelo.ROJO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron peloMarron = new Ladron("marron", Sexo.MASCULINO, Pelo.MARRON, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(peloMarron);
		sospechosos.add(peloNegro);
		sospechosos.add(peloRojo);
		sospechosos.add(peloRubio);
		
		Computadora computadora = new Computadora(sospechosos);
		
		computadora.setCaracteristicaDelLadron(Pelo.NEGRO);
		
		Assert.assertEquals(computadora.emitirOrdenDeArresto(), "negro");
	}
	
	@Test
	public void elFiltroDeHobbyDejaElSospechosoCorrespondiente() {
		Ladron alpinismo = new Ladron("alpinismo", Sexo.MASCULINO, Pelo.NEGRO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron croquet = new Ladron("croquet", Sexo.MASCULINO, Pelo.RUBIO, Hobby.CROQUET, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron tennis = new Ladron("tennis", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.MOTO, MarcaPersonal.TATUAJE);
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(alpinismo);
		sospechosos.add(croquet);
		sospechosos.add(tennis);
		
		Computadora computadora = new Computadora(sospechosos);
		
		computadora.setCaracteristicaDelLadron(Hobby.TENNIS);
		
		Assert.assertEquals(computadora.emitirOrdenDeArresto(), "tennis");
	}
	
	@Test
	public void elFiltroDeAutoDejaElSospechosoCorrespondiente() {
		Ladron moto = new Ladron("moto", Sexo.MASCULINO, Pelo.NEGRO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron convertible = new Ladron("convertible", Sexo.MASCULINO, Pelo.RUBIO, Hobby.ALPINISMO, Auto.CONVERTIBLE, MarcaPersonal.TATUAJE);
		Ladron limusina = new Ladron("limusina", Sexo.MASCULINO, Pelo.ROJO, Hobby.ALPINISMO, Auto.LIMUSINA, MarcaPersonal.TATUAJE);
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(moto);
		sospechosos.add(convertible);
		sospechosos.add(limusina);
		
		Computadora computadora = new Computadora(sospechosos);
		
		computadora.setCaracteristicaDelLadron(Auto.CONVERTIBLE);
		
		Assert.assertEquals(computadora.emitirOrdenDeArresto(), "convertible");
	}
	
	@Test
	public void elFiltroDemarcaPersonalDejaElSospechosoCorrespondiente() {
		Ladron anillo = new Ladron("anillo", Sexo.MASCULINO, Pelo.NEGRO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.ANILLO);
		Ladron tatuaje = new Ladron("tatuaje", Sexo.MASCULINO, Pelo.RUBIO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron cicatriz = new Ladron("cicatriz", Sexo.MASCULINO, Pelo.ROJO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.CICATRIZ);
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(anillo);
		sospechosos.add(tatuaje);
		sospechosos.add(cicatriz);
		
		Computadora computadora = new Computadora(sospechosos);
		
		computadora.setCaracteristicaDelLadron(MarcaPersonal.CICATRIZ);
		
		Assert.assertEquals(computadora.emitirOrdenDeArresto(), "cicatriz");
	}
	
	@Test
	public void noPuedoEmitirOrdenDeArrestoPorqueMuchosSospechososTienenLaCaracteristicaIngresada() {
		Ladron hombre = new Ladron("hombre", Sexo.MASCULINO, Pelo.NEGRO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron hombre2 = new Ladron("hombre2", Sexo.MASCULINO, Pelo.RUBIO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(hombre);
		sospechosos.add(hombre2);
		
		Computadora computadora = new Computadora(sospechosos);
		
		computadora.setCaracteristicaDelLadron(Sexo.MASCULINO);
		
		Assert.assertEquals(computadora.emitirOrdenDeArresto(), "");
	}
	
	@Test 
	public void ordenDeArrestoEmitidaDevuelveFalseSiNoEmitoOrden() {
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		
		Computadora computadora = new Computadora(sospechosos);
		
		Assert.assertFalse(computadora.ordenDeArrestoEmitida());
	}
	
	@Test
	public void ordenDeArrestoEmitidaDevuelveFalseSinoPudeEmitirOrdenDeArrestoPorqueMuchosSospechososTienenLaCaracteristicaIngresada() {
		Ladron hombre = new Ladron("hombre", Sexo.MASCULINO, Pelo.NEGRO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron hombre2 = new Ladron("hombre2", Sexo.MASCULINO, Pelo.RUBIO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(hombre);
		sospechosos.add(hombre2);
		
		Computadora computadora = new Computadora(sospechosos);
		
		computadora.setCaracteristicaDelLadron(Sexo.MASCULINO);
		computadora.emitirOrdenDeArresto();
		
		Assert.assertFalse(computadora.ordenDeArrestoEmitida());
	}
	
	@Test
	public void ordenDeArrestoEmitidaDevuelveTrueSiEmitoOrden() {
		Ladron hombre = new Ladron("hombre", Sexo.MASCULINO, Pelo.NEGRO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		Ladron mujer = new Ladron("mujer", Sexo.FEMENINO, Pelo.RUBIO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE);
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(hombre);
		sospechosos.add(mujer);
		
		Computadora computadora = new Computadora(sospechosos);
		
		computadora.setCaracteristicaDelLadron(Sexo.FEMENINO);
		computadora.emitirOrdenDeArresto();
		
		Assert.assertTrue(computadora.ordenDeArrestoEmitida());
	}
}