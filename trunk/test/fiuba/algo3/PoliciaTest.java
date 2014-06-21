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

    @Test
    public void setRangoCambiaElRangoDelPolicia() {
        Policia unPolicia = new Policia("Andrew", new Ciudad("Brujas", new Coordenada(3,5)));
        Rango detective = new Detective();

        unPolicia.setRango(detective);

        Assert.assertEquals(unPolicia.getRango(), detective);
    }
	
	@Test
	public void yaVisitoTresEdificiosDevuelveTrueSiVisitaTresEdificios() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
		
		unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
		unPolicia.visitarEdificioTransporte();
		
		Assert.assertTrue(unPolicia.yaVisitoTresEdificios());
	}
	
	@Test
	public void yaVisitoTresEdificiosDevuelveFalseSiNoVisitaEdificios() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
		
		Assert.assertFalse(unPolicia.yaVisitoTresEdificios());
	}
	
	@Test
	public void yaVisitoTresEdificiosDevuelveTrueSiVisitaMenosDeTresEdificios() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
		
		unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
		
		Assert.assertFalse(unPolicia.yaVisitoTresEdificios());
	}

    @Test
    public void viajarAUnaCiudadSiTieneTiempoCambiaLaCiudadActual() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

		unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadDestino);
    }

	@Test
    public void viajarAUnaCiudadSiTieneTiempoLeRestaElTiempoCorrespondiente() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 3);
    }

    @Test (expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void viajarAUnaCiudadSiNoLeQuedaTiempoLanzaExcepcion() throws ExcepcionJugadorSinTiempoDisponible {
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        unPolicia.setTiempoDisponible(1);

        unPolicia.viajar(ciudadDestino);
    }

	@Test (expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void viajarAUnaCiudadSiNoLeQuedaTiempoLanzaExcepcionYNoCambiaLaCiudadActual() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        unPolicia.setTiempoDisponible(1);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadSalida);
    }

	@Test (expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void viajarAUnaCiudadConectadaSiNoLeQuedaTiempoLanzaExcepcionYNoLeRestaTiempo() throws ExcepcionJugadorSinTiempoDisponible{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));
        int tiempoDelPolicia = 1;

        unPolicia.setTiempoDisponible(tiempoDelPolicia);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), tiempoDelPolicia);
    }
	
	@Test
	public void yaVisitoTresEdificiosDevuelveFalseSiVisitaTresEdificiosYLuegoViaja() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas", ciudadSalida);
		Ciudad ciudadDestino = new Ciudad("Pekin", new Coordenada(6000, 1000));
		
		unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
		unPolicia.visitarEdificioTransporte();
		
		unPolicia.viajar(ciudadDestino);
		
		Assert.assertFalse(unPolicia.yaVisitoTresEdificios());
	}
	
	@Test
	public void visitarUnEdificioDevuelveUnaPista() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio", ciudadSalida);

        Assert.assertEquals(unPolicia.visitarEdificioEconomia(), Pista.PISTA_POR_DEFECTO_LUGAR);
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
	
	// @Test
	// public void elPoliciaVisita

    @Test
    public void emitirOrdenDeArrestoDevuelveElNombreDelLadronSiEmitioOrdenDeArrestoContraAlgunLadron() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
        
        Assert.assertEquals(unPolicia.emitirOrdenDeArresto(computadora), "Jaime");
    }

    @Test
    public void emitirOrdenDeArrestoDevuelveElNombreDelLadronSiEmitioOrdenDeArrestoContraUnSospechosoQueNoEsElBuscado() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);

        Assert.assertEquals(unPolicia.emitirOrdenDeArresto(computadora), "Tomas");
    }

    @Test
    public void emitirOrdenDeArrestoDevuelveUnStringVacioSiHayMasDeUnSospechosoConLasCaracteristicasFijadas() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);

        Assert.assertEquals(unPolicia.emitirOrdenDeArresto(computadora), "");
    }
    
    @Test
    public void emitirOrdenDeArrestoRestaTiempoSiElLadronEsElBuscado() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
        unPolicia.emitirOrdenDeArresto(computadora);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO);
    }

    @Test
    public void emitirOrdenDeArrestoRestaTiempoSiElLadronNoEsElBuscado() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(buscado);
        Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        computadora.setSospechoso(sospechoso1);
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
        unPolicia.emitirOrdenDeArresto(computadora);

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
        unPolicia.emitirOrdenDeArresto(computadora);
    }

    @Test
    public void policiaArrestaAlLadron() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Pedro", ciudadSalida);
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
	
		unPolicia.arrestarAlLadron(buscado);
		
        Assert.assertTrue(buscado.estaArrestado());
    }
	
	@Test 
	public void recibirHeridaDescuentaTiempo() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
		Policia policia = new Policia("Juancito", ciudadSalida);
		
		policia.recibirHerida();
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	@Test (expected = ExcepcionJugadorSinTiempoDisponible.class)
	public void recibirHeridaLanzaExcepcionSiNoHayTiempo() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
		Policia policia = new Policia("Juancito", ciudadSalida);
		policia.setTiempoDisponible(1);
		
		policia.recibirHerida();
	}
}
