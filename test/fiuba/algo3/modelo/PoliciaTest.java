package fiuba.algo3.modelo;

import java.util.ArrayList;
import org.junit.Test;
import junit.framework.Assert;

public class PoliciaTest {
    @Test
    public void unPoliciaIniciaConRangoNovatoPorDefecto() {
        Policia unPolicia = new Policia("Juan");

        Assert.assertEquals(unPolicia.getRango().getClass(), Novato.class);
    }
	
	@Test
	public void unPoliciaEmpiezaSinCiudadInicial() {
		Policia unPolicia = new Policia("Juan");

        Assert.assertNull(unPolicia.getCiudadActual());
	}

    @Test
    public void unPoliciaIniciaConTiempoDisponibleDistintoDeCero() {
        Policia unPolicia = new Policia("Juan");

        Assert.assertNotSame(unPolicia.getTiempoDisponible(), 0);
    }

    @Test
    public void getTiempoDisponibleDevuelveElTiempoQueLeQuedaAlPolicia() {
        Policia unPolicia = new Policia("Pepe");

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL);
    }

    @Test
    public void setRangoCambiaElRangoDelPolicia() {
        Policia unPolicia = new Policia("Andrew");
        Rango detective = new Detective();

        unPolicia.setRango(detective);

        Assert.assertEquals(unPolicia.getRango(), detective);
    }
	
	@Test
	public void getCiudadActualDevuelveLaCiudadDondeEstaElPolicia() throws ExcepcionTiempoAgotado {
		Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas");
		unPolicia.setCiudadActual(ciudadSalida);
		
		Assert.assertEquals(unPolicia.getCiudadActual(), ciudadSalida);
	}

    @Test
    public void viajarAUnaCiudadSiTieneTiempoCambiaLaCiudadActual() throws ExcepcionTiempoAgotado {
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas");
		unPolicia.setCiudadActual(ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

		unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadDestino);
    }

	@Test
    public void viajarAUnaCiudadSiTieneTiempoLeRestaElTiempoCorrespondiente() throws ExcepcionTiempoAgotado{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas");
		unPolicia.setCiudadActual(ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 3);
    }

    @Test (expected = ExcepcionTiempoAgotado.class)
    public void viajarAUnaCiudadSiNoLeQuedaTiempoLanzaExcepcion() throws ExcepcionTiempoAgotado {
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas");
		unPolicia.setCiudadActual(ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        unPolicia.setTiempoDisponible(1);

        unPolicia.viajar(ciudadDestino);
    }

	@Test (expected = ExcepcionTiempoAgotado.class)
    public void viajarAUnaCiudadSiNoLeQuedaTiempoLanzaExcepcionYNoCambiaLaCiudadActual() throws ExcepcionTiempoAgotado{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas");
		unPolicia.setCiudadActual(ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));

        unPolicia.setTiempoDisponible(1);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getCiudadActual(), ciudadSalida);
    }

	@Test (expected = ExcepcionTiempoAgotado.class)
    public void viajarAUnaCiudadConectadaSiNoLeQuedaTiempoLanzaExcepcionYNoLeRestaTiempo() throws ExcepcionTiempoAgotado{
        Ciudad ciudadSalida = new Ciudad("Madrid", new Coordenada(3000, 5000));
        Policia unPolicia = new Policia("Nicolas");
		unPolicia.setCiudadActual(ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Moscu", new Coordenada(1000, 3000));
        int tiempoDelPolicia = 1;

        unPolicia.setTiempoDisponible(tiempoDelPolicia);
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), tiempoDelPolicia);
    }
	
	@Test
	public void visitarUnEdificioDevuelveUnaPista() throws ExcepcionTiempoAgotado {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio");
		unPolicia.setCiudadActual(ciudadSalida);

        Assert.assertEquals(unPolicia.visitarEdificioEconomia(), Pista.PISTA_POR_DEFECTO_LUGAR);
	}

	@Test
	public void visitarUnEdificioRestaUnaHora() throws ExcepcionTiempoAgotado {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio");
		unPolicia.setCiudadActual(ciudadSalida);

        unPolicia.visitarEdificioEconomia();

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 1);
	}

	@Test
	public void visitarDosEdificiosRestaTresHoras() throws ExcepcionTiempoAgotado {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio");
		unPolicia.setCiudadActual(ciudadSalida);

        unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 3);
	}

	@Test
	public void visitarTresEdificiosRestaSeisHoras() throws ExcepcionTiempoAgotado {
		Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio");
		unPolicia.setCiudadActual(ciudadSalida);

        unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
		unPolicia.visitarEdificioTransporte();

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - 6);
	}

    @Test(expected = ExcepcionTiempoAgotado.class)
    public void visitarEdificioSinTiempoDisponibleLanzaExcepcion() throws ExcepcionTiempoAgotado {
        Ciudad ciudadSalida = new Ciudad("Paris", new Coordenada(200, 100));
        Policia unPolicia = new Policia("Antonio");
		unPolicia.setCiudadActual(ciudadSalida);

        unPolicia.setTiempoDisponible(0);
        unPolicia.visitarEdificioEconomia();
    }

    @Test
    public void emitirOrdenDeArrestoDevuelveElNombreDelLadronSiEmitioOrdenDeArrestoContraAlgunLadron() throws ExcepcionTiempoAgotado {
        Policia unPolicia = new Policia("Pedro");
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
                
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(buscado);
		sospechosos.add(sospechoso1);
		
        Computadora computadora = new Computadora(sospechosos);
		
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
        
        Assert.assertEquals(unPolicia.emitirOrdenDeArresto(computadora), "Jaime");
    }

    @Test
    public void emitirOrdenDeArrestoDevuelveElNombreDelLadronSiEmitioOrdenDeArrestoContraUnSospechosoQueNoEsElBuscado() throws ExcepcionTiempoAgotado {
		Policia unPolicia = new Policia("Pedro");
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
                
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
        Computadora computadora = new Computadora(sospechosos);
		
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);

        Assert.assertEquals(unPolicia.emitirOrdenDeArresto(computadora), "Tomas");
    }

    @Test
    public void emitirOrdenDeArrestoDevuelveUnStringVacioSiHayMasDeUnSospechosoConLasCaracteristicasFijadas() throws ExcepcionTiempoAgotado {
        Policia unPolicia = new Policia("Pedro");
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
                
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		sospechosos.add(buscado);
        
		Computadora computadora = new Computadora(sospechosos);
		
        computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);

        Assert.assertEquals(unPolicia.emitirOrdenDeArresto(computadora), "");
    }
    
    @Test
    public void emitirOrdenDeArrestoRestaTiempoSiElLadronEsElBuscado() throws ExcepcionTiempoAgotado {
        Policia unPolicia = new Policia("Pedro");
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
        Computadora computadora = new Computadora(sospechosos);
		
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
        unPolicia.emitirOrdenDeArresto(computadora);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO);
    }

    @Test
    public void emitirOrdenDeArrestoRestaTiempoSiElLadronNoEsElBuscado() throws ExcepcionTiempoAgotado {
        Policia unPolicia = new Policia("Pedro");
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
		Computadora computadora = new Computadora(sospechosos);
		
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
        unPolicia.emitirOrdenDeArresto(computadora);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_EMITIR_ORDEN_DE_ARRESTO);
    }

    @Test(expected = ExcepcionTiempoAgotado.class)
    public void emitirOrdenDeArrestoSinTiempoLanzaExcepcion() throws ExcepcionTiempoAgotado {
        Policia unPolicia = new Policia("Pedro");
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
        
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		
        Computadora computadora = new Computadora(sospechosos);
		
        unPolicia.setTiempoDisponible(2);
        unPolicia.emitirOrdenDeArresto(computadora);
    }

    @Test
    public void policiaArrestaAlLadron() throws ExcepcionTiempoAgotado {
        Policia unPolicia = new Policia("Pedro");
        Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.CROQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
	
		unPolicia.arrestarA(buscado);
		
        Assert.assertTrue(buscado.estaArrestado());
    }
	
	@Test 
	public void recibirHeridaDescuentaTiempo() throws ExcepcionTiempoAgotado {
		Policia policia = new Policia("Juancito");
		
		policia.recibirHerida();
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	@Test (expected = ExcepcionTiempoAgotado.class)
	public void recibirHeridaLanzaExcepcionSiNoHayTiempo() throws ExcepcionTiempoAgotado {
		Policia policia = new Policia("Juancito");
		policia.setTiempoDisponible(1);
		
		policia.recibirHerida();
	}
	
	@Test
	public void elPoliciaNovatoNoAsciendeSiNoTieneLaCantidadDeCasosNecesarios() {
		Policia unPolicia = new Policia("Pedro");
		
		unPolicia.ascender();
		
		Assert.assertEquals(unPolicia.getRango().getClass(), Novato.class);
	}
	
	@Test
	public void elPoliciaNovatoAsciendeSiTiene5CasosResueltos() {
		Policia unPolicia = new Policia("Pedro");
		
		unPolicia.resolvioUnCaso();
		unPolicia.resolvioUnCaso();
		unPolicia.resolvioUnCaso();
		unPolicia.resolvioUnCaso();
		unPolicia.resolvioUnCaso();
		
		unPolicia.ascender();
		
		Assert.assertEquals(unPolicia.getRango().getClass(), Detective.class);
	}
	
	@Test
	public void elPoliciaNovatoQueFueAscendidoSiEsReseteadoMantieneElRango() {
		Policia unPolicia = new Policia("Pedro");
		
		unPolicia.resolvioUnCaso();
		unPolicia.resolvioUnCaso();
		unPolicia.resolvioUnCaso();
		unPolicia.resolvioUnCaso();
		unPolicia.resolvioUnCaso();
		
		unPolicia.ascender();
		
		unPolicia.resetear();
		
		Assert.assertEquals(unPolicia.getRango().getClass(), Detective.class);
	}
}
