package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class PoliciaTest {
    @Test
    public void unPoliciaIniciaConRangoNovatoPorDefecto() {
        Policia unPolicia = new Policia("Juan", new Ciudad("Praga", new Coordenada(3,5)));

        Assert.assertEquals(unPolicia.getRango().getClass(), Novato.class);
    }

    @Test
    public void unPoliciaIniciaConTiempoDisponibleDistintoDeCero() {
        Policia unPolicia = new Policia("Juan", new Ciudad("Kiev", new Coordenada(3,5)));

        Assert.assertNotSame(unPolicia.getTiempoDisponible(), 0);
    }

    @Test
    public void getTiempoDisponibleDevuelveElTiempoQueLeQuedaAlPolicia() {
        Policia unPolicia = new Policia("Pepe", new Ciudad("Cardiff", new Coordenada(3,5)));

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL);
    }
/*
    @Test
    public void emitioLaOrdenDeArrestoContraElLadronCorrectoComienzaEnFalsePorDefecto() {
        Policia unPolicia = new Policia("Pepe", new Ciudad("Cardiff", new Coordenada(3,5)));

        Assert.assertFalse(unPolicia.emitioLaOrdenDeArrestoContraElLadronCorrecto());
    }
*/
    @Test
    public void setRangoCambiaElRangoDelPolicia() {
        Policia unPolicia = new Policia("Andrew", new Ciudad("Brujas", new Coordenada(3,5)));
        Rango detective = new Detective();

        unPolicia.setRango(detective);

        Assert.assertEquals(unPolicia.getRango(), detective);
    }

    @Test
    public void viajarAUnaCiudadConectadaSiTieneTiempoCambiaLaCiudadActual() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        ciudadSalida.conectarCiudad(ciudadDestino);
		unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadDestino);
    }

	@Test
    public void viajarAUnaCiudadConectadaSiTieneTiempoLeRestaTiempo() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        ciudadSalida.conectarCiudad(ciudadDestino);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 3);
    }

	@Test
    public void viajarAUnaCiudadConectadaSiTieneTiempoDevuelveTrue() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        ciudadSalida.conectarCiudad(ciudadDestino);

        Assert.assertTrue(unPolicia.viajar(ciudadDestino));
    }

    @Test
    public void viajarAUnaCiudadNoConectadaSiTieneTiempoDevuelveFalse() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        Assert.assertFalse(unPolicia.viajar(ciudadDestino));
    }

    @Test (expected=ExcepcionJugadorSinTiempoDisponible.class)
    public void viajarAUnaCiudadConectadaSiNoLeQuedaTiempoLanzaExcepcion() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        ciudadSalida.conectarCiudad(ciudadDestino);
        unPolicia.setTiempoDisponible(1);

        unPolicia.viajar(ciudadDestino);
    }

	@Test (expected=ExcepcionJugadorSinTiempoDisponible.class)
    public void viajarAUnaCiudadConectadaSiNoLeQuedaTiempoLanzaExcepcionYNoCambiaLaCiudadActual() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        unPolicia.setTiempoDisponible(1);
        ciudadSalida.conectarCiudad(ciudadDestino);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadSalida);
    }

	@Test (expected=ExcepcionJugadorSinTiempoDisponible.class)
    public void viajarAUnaCiudadConectadaSiNoLeQuedaTiempoLanzaExcepcionYNoLeRestaTiempo() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));
        int tiempoDelPolicia = 1;

        unPolicia.setTiempoDisponible(tiempoDelPolicia);
        ciudadSalida.conectarCiudad(ciudadDestino);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), tiempoDelPolicia);
    }

	@Test
	public void visitarUnEdificioRestaUnaHora() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio", ciudadSalida);

        unPolicia.visitarEdificioEconomia();

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 1);
	}

	@Test
	public void visitarDosEdificiosRestaTresHoras() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio", ciudadSalida);

        unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 3);
	}

	@Test
	public void visitarTresEdificiosRestaSeisHoras() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio", ciudadSalida);

        unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
		unPolicia.visitarEdificioTransporte();

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 6);
	}

    @Test(expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void visitarEdificioSinTiempoDisponibleLanzaExcepcion() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio", ciudadSalida);

        unPolicia.setTiempoDisponible(0);
        unPolicia.visitarEdificioEconomia();
    }
/*
    @Test
    public void emitioLaOrdenDeArrestoContraElLadronCorrectoDevuelveTrueSiLaOrdenFueEmitidaContraElLadronBuscado() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        unPolicia.emitirOrdenDeArresto(computadora, Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Assert.assertTrue(unPolicia.emitioLaOrdenDeArrestoContraElLadronCorrecto());
    }

    @Test
    public void emitioLaOrdenDeArrestoContraElLadronCorrectoDevuelveFalseSiLaOrdenNoFueEmitidaContraElLadronBuscado() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        unPolicia.emitirOrdenDeArresto(computadora, Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Assert.assertFalse(unPolicia.emitioLaOrdenDeArrestoContraElLadronCorrecto());
    }

    @Test
    public void emitirOrdenDeArrestoConTiempoLeRestaTiempoSiElLadronEsElBuscado() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        unPolicia.emitirOrdenDeArresto(computadora, Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO);
    }

    @Test
    public void emitirOrdenDeArrestoConTiempoLeRestaTiempoSiElLadronNoEsElBuscado() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        unPolicia.emitirOrdenDeArresto(computadora, Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO);
    }

    @Test
    public void emitirOrdenDeArrestoConTiempoLeRestaTiempoSiElLadronNoEstaEnLaComputadora() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        unPolicia.emitirOrdenDeArresto(computadora, Ladron.Sexo.FEMENINO, Ladron.Pelo.ROJO, Ladron.Hobby.TENNIS, Ladron.Auto.LIMUSINA, Ladron.MarcaPersonal.JOYAS);
        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO);
    }


    @Test(expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void emitirOrdenDeArrestoSinTiempoLanzaExcepcion() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        unPolicia.setTiempoDisponible(2);
        unPolicia.emitirOrdenDeArresto(computadora, Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
    }

    @Test
    public void policiaArrestaAlLadronSiVisitaLosTresEdificiosEnCualquierOrdenDeLaCiudadEnLaCualEstaYEmiteOrdenDeArrestoPreviamente() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);

        ciudadSalida.esconderLadron(buscado);
        unPolicia.emitirOrdenDeArresto(computadora, Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioTransporte();

        Assert.assertTrue(buscado.fueArrestado());
    }

    @Test
    public void policiaArrestaAlLadronSiVisitaLosTresEdificiosEnOrdenDeLaCiudadEnLaCualEstaYEmiteOrdenDeArrestoPreviamente() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);

        ciudadSalida.esconderLadron(buscado);
        unPolicia.emitirOrdenDeArresto(computadora, Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioTransporte();

        Assert.assertTrue(buscado.fueArrestado());
    }

    @Test
    public void policiaNoArrestaAlLadronSiNoEmiteOrdenDeArrestoPreviamenteYElLadronEscapa() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);

        ciudadSalida.esconderLadron(buscado);

        unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioTransporte();

        Assert.assertFalse(buscado.fueArrestado());
        Assert.assertTrue(buscado.seEscapo());
    }
*/
}
