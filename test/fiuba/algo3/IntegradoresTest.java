package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class IntegradoresTest {
	@Test
	public void policiaDeRangoNovatoViajaATresPaisesYAtrapaAlLadronEmitiendoOrdenDeArrestoPrevia() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
		Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(-3000.0, -9000.0));
		Ciudad londres = new Ciudad("Londres", new Coordenada(-3000.0, -9000.0));
		Ciudad reykjavic = new Ciudad("Reykjavic", new Coordenada(-3000.0, -9000.0));
		Ciudad tokio = new Ciudad("Tokio", new Coordenada(9000.0, 1500.0));
		Policia unPolicia = new Policia("Esteban", buenosAires);
        Ladron unLadron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
        Computadora computadora = new Computadora(unLadron);

        buenosAires.conectarCiudad(londres);
        londres.conectarCiudad(reykjavic);
        reykjavic.conectarCiudad(tokio);
		tokio.setEstaElLadron();

        computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
		unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.MARRON);
		unPolicia.visitarEdificioTransporte();
		
		unPolicia.viajar(londres);
		unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
        computadora.setCaracteristicaDelLadron(Ladron.Hobby.ALPINISMO);
		unPolicia.visitarEdificioTransporte();
		
		unPolicia.viajar(reykjavic);
		unPolicia.visitarEdificioEconomia();
        computadora.setCaracteristicaDelLadron(Ladron.Auto.MOTO);
		unPolicia.visitarEdificioCultural();
		unPolicia.visitarEdificioTransporte();
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.TATUAJE);

        unPolicia.emitirOrdenDeArresto(computadora);
		
		unPolicia.viajar(tokio);
		unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioTransporte();
		
		if (computadora.ordenDeArrestoEmitidaContraLadronCorrecto()) {
			computadora.getLadronEncontrado().arrestar();
		}

		Assert.assertTrue(unLadron.estaArrestado());
	}

    @Test (expected = ExcepcionOrdenDeArrestoNoEmitida.class)
    public void policiaDeRangoDetectiveViajaATresPaisesYNoAtrapaAlLadronLanzaExcepcionPorNoEmitirOrdenDeArresto() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(-3000.0, -9000.0));
        Ciudad londres = new Ciudad("Londres", new Coordenada(-3000.0, -9000.0));
        Ciudad reykjavic = new Ciudad("Reykjavic", new Coordenada(-3000.0, -9000.0));
        Ciudad tokio = new Ciudad("Tokio", new Coordenada(9000.0, 1500.0));
        Policia unPolicia = new Policia("Esteban", buenosAires);
        Ladron unLadron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Computadora computadora = new Computadora(unLadron);
		
        unPolicia.setRango(new Detective());
        buenosAires.conectarCiudad(londres);
        londres.conectarCiudad(reykjavic);
        reykjavic.conectarCiudad(tokio);
		tokio.setEstaElLadron();

        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioTransporte();
		
        unPolicia.viajar(londres);
        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioTransporte();
		
        unPolicia.viajar(reykjavic);
        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioTransporte();

        unPolicia.viajar(tokio);
        unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioTransporte();
		
        if (computadora.ordenDeArrestoEmitidaContraLadronCorrecto()) {
			computadora.getLadronEncontrado().arrestar();
		}
    }

    @Test(expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void policiaDeRangoSargentoViajaPorLosPaisesYSeQuedaSinTiempo() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(0, -50000.0));
        Ciudad londres = new Ciudad("Londres", new Coordenada(0, 50000.0));
        Ciudad reykjavic = new Ciudad("Reykjavic", new Coordenada(0, 200000));
        Ciudad tokio = new Ciudad("Tokio", new Coordenada(9000.0, 1500.0));
        Policia unPolicia = new Policia("Esteban", buenosAires);
        Ladron unLadron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);

        unPolicia.setRango(new Sargento());
        buenosAires.conectarCiudad(londres);
        londres.conectarCiudad(reykjavic);
        reykjavic.conectarCiudad(tokio);

        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioTransporte();
		
        unPolicia.viajar(londres);
        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioTransporte();
        unPolicia.viajar(reykjavic);
    }
}
