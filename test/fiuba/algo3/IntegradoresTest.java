package fiuba.algo3;

import java.util.ArrayList;
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
		
		buenosAires.conectarCiudad(londres);
        londres.conectarCiudad(reykjavic);
        reykjavic.conectarCiudad(tokio);
		tokio.escondeAlLadron();
		
		Policia policia = new Policia("Esteban");
		policia.setCiudadActual(buenosAires);
		
        Ladron unLadron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
        Computadora computadora = new Computadora(unLadron);
        
        ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(unLadron);
		computadora.setSospechosos(sospechosos);
        computadora.setCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
		policia.visitarEdificioEconomia();
		policia.visitarEdificioCultural();
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.MARRON);
		policia.visitarEdificioTransporte();
		
		policia.viajar(londres);
		policia.visitarEdificioEconomia();
		policia.visitarEdificioCultural();
        computadora.setCaracteristicaDelLadron(Ladron.Hobby.ALPINISMO);
		policia.visitarEdificioTransporte();
		
		policia.viajar(reykjavic);
		policia.visitarEdificioEconomia();
        computadora.setCaracteristicaDelLadron(Ladron.Auto.MOTO);
		policia.visitarEdificioCultural();
		policia.visitarEdificioTransporte();
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.TATUAJE);

        policia.emitirOrdenDeArresto(computadora);
		
		policia.viajar(tokio);
		policia.visitarEdificioCultural();
        policia.visitarEdificioEconomia();
        policia.visitarEdificioTransporte();
		
		policia.arrestarAlLadron(computadora.getLadronBuscado());

		Assert.assertTrue(unLadron.estaArrestado());
	}

    @Test (expected = ExcepcionOrdenDeArrestoNoEmitida.class)
    public void policiaDeRangoDetectiveViajaATresPaisesYNoAtrapaAlLadronLanzaExcepcionPorNoEmitirOrdenDeArresto() 
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(-3000.0, -9000.0));
        Ciudad londres = new Ciudad("Londres", new Coordenada(-3000.0, -9000.0));
        Ciudad reykjavic = new Ciudad("Reykjavic", new Coordenada(-3000.0, -9000.0));
        Ciudad tokio = new Ciudad("Tokio", new Coordenada(9000.0, 1500.0));
        Policia policia = new Policia("Esteban");
		policia.setCiudadActual(buenosAires);
        Ladron unLadron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Computadora computadora = new Computadora(unLadron);
		
        policia.setRango(new Detective());
        buenosAires.conectarCiudad(londres);
        londres.conectarCiudad(reykjavic);
        reykjavic.conectarCiudad(tokio);
		tokio.escondeAlLadron();

        policia.visitarEdificioEconomia();
        policia.visitarEdificioCultural();
        policia.visitarEdificioTransporte();
		
        policia.viajar(londres);
        policia.visitarEdificioEconomia();
        policia.visitarEdificioCultural();
        policia.visitarEdificioTransporte();
		
        policia.viajar(reykjavic);
        policia.visitarEdificioEconomia();
        policia.visitarEdificioCultural();
        policia.visitarEdificioTransporte();

        policia.viajar(tokio);
        policia.visitarEdificioCultural();
        policia.visitarEdificioEconomia();
        policia.visitarEdificioTransporte();
		
        policia.arrestarAlLadron(computadora.getLadronBuscado());
    }

    @Test(expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void policiaDeRangoSargentoViajaPorLosPaisesYSeQuedaSinTiempo()
	throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(0, -50000.0));
        Ciudad londres = new Ciudad("Londres", new Coordenada(0, 50000.0));
        Ciudad reykjavic = new Ciudad("Reykjavic", new Coordenada(0, 200000));
        Ciudad tokio = new Ciudad("Tokio", new Coordenada(9000.0, 1500.0));
        
		Policia policia = new Policia("Esteban");
		policia.setCiudadActual(buenosAires);
		policia.setRango(new Sargento());
		
        buenosAires.conectarCiudad(londres);
        londres.conectarCiudad(reykjavic);
        reykjavic.conectarCiudad(tokio);
		tokio.escondeAlLadron();

        policia.visitarEdificioEconomia();
        policia.visitarEdificioCultural();
        policia.visitarEdificioTransporte();
		
        policia.viajar(londres);
        policia.visitarEdificioEconomia();
        policia.visitarEdificioCultural();
        policia.visitarEdificioTransporte();
        policia.viajar(reykjavic);
    }

    @Test
    public void casoPruebaGrupo1AtrapaAlLadron()
            throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(-3000.0, -9000.0));
        Ciudad londres = new Ciudad("Londres", new Coordenada(-3000.0, -9000.0));
        Ciudad nuevaYork = new Ciudad("Nueva York", new Coordenada(-3000.0, -9000.0));
        Policia policia = new Policia("Esteban");
		policia.setCiudadActual(buenosAires);
        Ladron unLadron = new Ladron("Tylen Perez", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.TENNIS, Ladron.Auto.LIMUSINA, Ladron.MarcaPersonal.TATUAJE);
        Ladron sospechoso = new Ladron("John Wayne", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(unLadron);

        ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso);
		sospechosos.add(unLadron);
		computadora.setSospechosos(sospechosos);
        buenosAires.conectarCiudad(londres);
        londres.conectarCiudad(nuevaYork);
        nuevaYork.escondeAlLadron();

        buenosAires.getEdificioEconomia().setPistas(new Pista("Cambio dinero a libras esterlinas. Tenia el cabello marron"), null, null);
        buenosAires.getEdificioTransporte().setPistas(new Pista("El avion tenia colores rojo, blanco y azul. Llevaba raqueta de tenis"), null, null);
        londres.getEdificioCultural().setPistas(new Pista("Estaba mejorando su ingles americano"), null, null);
        londres.getEdificioEconomia().setPistas(new Pista("Compro dolares. Tenia un tatuaje"), null, null);
        londres.getEdificioTransporte().setPistas(new Pista("Se fue en un crucero con banderas con estrellas"), null, null);
        nuevaYork.getEdificioCultural().setPistas(new Pista("Te estas acercando"), null, null);
        nuevaYork.getEdificioEconomia().setPistas(new Pista("Hay gente que nunca antes habia visto"), null, null);
        nuevaYork.getEdificioTransporte().setPistas(new Pista("Pasan cosas extranias en la ciudad"), null, null);

        policia.visitarEdificioTransporte();
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.MARRON);
        policia.visitarEdificioEconomia();
        computadora.setCaracteristicaDelLadron(Ladron.Hobby.TENNIS);

        policia.viajar(londres);
        policia.visitarEdificioCultural();
        policia.visitarEdificioEconomia();
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.TATUAJE);
        policia.visitarEdificioTransporte();
        policia.emitirOrdenDeArresto(computadora);

        policia.viajar(nuevaYork);
        policia.visitarEdificioEconomia();
        policia.visitarEdificioCultural();
        policia.visitarEdificioTransporte();

        policia.arrestarAlLadron(computadora.getLadronBuscado());

        Assert.assertTrue(unLadron.estaArrestado());
    }

    @Test(expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void casoPruebaGrupo1NoAtrapaAlLadronYSeQuedaSinTiempo()
            throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad veracruz = new Ciudad("Veracruz", new Coordenada(1, 1));
        Ciudad milan = new Ciudad("Milan", new Coordenada(200000, 200000));
        Ciudad sidney = new Ciudad("Sidney", new Coordenada(5, 5));
        Ciudad nuevaYork = new Ciudad("Nueva York", new Coordenada(200000, 200000));
        Policia policia = new Policia("Esteban");
		policia.setCiudadActual(veracruz);

        veracruz.conectarCiudad(milan);
        milan.conectarCiudad(sidney);
        sidney.conectarCiudad(nuevaYork);
        nuevaYork.escondeAlLadron();

        veracruz.getEdificioCultural().setPistas(new Pista("Pregunto por un libro. Era mujer"), null, null);
        veracruz.getEdificioTransporte().setPistas(new Pista("Se movia con auto de bandera roja y blanca"), null, null);
        milan.getEdificioTransporte().setPistas(new Pista("Nunca vi a esa persona"), null, null);
        milan.getEdificioEconomia().setPistas(new Pista("Por aca pasa mucha gente"), null, null);
        sidney.getEdificioCultural().setPistas(new Pista("Probablemente lo vi, probablemente no"), null, null);
        sidney.getEdificioTransporte().setPistas(new Pista("No conozco a nadie asi"), null, null);
        nuevaYork.getEdificioCultural().setPistas(new Pista("Te estas acercando"), null, null);
        nuevaYork.getEdificioEconomia().setPistas(new Pista("Hay gente que nunca antes habia visto"), null, null);
        nuevaYork.getEdificioTransporte().setPistas(new Pista("Pasan cosas extranias en la ciudad"), null, null);

        policia.visitarEdificioTransporte();
        policia.visitarEdificioCultural();

        policia.viajar(milan);
        policia.visitarEdificioEconomia();
        policia.visitarEdificioTransporte();

        policia.viajar(sidney);
        policia.visitarEdificioCultural();
        policia.visitarEdificioTransporte();

        policia.viajar(nuevaYork);
    }

    @Test
    public void casoPruebaGrupo2ElLadronEsAtrapado()
            throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad paris = new Ciudad("Paris", new Coordenada(1, 1));
        Ciudad londres = new Ciudad("Londres", new Coordenada(2, 2));
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(3, 3));
        Ciudad ottawa = new Ciudad("Ottawa", new Coordenada(4, 4));
        Ciudad beijing = new Ciudad("Beijing", new Coordenada(5, 5));
        Policia policia = new Policia("Esteban");
		policia.setCiudadActual(buenosAires);
        Ladron unLadron = new Ladron("Zulma Lovato", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.LIMUSINA, Ladron.MarcaPersonal.TATUAJE);
        Ladron sospechoso = new Ladron("John Wayne", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(unLadron);

        ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso);
		sospechosos.add(unLadron);
		computadora.setSospechosos(sospechosos);
        paris.conectarCiudad(londres);
        londres.conectarCiudad(buenosAires);
        buenosAires.conectarCiudad(ottawa);
        ottawa.conectarCiudad(beijing);
        beijing.escondeAlLadron();

        paris.getEdificioEconomia().setPistas(new Pista("Pregunto por el cambio de libra esterlina. Era una mujer"), null, null);
        londres.getEdificioCultural().setPistas(new Pista("Pidio un libro de la colonizacion espaniola. Tenia un tatuaje en el brazo izquierdo"), null, null);
        buenosAires.getEdificioTransporte().setPistas(new Pista("Tenia una bandera con una hoja de arce. Dijo que le gustaba escalar montanias"), null, null);
        ottawa.getEdificioEconomia().setPistas(new Pista("Compro yenes. Era rubia"), null, null);
        beijing.getEdificioTransporte().setPistas(new Pista("Pasan cosas extranias en la ciudad"), null, null);
        beijing.getEdificioCultural().setPistas(new Pista("Hay gente que nunca antes habia visto"), null, null);
        beijing.getEdificioEconomia().setPistas(new Pista("Te estas acercando"), null, null);

        policia.visitarEdificioEconomia();
        computadora.setCaracteristicaDelLadron(Ladron.Sexo.FEMENINO);

        policia.viajar(londres);
        policia.visitarEdificioCultural();
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.TATUAJE);

        policia.viajar(buenosAires);
        policia.visitarEdificioTransporte();
        computadora.setCaracteristicaDelLadron(Ladron.Hobby.ALPINISMO);

        policia.viajar(ottawa);
        policia.visitarEdificioEconomia();
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);

        policia.emitirOrdenDeArresto(computadora);

        policia.viajar(beijing);
        policia.visitarEdificioEconomia();
        policia.visitarEdificioTransporte();
        policia.visitarEdificioCultural();

        policia.arrestarAlLadron(computadora.getLadronBuscado());

        Assert.assertTrue(unLadron.estaArrestado());
    }

    @Test(expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void casoPruebaGrupo2NoAtrapaAlLadronPorEmitirMalLaOrdenDeArresto()
            throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Ciudad hongKong = new Ciudad("Hong Kong", new Coordenada(200000, 200000));
        Ciudad tokio = new Ciudad("Tokio", new Coordenada(5, 5));
        Ciudad londres = new Ciudad("Londres", new Coordenada(200000, 200000));
        Policia policia = new Policia("Esteban");
		policia.setCiudadActual(buenosAires);
        Ladron ladron = new Ladron("Carmen SanDiego", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Ladron sospechoso = new Ladron("John Wayne", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(ladron);

        ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso);
		computadora.setSospechosos(sospechosos);
        buenosAires.conectarCiudad(hongKong);
        hongKong.conectarCiudad(tokio);
        tokio.conectarCiudad(londres);
        londres.escondeAlLadron();

        buenosAires.getEdificioCultural().setPistas(new Pista("Fue a un pais asiatico. Tenia una horrible cicatriz"), null, null);
        hongKong.getEdificioEconomia().setPistas(new Pista("Consulto por el tipo de cambio del yen"), null, null);
        hongKong.getEdificioTransporte().setPistas(new Pista("Fue a un pais con bandera blanca y roja. Llevaba una raqueta"), null, null);
        tokio.getEdificioEconomia().setPistas(new Pista("Pregunto por el tipo de cambio de la libra. Tenia el pelo rubio"), null, null);
        londres.getEdificioCultural().setPistas(new Pista("Te estas acercando"), null, null);
        londres.getEdificioEconomia().setPistas(new Pista("Hay gente que nunca antes habia visto"), null, null);
        londres.getEdificioTransporte().setPistas(new Pista("Pasan cosas extranias en la ciudad"), null, null);

        policia.visitarEdificioCultural();
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.CICATRIZ);

        policia.viajar(hongKong);
        policia.visitarEdificioEconomia();
        policia.visitarEdificioTransporte();
        computadora.setCaracteristicaDelLadron(Ladron.Hobby.ALPINISMO);

        policia.viajar(tokio);
        policia.visitarEdificioEconomia();
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.RUBIO);

        policia.emitirOrdenDeArresto(computadora);

        policia.viajar(londres);
        policia.visitarEdificioEconomia();
        policia.visitarEdificioTransporte();
        policia.visitarEdificioCultural();

        Assert.assertFalse(ladron.estaArrestado());
    }

    @Test
    public void casoPruebaGrupo4ElLadronEsAtrapado()
            throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad paris = new Ciudad("Paris", new Coordenada(1, 1));
        Ciudad londres = new Ciudad("Londres", new Coordenada(2, 2));
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(3, 3));
        Ciudad toronto = new Ciudad("Toronto", new Coordenada(4, 4));
        Ciudad barcelona = new Ciudad("Barcelona", new Coordenada(5, 5));
        Policia policia = new Policia("Esteban");
		policia.setCiudadActual(buenosAires);
        Ladron unLadron = new Ladron("Tylen Perez", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
        Ladron sospechoso = new Ladron("John Wayne", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(unLadron);

        ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso);
		sospechosos.add(unLadron);
		computadora.setSospechosos(sospechosos);
        buenosAires.conectarCiudad(paris);
        paris.conectarCiudad(toronto);
        toronto.conectarCiudad(londres);
        londres.conectarCiudad(barcelona);
        barcelona.escondeAlLadron();

        buenosAires.getEdificioCultural().setPistas(new Pista("Pidio un libro de la torre Eiffel"), null, null);
        paris.getEdificioTransporte().setPistas(new Pista("Tomo un avion con una bandera roja y blanco con una hoja en el medio"), null, null);
        toronto.getEdificioTransporte().setPistas(new Pista("Esta en el reino unido. Vino en moto"), null, null);
        toronto.getEdificioEconomia().setPistas(new Pista("Cambio dolares por libras"), null, null);
        londres.getEdificioTransporte().setPistas(new Pista("Tomo un crucero que recorre las costas del Mediterraneo"), null, null);
        londres.getEdificioCultural().setPistas(new Pista("Estaba leyendo un diccionario ingles-catalan"), null, null);
        londres.getEdificioEconomia().setPistas(new Pista("Cambio libras por euros. Tenia un tatuaje en el brazo"), null, null);
        barcelona.getEdificioTransporte().setPistas(new Pista("Pasan cosas extranias en la ciudad"), null, null);
        barcelona.getEdificioCultural().setPistas(new Pista("Hay gente que nunca antes habia visto"), null, null);
        barcelona.getEdificioEconomia().setPistas(new Pista("Te estas acercando"), null, null);

        policia.visitarEdificioCultural();

        policia.viajar(paris);
        policia.visitarEdificioTransporte();

        policia.viajar(toronto);
        policia.visitarEdificioTransporte();
        computadora.setCaracteristicaDelLadron(Ladron.Auto.MOTO);
        policia.visitarEdificioEconomia();

        policia.viajar(londres);
        policia.visitarEdificioEconomia();
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.TATUAJE);
        policia.visitarEdificioTransporte();
        policia.visitarEdificioCultural();

        policia.emitirOrdenDeArresto(computadora);

        policia.viajar(barcelona);
        policia.visitarEdificioEconomia();
        policia.visitarEdificioTransporte();
        policia.visitarEdificioCultural();

        policia.arrestarAlLadron(computadora.getLadronBuscado());

        Assert.assertTrue(unLadron.estaArrestado());
    }

    @Test(expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void casoPruebaGrupo4NoAtrapaAlLadronPorEmitirMalLaOrdenDeArresto()
            throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad toronto = new Ciudad("Toronto", new Coordenada(1, 1));
        Ciudad hongKong = new Ciudad("Hong Kong", new Coordenada(200000, 200000));
        Ciudad managua = new Ciudad("Managua", new Coordenada(5, 5));
        Policia policia = new Policia("Esteban");
		policia.setCiudadActual(hongKong);
        Ladron ladron = new Ladron("Carmen SanDiego", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);

        hongKong.conectarCiudad(toronto);
        toronto.conectarCiudad(managua);
        managua.escondeAlLadron();

        hongKong.getEdificioEconomia().setPistas(new Pista("Compro Dolares"), null, null);
        hongKong.getEdificioTransporte().setPistas(new Pista("Tomo un avion con estrellas y franjas rojas"), null, null);
        toronto.getEdificioEconomia().setPistas(new Pista("No vi a nadie con esas caracteristicas"), null, null);

        policia.visitarEdificioTransporte();
        policia.visitarEdificioEconomia();

        policia.viajar(toronto);
        policia.visitarEdificioEconomia();

        policia.viajar(managua);
        policia.visitarEdificioEconomia();

        Assert.assertFalse(ladron.estaArrestado());
    }

    @Test
     public void casoPruebaGrupo5ElLadronEsAtrapado()
            throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad paris = new Ciudad("Paris", new Coordenada(1, 1));
        Ciudad rio = new Ciudad("Rio de Janeiro", new Coordenada(2, 2));
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(3, 3));
        Policia policia = new Policia("Esteban");
		policia.setCiudadActual(rio);
        Ladron unLadron = new Ladron("Tylen Perez", Ladron.Sexo.MASCULINO, Ladron.Pelo.ROJO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
        Ladron sospechoso = new Ladron("John Wayne", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.CICATRIZ);
        Computadora computadora = new Computadora(unLadron);

        ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso);
		sospechosos.add(unLadron);
		computadora.setSospechosos(sospechosos);
        buenosAires.conectarCiudad(paris);
        rio.conectarCiudad(buenosAires);
        buenosAires.conectarCiudad(paris);
        paris.escondeAlLadron();

        buenosAires.getEdificioEconomia().setPistas(new Pista("Antiguamente la moneda oficial de su destino era el franco. Tenia un tatuaje"), null, null);
        rio.getEdificioTransporte().setPistas(new Pista("Se fue en un avion con bandera celeste y blanca. Tenia el pelo rojo"), null, null);
        paris.getEdificioTransporte().setPistas(new Pista("Pasan cosas extranias en la ciudad"), null, null);
        paris.getEdificioCultural().setPistas(new Pista("Hay gente que nunca antes habia visto"), null, null);
        paris.getEdificioEconomia().setPistas(new Pista("Te estas acercando"), null, null);

        policia.visitarEdificioTransporte();
        computadora.setCaracteristicaDelLadron(Ladron.Pelo.ROJO);

        policia.viajar(buenosAires);
        policia.visitarEdificioEconomia();
        computadora.setCaracteristicaDelLadron(Ladron.MarcaPersonal.TATUAJE);

        policia.viajar(paris);
        policia.visitarEdificioTransporte();
        policia.visitarEdificioEconomia();
        policia.visitarEdificioCultural();

        policia.emitirOrdenDeArresto(computadora);

        policia.arrestarAlLadron(computadora.getLadronBuscado());

        Assert.assertTrue(unLadron.estaArrestado());
    }

    @Test(expected = ExcepcionJugadorSinTiempoDisponible.class)
    public void casoPruebaGrupo5NoAtrapaAlLadronPorQuedarseSinTiempo()
            throws ExcepcionJugadorSinTiempoDisponible, ExcepcionOrdenDeArrestoNoEmitida {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1, 1));
        Ciudad rio = new Ciudad("Rio de Janeiro", new Coordenada(20000, 20000));
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(3, 3));
        Ciudad roma = new Ciudad("Roma", new Coordenada(-40000, -40000));
        Policia policia = new Policia("Esteban");
		policia.setCiudadActual(rio);
        Ladron ladron = new Ladron("John Bonachon", Ladron.Sexo.FEMENINO, Ladron.Pelo.RUBIO, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);

        rio.conectarCiudad(londres);
        rio.conectarCiudad(roma);
        rio.conectarCiudad(buenosAires);
        buenosAires.conectarCiudad(londres);
        londres.conectarCiudad(roma);
        londres.conectarCiudad(rio);
        roma.conectarCiudad(rio);
        buenosAires.escondeAlLadron();

        rio.getEdificioEconomia().setPistas(new Pista("La moneda oficial de su destino es el peso"), null, null);
        londres.getEdificioTransporte().setPistas(new Pista("Lo siento no hemos visto a nadie con esa descripcion por aqui"), null, null);
        roma.getEdificioEconomia().setPistas(new Pista("Lo siento no hemos visto a nadie con esa descripcion por aqui"), null, null);

        policia.visitarEdificioEconomia();

        policia.viajar(londres);
        policia.visitarEdificioTransporte();

        policia.viajar(rio);
        policia.viajar(roma);
        policia.visitarEdificioEconomia();

        policia.viajar(rio);
        policia.viajar(buenosAires);

        Assert.assertFalse(ladron.estaArrestado());
    }
}