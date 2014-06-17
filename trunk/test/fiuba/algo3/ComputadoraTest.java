package fiuba.algo3;

import org.junit.Test;

import fiuba.algo3.Ladron.Hobby;
import fiuba.algo3.Ladron.Pelo;
import fiuba.algo3.Ladron.Sexo;
import junit.framework.Assert;

public class ComputadoraTest {
    @Test

    public void obtenerSospechososDevuelveUnaListaConSoloElLadronBuscadoSiNoSeAgregaronOtrosYNoHayFiltro() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);

        Assert.assertTrue(computadora.obtenerSospechosos().get(0)== buscado);
    }
    @Test
    public void obtenerSospechososDevuelveUnaListaConTodosLosSospechososSiNoHayFiltro() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso2 = new Ladron("Graciela", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso3 = new Ladron("Carla", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setSospechoso(sospechoso2);
        computadora.setSospechoso(sospechoso3);

        Assert.assertTrue(computadora.obtenerSospechosos().get(0)== buscado);
        Assert.assertTrue(computadora.obtenerSospechosos().get(1)== sospechoso1);
        Assert.assertTrue(computadora.obtenerSospechosos().get(2)== sospechoso2);
        Assert.assertTrue(computadora.obtenerSospechosos().get(3)== sospechoso3);
    }

    @Test
    public void obtenerSospechososDevuelveUnaListaDiferenteSiSeLeCambiaUnParametroDelMismoTipo() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteritica (Pelo.NEGRO);
        Assert.assertTrue(computadora.obtenerSospechosos().size()== 1);
        Assert.assertTrue(computadora.obtenerSospechosos().get(0)== buscado);
        Assert.assertFalse(computadora.obtenerSospechosos().get(0)== sospechoso1);
        computadora.setCaracteritica (Pelo.RUBIO);
        Assert.assertTrue(computadora.obtenerSospechosos().size()== 1);
        Assert.assertTrue(computadora.obtenerSospechosos().get(0)== sospechoso1);
        Assert.assertFalse(computadora.obtenerSospechosos().get(0)== buscado);

    }

    @Test
    public void obtenerSospechososDevuelveUnaLIstaVaciaSiSeAgreganFiltrosQueNoCorrespondenANinguno() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso2 = new Ladron("Graciela", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso3 = new Ladron("Carla", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setSospechoso(sospechoso2);
        computadora.setSospechoso(sospechoso3);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteritica (Pelo.NEGRO);
        Assert.assertTrue(computadora.obtenerSospechosos().size()== 2);
        Assert.assertTrue(computadora.obtenerSospechosos().get(0)== buscado);
        Assert.assertTrue(computadora.obtenerSospechosos().get(1)== sospechoso2);
        computadora.setCaracteritica (Sexo.FEMENINO);
        Assert.assertTrue(computadora.obtenerSospechosos().size()== 1);
        Assert.assertTrue(computadora.obtenerSospechosos().get(0)== sospechoso2);
        computadora.setCaracteritica (Hobby.CROQUET);
        Assert.assertTrue(computadora.obtenerSospechosos().size()== 0);

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

        computadora.setCaracteritica (Pelo.NEGRO);

        computadora.setCaracteritica (Sexo.MASCULINO);
        Assert.assertEquals(computadora.obtenerSospechosos().size(), 1);
        Assert.assertTrue(computadora.obtenerSospechosos().get(0)== buscado);
        Assert.assertTrue(computadora.emitirOrdenDeArresto() );

    }

    @Test
    public void emitirOrdenDeArrestoDevuelveFalseSiQuedamasDeUnSospechosoONoEsElBuscado() {
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso2 = new Ladron("Graciela", Ladron.Sexo.FEMENINO, Ladron.Pelo.NEGRO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso3 = new Ladron("Carla", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setSospechoso(sospechoso2);
        computadora.setSospechoso(sospechoso3);

        computadora.setCaracteritica (Pelo.NEGRO);
        Assert.assertTrue(computadora.obtenerSospechosos().size()== 2);
        Assert.assertTrue(computadora.obtenerSospechosos().get(0)== buscado);
        Assert.assertTrue(computadora.obtenerSospechosos().get(1)== sospechoso2);
        Assert.assertFalse(computadora.emitirOrdenDeArresto() );

        computadora.setCaracteritica (Sexo.FEMENINO);
        Assert.assertTrue(computadora.obtenerSospechosos().size()== 1);
        Assert.assertTrue(computadora.obtenerSospechosos().get(0)== sospechoso2);
        Assert.assertFalse(computadora.emitirOrdenDeArresto() );

    }


}
