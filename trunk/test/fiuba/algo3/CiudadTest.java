package fiuba.algo3;

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
    public void ciudadSeCreaSinEsconderAlLadron() {
        Ciudad ciudad = new Ciudad("Buenos Aires", new Coordenada(1, 1));
		
        Assert.assertFalse(ciudad.escondeAlLadron());
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
    public void conectarCiudadAgregaUnaCiudadALaActual() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));
        Ciudad paris = new Ciudad("Paris", new Coordenada(5,7));

        londres.conectarCiudad(paris);
        Assert.assertTrue((londres.getCiudadesConectadas()).size() == 1);
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
		Assert.assertTrue(paris.cantidadDeCiudadesConectadas() == 1);
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
    public void escondeAlLadronDevuelveTrueSiElLadronEstaEnLaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
        
        londres.esconderAlLadron();

        Assert.assertTrue(londres.escondeAlLadron());
    }

    @Test
    public void ladronEstaEnLaCiudadDevuelveFalseSiElLadronNoEstaEnLaCiudad() {
        Ciudad londres = new Ciudad("Londres", new Coordenada(1,3));

        Assert.assertFalse(londres.escondeAlLadron());
    }
	
	@Test
	public void getEdificioCulturalQueRecibePoliciaHiereAlPolicia() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMasDe6CaracteresYPar = "Macarena";
		Policia policia = new Policia(nombreConMasDe6CaracteresYPar);
		policia.setCiudadActual(londres);
		
		londres.getEdificioCultural(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	@Test (expected = ExcepcionJugadorSinTiempoDisponible.class)
	public void getEdificioCulturalQueRecibePoliciaSinTiempoLanzaExcepcion() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMasDe6CaracteresYPar = "Macarena";
		Policia policia = new Policia(nombreConMasDe6CaracteresYPar);
		policia.setCiudadActual(londres);
		policia.setTiempoDisponible(1);
		
		londres.getEdificioCultural(policia);
	}
	
	@Test
	public void getEdificioEconomiaQueRecibePoliciaHiereAlPolicia() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMenosDe6Caracteres = "Ana";
		Policia policia = new Policia(nombreConMenosDe6Caracteres);
		policia.setCiudadActual(londres);
		
		londres.getEdificioEconomia(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	@Test (expected = ExcepcionJugadorSinTiempoDisponible.class)
	public void getEdificioEconomiaQueRecibePoliciaSinTiempoLanzaExcepcion() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMenosDe6Caracteres = "Ana";
		Policia policia = new Policia(nombreConMenosDe6Caracteres);
		policia.setCiudadActual(londres);
		policia.setTiempoDisponible(1);
		
		londres.getEdificioEconomia(policia);
	}
	
	@Test
	public void getEdificioTransporteQueRecibePoliciaHiereAlPolicia() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMasDe6CaracteresEImpar = "Florencia";
		Policia policia = new Policia(nombreConMasDe6CaracteresEImpar);
		policia.setCiudadActual(londres);
		
		londres.getEdificioTransporte(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL - Policia.TIEMPO_POR_RECIBIR_HERIDA);
	}
	
	@Test (expected = ExcepcionJugadorSinTiempoDisponible.class)
	public void getEdificioTransporteQueRecibePoliciaSinTiempoLanzaExcepcion() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		londres.esconderAlLadron();
		
		String nombreConMasDe6CaracteresEImpar = "Florencia";
		Policia policia = new Policia(nombreConMasDe6CaracteresEImpar);
		policia.setCiudadActual(londres);
		policia.setTiempoDisponible(1);
		
		londres.getEdificioTransporte(policia);
	}
	
	@Test
	public void getEdificioCulturalQueRecibePoliciaNoHiereAlPoliciaPorqueNoEstaElLadron() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		
		String nombreConMasDe6CaracteresYPar = "Macarena";
		Policia policia = new Policia(nombreConMasDe6CaracteresYPar);
		policia.setCiudadActual(londres);
		
		londres.getEdificioCultural(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
	
	@Test
	public void getEdificioEconomiaQueRecibePoliciaNoHiereAlPoliciaPorqueNoEstaElLadron() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		
		String nombreConMenosDe6Caracteres = "Ana";
		Policia policia = new Policia(nombreConMenosDe6Caracteres);
		policia.setCiudadActual(londres);
		
		londres.getEdificioEconomia(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
	
	@Test
	public void getEdificioTransporteQueRecibePoliciaNoHiereAlPoliciaPorqueNoEstaElLadron() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad londres = new Ciudad("Londres", new Coordenada(1, 3));
		
		String nombreConMasDe6CaracteresEImpar = "Florencia";
		Policia policia = new Policia(nombreConMasDe6CaracteresEImpar);
		policia.setCiudadActual(londres);
		
		londres.getEdificioTransporte(policia);
		
		Assert.assertTrue(policia.getTiempoDisponible() == Policia.TIEMPO_DISPONIBLE_INICIAL);
	}
}