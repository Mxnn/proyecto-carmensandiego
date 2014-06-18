package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;
import java.util.ArrayList;

public class ComputadoraTest {
	@Test
    public void getSospechososFiltradosDevuelveUnaListaConTodosLosSospechososSiNoHayFiltro() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso2 = new Ladron("Graciela", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso3 = new Ladron("Carla", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setSospechoso(sospechoso2);
        computadora.setSospechoso(sospechoso3);
        
		ArrayList<Ladron> sospechososGuardados = computadora.getSospechososFiltrados();
        Assert.assertTrue(sospechososGuardados.size() == 4);
		Assert.assertEquals(sospechososGuardados.get(0), buscado);
		Assert.assertEquals(sospechososGuardados.get(1), sospechoso1);
		Assert.assertEquals(sospechososGuardados.get(2), sospechoso2);
		Assert.assertEquals(sospechososGuardados.get(3), sospechoso3);
    }

	@Test
    public void getSospechososFiltradosDevuelveUnaListaSinElSospechosoConUnaCaracteristicaFiltrada() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso2 = new Ladron("Graciela", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.ANILLO);
        Ladron sospechoso3 = new Ladron("Carla", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setSospechoso(sospechoso2);
        computadora.setSospechoso(sospechoso3);
        
		computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.CICATRIZ);
		
		ArrayList<Ladron> sospechososGuardados = computadora.getSospechososFiltrados();
        Assert.assertTrue(sospechososGuardados.size() == 3);
		Assert.assertEquals(sospechososGuardados.get(0), buscado);
		Assert.assertEquals(sospechososGuardados.get(1), sospechoso1);
		Assert.assertEquals(sospechososGuardados.get(2), sospechoso3);
    }
	
	@Test
    public void getSospechososFiltradosDevuelveUnaListaSinLosSospechososConDosCaracteristicasFiltradas() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso2 = new Ladron("Graciela", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.ANILLO);
        Ladron sospechoso3 = new Ladron("Carla", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setSospechoso(sospechoso2);
        computadora.setSospechoso(sospechoso3);
        
		computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
		computadora.setCaracteristicaDelLadron(Ladron.Hobby.ALPINISMO);
		
		ArrayList<Ladron> sospechososGuardados = computadora.getSospechososFiltrados();
        Assert.assertTrue(sospechososGuardados.size() == 1);
		Assert.assertEquals(sospechososGuardados.get(0), sospechoso1);
    }
	
    @Test
    public void getSospechososFiltradosDevuelveUnaListaDiferenteSiSeLeCambiaUnaCaracteristicaDelMismoTipo() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
        Assert.assertTrue(computadora.getSospechososFiltrados().size() == 1);
        Assert.assertTrue(computadora.getSospechososFiltrados().get(0) == buscado);
		
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
        Assert.assertTrue(computadora.getSospechososFiltrados().size() == 1);
        Assert.assertTrue(computadora.getSospechososFiltrados().get(0) == sospechoso1);
    }

    @Test
    public void getSospechososFiltradosDevuelveUnaListaVaciaSiSeAgreganFiltrosQueNoCorrespondenANingunSospechoso() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso2 = new Ladron("Graciela", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso3 = new Ladron("Carla", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setSospechoso(sospechoso2);
        computadora.setSospechoso(sospechoso3);

        computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
        computadora.setCaracteristicaDelLadron(Ladron.Sexo.FEMENINO);
        computadora.setCaracteristicaDelLadron(Ladron.Hobby.CROQUET);
        Assert.assertTrue(computadora.getSospechososFiltrados().isEmpty());
    }
	
	@Test
    public void hayUnSoloSospechosoDevuelveTrueSiSoloHayUnSospechosoFiltrado() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        
		Assert.assertTrue(computadora.hayUnSoloSospechoso());
    }
	
	@Test
    public void hayUnSoloSospechosoDevuelveFalseSiHayMasDeUnSospechosoFiltrado() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		computadora.setSospechoso(sospechoso1);
		
		Assert.assertFalse(computadora.hayUnSoloSospechoso());
    }
	
	@Test
    public void hayUnSoloSospechosoDevuelveTrueSiAplicoFiltrosYQuedaUnSoloSospechosoFiltrado() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		computadora.setSospechoso(sospechoso1);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
		
		Assert.assertTrue(computadora.hayUnSoloSospechoso());
    }
	
	@Test (expected = ExcepcionOrdenDeArrestoNoEmitida.class)
    public void ordenDeArrestoEmitidaContraElLadronCorrectoLanzaExcepcionSiNoSeEmitioOrden() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		computadora.setSospechoso(sospechoso1);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		
		computadora.ordenDeArrestoEmitidaContraLadronCorrecto();
    }
	
	@Test
    public void ordenDeArrestoEmitidaContraElLadronCorrectoDuelveTrueSiElSospechosoFiltradoEsElBuscado() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		computadora.setSospechoso(sospechoso1);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		
		computadora.emitirOrdenDeArresto();
		Assert.assertTrue(computadora.ordenDeArrestoEmitidaContraLadronCorrecto());
    }
	
	@Test
    public void ordenDeArrestoEmitidaContraElLadronCorrectoDuelveFalseSiElBuscadoNoRecibioOrdenDeArresto() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		computadora.setSospechoso(sospechoso1);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
		
		computadora.emitirOrdenDeArresto();
		Assert.assertFalse(computadora.ordenDeArrestoEmitidaContraLadronCorrecto());
    }
	
	@Test (expected = ExcepcionOrdenDeArrestoNoEmitida.class)
    public void getLadronBuscadoLanzaExcepcionSiNoSeEmitioOrden() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		computadora.setSospechoso(sospechoso1);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		
		computadora.getLadronBuscado();
    }
	
	@Test
    public void getLadronBuscadoDevuelveAlLadronBuscadoSiSeLeEmitioOrdenDeArresto() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		computadora.setSospechoso(sospechoso1);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		
		computadora.emitirOrdenDeArresto();
		Assert.assertEquals(computadora.getLadronBuscado(), buscado);
    }
	
	@Test
    public void getLadronBuscadoDevuelveAlBuscadoSiElSospechosoAlQueSeEmitioOrdenNoEsElBuscado() throws ExcepcionOrdenDeArrestoNoEmitida {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		computadora.setSospechoso(sospechoso1);
		computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
		
		computadora.emitirOrdenDeArresto();
		Assert.assertEquals(computadora.getLadronBuscado(), buscado);
    }
}
