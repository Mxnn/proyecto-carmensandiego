package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;
import java.util.ArrayList;

// public enum Sexo { FEMENINO, MASCULINO }
// public enum Pelo { NEGRO, RUBIO, ROJO, MARRON }
// public enum Hobby { BASQUET, FUTBOL, TENNIS }
// public enum Auto { MOTO, CONVERTIBLE, CAMIONETA }
// public enum MarcaPersonal { ANILLO, TATUAJE, CICATRIZ }

public class ComputadoraTest {
	@Test
	public void setSospechosoGuardaATodosLosLadronesIncluidoElBuscado() {
		Ladron buscado = new Ladron("Jaime", Ladron.Sexo.MASCULINO, Ladron.Pelo.NEGRO, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.CICATRIZ);
		Computadora computadora = new Computadora(buscado);
		
		Ladron sospechoso1 = new Ladron("Tomas", Ladron.Sexo.MASCULINO, Ladron.Pelo.RUBIO, Ladron.Hobby.FUTBOL, Ladron.Auto.CAMIONETA, Ladron.MarcaPersonal.CICATRIZ);
		Ladron sospechoso2 = new Ladron("Celeste", Ladron.Sexo.FEMENINO, Ladron.Pelo.ROJO, Ladron.Hobby.TENNIS, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		Ladron sospechoso3 = new Ladron("Carmen", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.BASQUET, Ladron.Auto.CONVERTIBLE, Ladron.MarcaPersonal.ANILLO);
		computadora.setSospechoso(sospechoso1);
		computadora.setSospechoso(sospechoso2);
		computadora.setSospechoso(sospechoso3);
		
		ArrayList<Ladron> sospechosos = computadora.getSospechosos();
		Assert.assertEquals(sospechosos.get(0), buscado);
		Assert.assertEquals(sospechosos.get(1), sospechoso1);
		Assert.assertEquals(sospechosos.get(2), sospechoso2);
		Assert.assertEquals(sospechosos.get(3), sospechoso3);
	}
}