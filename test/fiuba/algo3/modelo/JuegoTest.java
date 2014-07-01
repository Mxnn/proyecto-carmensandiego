// package fiuba.algo3.modelo;

// import java.io.IOException;
// import java.util.ArrayList;

// import javax.xml.parsers.ParserConfigurationException;
// import javax.xml.transform.TransformerException;

// import org.junit.Test;
// import org.xml.sax.SAXException;

// import fiuba.algo3.modelo.Ladron.Auto;
// import fiuba.algo3.modelo.Ladron.Hobby;
// import fiuba.algo3.modelo.Ladron.MarcaPersonal;
// import fiuba.algo3.modelo.Ladron.Pelo;
// import fiuba.algo3.modelo.Ladron.Sexo;
// import junit.framework.Assert;

// public class JuegoTest {
	// @Test
	// public void alCrearseUnaPartidaElPoliciaNoEstaAlFinalDelRecorrido() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida {
		// Juego juego = new Juego("Gonzalo");

		// juego.crearPartida();
		
		// Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());
	// }
	
	// @Test(expected = ExcepcionOrdenDeArrestoNoEmitida.class)
	// public void alCrearseUnaPartidaElLadronNoEstaArrestadoSeLanzaExcepcionOrdenDeArrestoNoEmitida() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida {
		// Juego juego = new Juego("Gonzalo");

		// juego.crearPartida();
		
		// juego.corroborarQueElLadronBuscadoFueArrestado();
	// }
	
	// @Test(expected = ExcepcionTiempoAgotado.class)
	// public void seLanzaLaExcepcionDeTiempoAgotadoSiSeLeAcabaElTiempoALPoliciaPorPedirPistas() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		// Juego juego = new Juego("Gonzalo");

		// juego.crearPartida();
		
		// for (int i = 0; i < 36; i++) {
			// juego.verPistaEconomia();
		// }
		
		// Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());
		// juego.verPistaEconomia();
	// }
	
	// @Test(expected = ExcepcionTiempoAgotado.class)
	// public void seLanzaLaExcepcionDeTiempoAgotadoSiSeLeAcabaElTiempoALPoliciaPorViajar() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		// Juego juego = new Juego("Gonzalo");

		// juego.crearPartida();
		
		// for (int i = 0; i < 1006; i++) {
			// ArrayList<String> ciudadesPorRecorrer = juego.obtenerNombreDeLasCiudadesALasQuePuedoIr();
			// juego.viajar(ciudadesPorRecorrer.get(0));
		// }
	// }
	
	// private Juego crearUnJuegoParaTests() {
		// ArrayList <Ciudad>ciudades = new ArrayList<Ciudad>();
		// ciudades.add(new Ciudad("Buenos Aires", new Coordenada(5241.0, 8475.0)));
		// ciudades.add(new Ciudad("Madrid", new Coordenada(4781.0, 5379.0)));	
		// ciudades.get(0).conectarCiudad(ciudades.get(1));
		
		// ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
		// ladrones.add(new Ladron("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));
		// ladrones.add(new Ladron("Juana", Sexo.FEMENINO, Pelo.RUBIO, Hobby.ALPINISMO, Auto.MOTO, MarcaPersonal.TATUAJE));	
		
		// Juego juego = new Juego("Gonzalo", ciudades, ladrones);
		// return juego;
	// }

	// @Test
	// public void elPoliciaLlegoAlFinalDevuelveTrueSiEstaEnLaCiudadFinalYVisitoLosTresLugares() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		// Juego juego = crearUnJuegoParaTests();
		
		// juego.viajar("Madrid");
		// Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());
		// juego.verPistaCultural();
		// juego.verPistaCultural();
		// Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());		
		// juego.verPistaCultural();
		// Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
	// }
	
	// @Test
	// public void elPoliciaLlegoAlFinalDevuelveFalseSiNoEstaEnLaCiudadFinalYVisitoLosTresLugares() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		// Juego juego = crearUnJuegoParaTests();
		
		// Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());
		// juego.verPistaCultural();
		// juego.verPistaCultural();
		// Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());		
		// juego.verPistaCultural();
		// Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());
	// }
	
	// @Test
	// public void corroborarQueElLadronBUscadoFueArrestadoDevuelvoFalseSiSeEmitioUNaOrdenDeArrestoContraElLadronEquivocado() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		// Juego juego = crearUnJuegoParaTests();
		
		// juego.viajar("Madrid");
		// juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.FEMENINO);
		// juego.emitirOrdenDeArresto();
		
		// juego.verPistaCultural();
		// juego.verPistaCultural();
		// juego.verPistaCultural();
		// Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
		
		// juego.arrestarAlLadron();
		// Assert.assertFalse(juego.corroborarQueElLadronBuscadoFueArrestado());
	// }
	
	// @Test
	// public void emitirOrdenDeArrestoDevuelveElNombreDelLadronBUscadoCUandoSeAplicanLosFiltrosCorectos() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		// Juego juego = crearUnJuegoParaTests();
		
		// juego.viajar("Madrid");
		// Assert.assertEquals(juego.emitirOrdenDeArresto(), "");
		// juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.ROJO);
		// Assert.assertEquals(juego.emitirOrdenDeArresto(), "Juan");
		
		// juego.verPistaCultural();
		// juego.verPistaCultural();
		// juego.verPistaCultural();
		
		// Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
		// juego.arrestarAlLadron();
		// Assert.assertTrue(juego.corroborarQueElLadronBuscadoFueArrestado());
	// }
	
	// @Test
	// public void corroborarQueElLadronBUscadoFueArrestadoCuandoEfectivamenteSePudoAtraparAlLadron() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		// Juego juego = crearUnJuegoParaTests();
		
		// juego.viajar("Madrid");
		// juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.TENNIS) ;
		// juego.emitirOrdenDeArresto();
		// juego.verPistaCultural();
		// juego.verPistaCultural();
		// juego.verPistaCultural();
		// Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
		// juego.arrestarAlLadron();
		// Assert.assertTrue(juego.corroborarQueElLadronBuscadoFueArrestado());
	// }
	
	// @Test(expected = ExcepcionOrdenDeArrestoNoEmitida.class)
	// public void corroborarQueElLadronBUscadoNoFueArrestadoSiNoSeEmitioLaOrdenAunqueEsteEnLaCiudadFinalYHayaVisitado3Edificios() 
	// throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		// Juego juego = crearUnJuegoParaTests();
		
		// juego.viajar("Madrid");
		// juego.verPistaCultural();
		// juego.verPistaTransporte();
		// juego.verPistaEconomia();
		// Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
		
		// juego.arrestarAlLadron();
		// juego.corroborarQueElLadronBuscadoFueArrestado();
	// }
	
	// public void elTiempoDisponibleDelPoliciaSeObtieneCorrectamenteComoString() {
		// Juego juego = crearUnJuegoParaTests();
		
		// Assert.assertEquals(juego.getTiempoDisponible(), Integer.toString(Policia.TIEMPO_DISPONIBLE_INICIAL));
	// }
	
	// public void puedoObtenerElNombreDeLaCiudadEnQueSeEncuentraElPolicia() {
		// Juego juego = crearUnJuegoParaTests();
		
		// Assert.assertEquals(juego.getCiudadActualDelPolicia(), "Buenos Aires");
	// }
// }