package fiuba.algo3.modelo;

import org.junit.Test;
import junit.framework.Assert;

public class CiudadTest {
    @Test
    public void ciudadSeCreaConEdificiosPorDefecto() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));

        Assert.assertNotNull(ciudad.getEdificioCultural());
        Assert.assertNotNull(ciudad.getEdificioTransporte());
        Assert.assertNotNull(ciudad.getEdificioEconomia());
    }
	
	@Test
	public void getNombreDevuelveElNombreDeLaCiudad() {
		Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
		
		Assert.assertEquals(ciudad.getNombre(), "Buenos Aires");
	}
	
	@Test
    public void ciudadSeCreaSinCiudadesConectadas() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
		
        Assert.assertTrue(ciudad.getCiudadesConectadas().isEmpty());
    }
	
	@Test
    public void ciudadSeCreaYCantidadDeCiudadesConectadasEsCero() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
		
        Assert.assertTrue(ciudad.cantidadDeCiudadesConectadas() == 0);
    }

    @Test
    public void getCoordenadasDevuelveLasCoordenadasConLasCualesFueCreadaLaCiudad() {
        Coordenada coordenada = new Coordenada(1, 1);
        Ciudad ciudad = new Ciudad("Buenos Aires", coordenada);

        Assert.assertEquals(ciudad.getCoordenadas(), coordenada);
    }

    @Test
    public void setEdificioTransporteCambiaElEdificioDeTransporte() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Edificio nuevoEdificioTransporte = new Edificio();

        ciudad.setEdificioTransporte(nuevoEdificioTransporte);
        Assert.assertEquals(ciudad.getEdificioTransporte(), nuevoEdificioTransporte);
    }

    @Test
    public void setEdificioCulturalCambiaElEdificioDeCultural() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Edificio nuevoEdificioCultural = new Edificio();

        ciudad.setEdificioCultural(nuevoEdificioCultural);
        Assert.assertEquals(ciudad.getEdificioCultural(), nuevoEdificioCultural);
    }

    @Test
    public void setEdificioEconomiaCambiaElEdificioDeEconomia() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Edificio nuevoEdificioEconomia = new Edificio();

        ciudad.setEdificioEconomia(nuevoEdificioEconomia);
        Assert.assertEquals(ciudad.getEdificioEconomia(), nuevoEdificioEconomia);
    }
	
	@Test
    public void conectarCiudadConectaUnaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        Assert.assertEquals((londres.getCiudadesConectadas()).get(0), paris);
    }
	
	@Test
    public void conectarUnaCiudadCantidadDeCiudadesConectadasDevuelveUno() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        Assert.assertTrue(londres.cantidadDeCiudadesConectadas() == 1);
    }
	
	@Test
    public void cantidadDeCiudadesConectadasDevuelveUnoSiConectoUnaCiudadYAEsaLeConectoOtra() {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5, 7));
		Ciudad londres = new Ciudad("Londres", new Coordenada(4, 9));

        londres.conectarCiudad(paris);
		paris.conectarCiudad(buenosAires);
		
        Assert.assertTrue(londres.cantidadDeCiudadesConectadas() == 1);
		Assert.assertTrue(paris.cantidadDeCiudadesConectadas() == 2);
    }
	
	@Test
    public void getCiudadesConectadasDevuelveATodasLasCiudadesQueSeConectaron() {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5, 7));
		Ciudad londres = new Ciudad("Londres", new Coordenada(4, 9));

        londres.conectarCiudad(paris);
		londres.conectarCiudad(buenosAires);
		
        Assert.assertEquals((londres.getCiudadesConectadas()).get(0), paris);
		Assert.assertEquals((londres.getCiudadesConectadas()).get(1), buenosAires);
    }
	
	@Test
    public void estaConectadaConEstaCiudadDevuelveTrueSiLasCiudadesEstanConectadas() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        Assert.assertTrue(londres.estaConectadaConEstaCiudad(paris));
    }
	
	@Test
    public void estaConectadaConEstaCiudadDevuelveFalseSiLasCiudadesNoEstanConectadas() {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5, 7));
		Ciudad londres = new Ciudad("Londres", new Coordenada(4, 9));

        londres.conectarCiudad(paris);
		londres.conectarCiudad(buenosAires);
	
		Assert.assertFalse(paris.estaConectadaConEstaCiudad(buenosAires));
    }
	
	@Test
    public void estaConectadaConEstaCiudadDevuelveTrueSiLasDosCiudadesEstanConectadas() {
        Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(1, 1));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5, 7));
		Ciudad londres = new Ciudad("Londres", new Coordenada(4, 9));

        londres.conectarCiudad(paris);
		londres.conectarCiudad(buenosAires);
		
        Assert.assertTrue(londres.estaConectadaConEstaCiudad(paris));
		Assert.assertTrue(londres.estaConectadaConEstaCiudad(buenosAires));
    }
	
	@Test
	public void conectarCiudadNoConectaAUnaCiudadConsigoMisma() {
		Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(1, 1));
		
		buenosAires.conectarCiudad(buenosAires);
		
		Assert.assertFalse(buenosAires.estaConectadaConEstaCiudad(buenosAires));
	}
	
	@Test
	public void conectarCiudadNoConectaUnaCiudadDosVecesALaMisma() {
		Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(1, 1));
		Ciudad paris = new Ciudad("Paris", new Coordenada(5, 7));
		
		buenosAires.conectarCiudad(paris);
		buenosAires.conectarCiudad(paris);
		
		Assert.assertTrue(buenosAires.cantidadDeCiudadesConectadas() == 1);
	}
	
	@Test
	public void recibirVisitaEdificioCulturalHiereAlPolicia() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.setHierenAlPolicia();
		
		String nombreConMenosDe8CaracteresYPar = "Melina";
		Policia policia = new Policia(nombreConMenosDe8CaracteresYPar);
		policia.setCiudadActual(londres);
		
		londres.recibirVisitaEdificioCultural(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	@Test (expected = ExcepcionTiempoAgotado.class)
	public void recibirVisitaEdificioCulturalSinTiempoLanzaExcepcion() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.setHierenAlPolicia();
		
		String nombreConMenosDe8CaracteresYPar = "Melina";
		Policia policia = new Policia(nombreConMenosDe8CaracteresYPar);
		policia.setCiudadActual(londres);
		policia.setTiempoDisponible(1);
		
		londres.recibirVisitaEdificioCultural(policia);
	}
	
	@Test
	public void recibirVisitaEdificioEconomiaHiereAlPolicia() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.setHierenAlPolicia();
		
		String nombreConMasDe8Caracteres = "Macarena";
		Policia policia = new Policia(nombreConMasDe8Caracteres);
		policia.setCiudadActual(londres);
		
		londres.recibirVisitaEdificioEconomia(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	@Test (expected = ExcepcionTiempoAgotado.class)
	public void recibirVisitaEdificioEconomiaSinTiempoLanzaExcepcion() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.setHierenAlPolicia();
		
		String nombreConMasDe8Caracteres = "Macarena";
		Policia policia = new Policia(nombreConMasDe8Caracteres);
		policia.setCiudadActual(londres);
		policia.setTiempoDisponible(1);
		
		londres.recibirVisitaEdificioEconomia(policia);
	}
	
	@Test
	public void recibirVisitaEdificioTransporteHiereAlPolicia() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.setHierenAlPolicia();
		
		String nombreConMenosDe8CaracteresEImpar = "Maria";
		Policia policia = new Policia(nombreConMenosDe8CaracteresEImpar);
		policia.setCiudadActual(londres);
		
		londres.recibirVisitaEdificioTransporte(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	@Test (expected = ExcepcionTiempoAgotado.class)
	public void recibirVisitaEdificioTransporteSinTiempoLanzaExcepcion() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.setHierenAlPolicia();
		
		String nombreConMenosDe8CaracteresEImpar = "Maria";
		Policia policia = new Policia(nombreConMenosDe8CaracteresEImpar);
		policia.setCiudadActual(londres);
		policia.setTiempoDisponible(1);
		
		londres.recibirVisitaEdificioTransporte(policia);
	}
	
	@Test
	public void recibirVisitaEdificioCulturalNoHiereAlPoliciaPorqueNoCorrespondeEnEsteEdificio() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.setHierenAlPolicia();
		
		String nombreConMenosDe8CaracteresEImpar = "Maria";
		Policia policia = new Policia(nombreConMenosDe8CaracteresEImpar);
		policia.setCiudadActual(londres);
		
		londres.recibirVisitaEdificioCultural(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
	
	@Test
	public void recibirVisitaEdificioEconomiaNoHiereAlPoliciaPorqueNoCorrespondeEnEsteEdificio() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.setHierenAlPolicia();
		
		String nombreConMenosDe8CaracteresYPar = "Melina";
		Policia policia = new Policia(nombreConMenosDe8CaracteresYPar);
		policia.setCiudadActual(londres);
		
		londres.recibirVisitaEdificioEconomia(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
	
	@Test
	public void recibirVisitaEdificioTransporteNoHiereAlPoliciaPorqueNoCorrespondeEnEsteEdificio() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.setHierenAlPolicia();
		
		String nombreConMasDe8Caracteres = "Macarena";
		Policia policia = new Policia(nombreConMasDe8Caracteres);
		policia.setCiudadActual(londres);
		
		londres.recibirVisitaEdificioTransporte(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
	
	@Test
	public void recibirVisitaEdificioCulturalNoHiereAlPoliciaPorqueNoCorrespondeEnEstaCiudad() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		
		String nombreConMenosDe8CaracteresYPar = "Melina";
		Policia policia = new Policia(nombreConMenosDe8CaracteresYPar);
		policia.setCiudadActual(londres);
		
		londres.recibirVisitaEdificioCultural(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
	
	@Test
	public void recibirVisitaEdificioEconomiaNoHiereAlPoliciaPorqueNoCorrespondeEnEstaCiudad() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		
		String nombreConMasDe8Caracteres = "Macarena";
		Policia policia = new Policia(nombreConMasDe8Caracteres);
		policia.setCiudadActual(londres);
		
		londres.recibirVisitaEdificioEconomia(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
	
	@Test
	public void recibirVisitaEdificioTransporteNoHiereAlPoliciaPorqueNoCorrespondeEnEstaCiudad() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		
		String nombreConMenosDe8CaracteresEImpar = "Maria";
		Policia policia = new Policia(nombreConMenosDe8CaracteresEImpar);
		policia.setCiudadActual(londres);
		
		londres.recibirVisitaEdificioTransporte(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
	
	@Test
	public void recibirVisitaEdificioCulturalDevuelvePistaVaciaPorqueElPoliciaEncuentraAlLadron() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMasDe4CaracteresYPar = "Melina";
		Policia policia = new Policia(nombreConMasDe4CaracteresYPar);
		policia.setCiudadActual(londres);
		
		Assert.assertEquals(Ciudad.MENSAJE_ENCUENTRA_LADRON, londres.recibirVisitaEdificioCultural(policia));
	}
	
	@Test
	public void recibirVisitaEdificioEconomiaDevuelvePistaVaciaPorqueElPoliciaEncuentraAlLadron() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMenosDe4Caracteres = "Ana";
		Policia policia = new Policia(nombreConMenosDe4Caracteres);
		policia.setCiudadActual(londres);
		
		Assert.assertEquals(Ciudad.MENSAJE_ENCUENTRA_LADRON, londres.recibirVisitaEdificioEconomia(policia));
	}
	
	@Test
	public void recibirVisitaEdificioTransporteDevuelvePistaVaciaPorqueElPoliciaEncuentraAlLadron() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMasDe4CaracteresEImpar = "Florencia";
		Policia policia = new Policia(nombreConMasDe4CaracteresEImpar);
		policia.setCiudadActual(londres);
		
		Assert.assertEquals(Ciudad.MENSAJE_ENCUENTRA_LADRON, londres.recibirVisitaEdificioTransporte(policia));
	}
	
	@Test
	public void recibirVisitaEdificioCulturalNODevuelvePistaVaciaPorqueElPoliciaNOEncuentraAlLadronEnEsteEdificio() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMasDe4CaracteresEImpar = "Florencia";
		Policia policia = new Policia(nombreConMasDe4CaracteresEImpar);
		policia.setCiudadActual(londres);
		
		Assert.assertNotSame(Ciudad.MENSAJE_ENCUENTRA_LADRON, londres.recibirVisitaEdificioCultural(policia));
	}
	
	@Test
	public void recibirVisitaEdificioEconomiaNODevuelvePistaVaciaPorqueElPoliciaNOEncuentraAlLadronEnEsteEdificio() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMasDe4CaracteresYPar = "Melina";
		Policia policia = new Policia(nombreConMasDe4CaracteresYPar);
		policia.setCiudadActual(londres);
		
		Assert.assertNotSame(Ciudad.MENSAJE_ENCUENTRA_LADRON, londres.recibirVisitaEdificioEconomia(policia));
	}
	
	@Test
	public void recibirVisitaEdificioTransporteNODevuelvePistaVaciaPorqueElPoliciaNOEncuentraAlLadronEnEsteEdificio() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMenosDe4Caracteres = "Ana";
		Policia policia = new Policia(nombreConMenosDe4Caracteres);
		policia.setCiudadActual(londres);
		
		Assert.assertNotSame(Ciudad.MENSAJE_ENCUENTRA_LADRON, londres.recibirVisitaEdificioTransporte(policia));
	}
	
	@Test
	public void recibirVisitaEdificioCulturalNODevuelvePistaVaciaPorqueNOEstaElLadron() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		
		String nombreConMasDe4CaracteresYPar = "Melina";
		Policia policia = new Policia(nombreConMasDe4CaracteresYPar);
		policia.setCiudadActual(londres);
		
		Assert.assertNotSame(Ciudad.MENSAJE_ENCUENTRA_LADRON, londres.recibirVisitaEdificioCultural(policia));
	}
	
	@Test
	public void recibirVisitaEdificioEconomiaNODevuelvePistaVaciaPorqueNOEstaElLadron() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		
		String nombreConMenosDe4Caracteres = "Ana";
		Policia policia = new Policia(nombreConMenosDe4Caracteres);
		policia.setCiudadActual(londres);
		
		Assert.assertNotSame(Ciudad.MENSAJE_ENCUENTRA_LADRON, londres.recibirVisitaEdificioEconomia(policia));
	}
	
	@Test
	public void recibirVisitaEdificioTransporteNODevuelvePistaVaciaPorqueNOEstaElLadron() throws ExcepcionTiempoAgotado {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		
		String nombreConMasDe4CaracteresEImpar = "Florencia";
		Policia policia = new Policia(nombreConMasDe4CaracteresEImpar);
		policia.setCiudadActual(londres);
		
		Assert.assertNotSame(Ciudad.MENSAJE_ENCUENTRA_LADRON, londres.recibirVisitaEdificioTransporte(policia));
	}
}	