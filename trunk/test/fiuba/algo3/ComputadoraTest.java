package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;
import java.util.ArrayList;

public class ComputadoraTest {
	@Test (expected = ExcepcionOrdenDeArrestoNoEmitida.class)
    public void ordenDeArrestoEmitidaContraElLadronCorrectoLanzaExcepcionSiNoSeEmitioOrden() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
		
		computadora.ordenDeArrestoEmitidaContraLadronCorrecto();
    }
	
	@Test
	public void emitirOrdenDeArrestoDevuelveElNombreDelLadronAlQueSeLeEmitioLaOrden() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
		
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		computadora.setSospechosos(sospechosos);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		
		Assert.assertEquals(computadora.emitirOrdenDeArresto(), "Jaime");
	}
	
	@Test
	public void emitirOrdenDeArrestoDevuelveUnStringVacioSiNoSeEmitioOrdenPorHaberMuchosSospechososQueCumplenLasCaracteristicas() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		computadora.setSospechosos(sospechosos);
		
		computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
		
		Assert.assertEquals(computadora.emitirOrdenDeArresto(), "");
	}
	
	@Test
	public void emitirOrdenDeArrestoDevuelveUnStringVacioSiNoSeEmitioOrdenPorNoAplicarFiltros() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		computadora.setSospechosos(sospechosos);
		
		Assert.assertEquals(computadora.emitirOrdenDeArresto(), "");
	}

	@Test (expected = ExcepcionOrdenDeArrestoNoEmitida.class)
    public void ordenDeArrestoEmitidaContraElLadronCorrectoLanzaExcepcionSiFiltraSospechososPeroNoSeEmitioOrden() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		computadora.setSospechosos(sospechosos);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		
		computadora.setSospechosos(sospechosos);
		computadora.setCaracteristicaDelLadron(Ladron.Hobby.CROQUET);
		
		computadora.ordenDeArrestoEmitidaContraLadronCorrecto();
		sospechosos.add(sospechoso1);
    }
	
	@Test
    public void ordenDeArrestoEmitidaContraElLadronCorrectoDuelveTrueSiElSospechosoFiltradoEsElBuscado() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		computadora.setSospechosos(sospechosos);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		
		computadora.emitirOrdenDeArresto();
		Assert.assertTrue(computadora.ordenDeArrestoEmitidaContraLadronCorrecto());
    }
	
	@Test
    public void ordenDeArrestoEmitidaContraElLadronCorrectoDuelveFalseSiElBuscadoNoRecibioOrdenDeArresto() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		computadora.setSospechosos(sospechosos);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
		
		computadora.emitirOrdenDeArresto();
		Assert.assertFalse(computadora.ordenDeArrestoEmitidaContraLadronCorrecto());
    }
	
	@Test (expected = ExcepcionOrdenDeArrestoNoEmitida.class)
    public void getLadronBuscadoLanzaExcepcionSiNoSeEmitioOrden() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		computadora.setSospechosos(sospechosos);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		
		computadora.getLadronBuscado();
    }
	
	@Test
    public void getLadronBuscadoDevuelveAlLadronBuscadoSiSeLeEmitioOrdenDeArresto() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		computadora.setSospechosos(sospechosos);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		
		computadora.emitirOrdenDeArresto();
		Assert.assertEquals(computadora.getLadronBuscado(), buscado);
    }
	
	@Test
    public void getLadronBuscadoDevuelveAlBuscadoSiElSospechosoAlQueSeEmitioOrdenNoEsElBuscado() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		computadora.setSospechosos(sospechosos);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
		
		computadora.emitirOrdenDeArresto();
		Assert.assertEquals(computadora.getLadronBuscado(), buscado);
    }
}
