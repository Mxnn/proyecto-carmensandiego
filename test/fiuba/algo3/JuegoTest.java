package fiuba.algo3;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.xml.sax.SAXException;

import fiuba.algo3.Ladron.Auto;
import fiuba.algo3.Ladron.Hobby;
import fiuba.algo3.Ladron.MarcaPersonal;
import fiuba.algo3.Ladron.Pelo;
import fiuba.algo3.Ladron.Sexo;
import junit.framework.Assert;

public class JuegoTest {
	
	@Test(expected = ExcepcionOrdenDeArrestoNoEmitida.class)
	public void AlCrearseUnaPartidaElPoliciaNoEstaAlFinalDelRecorridoNiElLadronEstaArrestado() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida {
		Juego juego=new Juego("Gonzalo");
		Assert.assertNotNull(juego);
		Ladron buscado= new Ladron ("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO);
		juego.crearPartida();
		
		Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());
		juego.corroborarQueElLadronBuscadoFueArrestado();
	}
	@Test(expected = ExcepcionTiempoAgotado.class)
	public void SeLanzaLaExcepcionDeTiempoAgotadoSiSeLeAcabaElTiempoALPoliciaPorPedirPistas() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		Juego juego=new Juego("Gonzalo");
		Assert.assertNotNull(juego);
		Ladron buscado= new Ladron ("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO);
		juego.crearPartida();
		
		
		for (int i=0; i<36; i+=1){
			juego.verPistaEconomia();
		}
		Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());
		juego.verPistaEconomia();

	}
	@Test(expected = ExcepcionTiempoAgotado.class)
	public void SeLanzaLaExcepcionDeTiempoAgotadoSiSeLeAcabaElTiempoALPoliciaPorViajar() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		Juego juego=new Juego("Gonzalo");
		Assert.assertNotNull(juego);
		Ladron buscado= new Ladron ("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO);
		juego.crearPartida();
		
		for (int i=0; i<106;i+=1){
			ArrayList<String> ciudadesPorRecorrer=juego.obtenerNombreDeLasCiudadesALasQuePuedoIr();
			juego.viajar(ciudadesPorRecorrer.get(0));
		}
	}

	
	@Test
	public void elPoliciaLlegoAlFinalDevuelveTrueSiEstaEnLaCiudadFinalYVisitoLosTresLugares() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		ArrayList <Ciudad>ciudades=new ArrayList<Ciudad>();
		ciudades.add (new Ciudad ("Buenos Aires",new Coordenada(5241.0,8475.0)));
		ciudades.add (new Ciudad ("Madrid",new Coordenada(4781.0,5379.0)));	
		ciudades.get(0).conectarCiudad(ciudades.get(1));
		ArrayList <Ladron>ladrones=new ArrayList<Ladron>();
		ladrones.add ( new Ladron ("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));
		ladrones.add ( new Ladron ("Juana", Sexo.FEMENINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));	
		Juego juego=new Juego("Gonzalo",ciudades,ladrones);
		Assert.assertNotNull(juego);
		juego.viajar("Madrid");
		Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());
		juego.verPistaCultural();
		juego.verPistaCultural();
		Assert.assertFalse(juego.elPoliciaLlegoAlFinalDelRecorrido());		
		juego.verPistaCultural();
		Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
	}
	
	@Test
	public void corroborarQueElLadronBUscadoFueArrestadoDevuelvoFalseSiSeEmitioUNaOrdenDeArrestoContraElLadronEquivocado() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		ArrayList <Ciudad>ciudades=new ArrayList<Ciudad>();
		ciudades.add (new Ciudad ("Buenos Aires",new Coordenada(5241.0,8475.0)));
		ciudades.add (new Ciudad ("Madrid",new Coordenada(4781.0,5379.0)));	
		ciudades.get(0).conectarCiudad(ciudades.get(1));
		ArrayList <Ladron>ladrones=new ArrayList<Ladron>();
		ladrones.add ( new Ladron ("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));
		ladrones.add ( new Ladron ("Juana", Sexo.FEMENINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));	
		Juego juego=new Juego("Gonzalo",ciudades,ladrones);
		
		juego.viajar("Madrid");
		juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.FEMENINO) ;
		juego.emitirOrdenDeArresto();
		juego.verPistaCultural();
		juego.verPistaCultural();
		juego.verPistaCultural();
		Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
		juego.arrestarAlLadron();
		Assert.assertFalse(juego.corroborarQueElLadronBuscadoFueArrestado());
	}
	@Test
	public void emitirOrdenDeArrestoDevuelveElNombreDelLadronBUscadoCUandoSeAplicanLosFiltrosCorectos() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		ArrayList <Ciudad>ciudades=new ArrayList<Ciudad>();
		ciudades.add (new Ciudad ("Buenos Aires",new Coordenada(5241.0,8475.0)));
		ciudades.add (new Ciudad ("Madrid",new Coordenada(4781.0,5379.0)));	
		ciudades.get(0).conectarCiudad(ciudades.get(1));
		ArrayList <Ladron>ladrones=new ArrayList<Ladron>();
		ladrones.add ( new Ladron ("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));
		ladrones.add ( new Ladron ("Juana", Sexo.FEMENINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));	
		Juego juego=new Juego("Gonzalo",ciudades,ladrones);
		
		juego.viajar("Madrid");
		Assert.assertEquals(juego.emitirOrdenDeArresto(),"");
		juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.MASCULINO) ;
		Assert.assertEquals(juego.emitirOrdenDeArresto(),"Juan");
		juego.verPistaCultural();
		juego.verPistaCultural();
		juego.verPistaCultural();
		Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
		juego.arrestarAlLadron();
		Assert.assertTrue(juego.corroborarQueElLadronBuscadoFueArrestado());
	}
	@Test
	public void corroborarQueElLadronBUscadoFueArrestadoCuandoEfectivamenteSePudoAtraparAlLadron() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		ArrayList <Ciudad>ciudades=new ArrayList<Ciudad>();
		ciudades.add (new Ciudad ("Buenos Aires",new Coordenada(5241.0,8475.0)));
		ciudades.add (new Ciudad ("Madrid",new Coordenada(4781.0,5379.0)));	
		ciudades.get(0).conectarCiudad(ciudades.get(1));
		ArrayList <Ladron>ladrones=new ArrayList<Ladron>();
		ladrones.add ( new Ladron ("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));
		ladrones.add ( new Ladron ("Juana", Sexo.FEMENINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));	
		Juego juego=new Juego("Gonzalo",ciudades,ladrones);
		
		juego.viajar("Madrid");
		juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.MASCULINO) ;
		juego.emitirOrdenDeArresto();
		juego.verPistaCultural();
		juego.verPistaCultural();
		juego.verPistaCultural();
		Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
		juego.arrestarAlLadron();
		Assert.assertTrue(juego.corroborarQueElLadronBuscadoFueArrestado());
	}	
	@Test(expected = ExcepcionOrdenDeArrestoNoEmitida.class)
	public void corroborarQueElLadronBUscadoNoFueArrestadoSiNoSeEmitioLaOrdenAunqueEsteEnLaCiudadFinal() 
	throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionOrdenDeArrestoNoEmitida, ExcepcionTiempoAgotado {
		ArrayList <Ciudad>ciudades=new ArrayList<Ciudad>();
		ciudades.add (new Ciudad ("Buenos Aires",new Coordenada(5241.0,8475.0)));
		ciudades.add (new Ciudad ("Madrid",new Coordenada(4781.0,5379.0)));	
		ciudades.get(0).conectarCiudad(ciudades.get(1));
		ArrayList <Ladron>ladrones=new ArrayList<Ladron>();
		ladrones.add ( new Ladron ("Juan", Sexo.MASCULINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));
		ladrones.add ( new Ladron ("Juana", Sexo.FEMENINO, Pelo.ROJO, Hobby.TENNIS, Auto.LIMUSINA, MarcaPersonal.ANILLO));	
		Juego juego=new Juego("Gonzalo",ciudades,ladrones);
		
		juego.viajar("Madrid");
		juego.verPistaCultural();
		juego.verPistaCultural();
		juego.verPistaCultural();
		Assert.assertTrue(juego.elPoliciaLlegoAlFinalDelRecorrido());
		juego.arrestarAlLadron();
		juego.corroborarQueElLadronBuscadoFueArrestado();
	}	
}