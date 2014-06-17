package fiuba.algo3;

import org.junit.Test;

import junit.framework.Assert;

public class ComputadoraTest {
    @Test
    public void emitirOrdenDeArrestoDevuelveTrueSiElUnicoSospechosoQueCoincideConLosFiltrosEsElBuscado() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);

        computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
        computadora.setCaracteristicaDelLadron(Ladron.Hobby.CROQUET);
        computadora.setCaracteristicaDelLadron(Ladron.Auto.CONVERTIBLE);
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.CICATRIZ);

        Assert.assertTrue(computadora.emitirOrdenDeArresto());
    }

    @Test
    public void emitirOrdenDeArrestoDevuelveFalseSiElUnicoSospechosoQueCumpleConLosFiltrosNoEsElBuscado() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso1 = new Ladron("Pablo", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
        computadora.setCaracteristicaDelLadron(Ladron.Hobby.TENNIS);
        computadora.setCaracteristicaDelLadron(Ladron.Auto.MOTO);
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.CICATRIZ);

        Assert.assertFalse(computadora.emitirOrdenDeArresto());
    }

    @Test
    public void emitirOrdenDeArrestoDevuelveFalseSiNoHayUnUnicoSospechosoQueCumplaConLosFiltros() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso1 = new Ladron("Pablo", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.CICATRIZ);

        Assert.assertFalse(computadora.emitirOrdenDeArresto());
    }

    @Test
    public void getSospechososFiltradosDevuelveSoloAlLadronBuscadoSiEsElUnicoEnLaComputadora() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);

        computadora.emitirOrdenDeArresto();
        
        Assert.assertTrue(computadora.getSospechososFiltrados().get(0) == buscado);
        Assert.assertTrue(computadora.getSospechososFiltrados().size() == 1);
    }

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

        computadora.emitirOrdenDeArresto();
        
        Assert.assertTrue(computadora.getSospechososFiltrados().size() == 4);
    }

    @Test
    public void getSospechososFiltradosDevuelveUnaListaDiferenteSiSeLeCambiaUnaCaracteristicaDelMismoTipo() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
        computadora.emitirOrdenDeArresto();
        Assert.assertTrue(computadora.getSospechososFiltrados().size()== 1);
        Assert.assertTrue(computadora.getSospechososFiltrados().get(0)== buscado);
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
        computadora.emitirOrdenDeArresto();
        Assert.assertTrue(computadora.getSospechososFiltrados().size()== 1);
        Assert.assertTrue(computadora.getSospechososFiltrados().get(0)== sospechoso1);
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
    public void emitirOrdenDeArrestoDevuelveTrueSiSoloQuedaUnSospechosoYEsElBuscado() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso2 = new Ladron("Graciela", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso3 = new Ladron("Carla", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setSospechoso(sospechoso2);
        computadora.setSospechoso(sospechoso3);

        computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
        computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);

        Assert.assertTrue(computadora.emitirOrdenDeArresto());
        Assert.assertEquals(computadora.getSospechososFiltrados().size(), 1);
        Assert.assertTrue(computadora.getSospechososFiltrados().get(0) == buscado);
    }
}
