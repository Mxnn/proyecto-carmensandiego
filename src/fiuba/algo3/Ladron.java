package fiuba.algo3;

public class Ladron {
	public enum Sexo { FEMENINO, MASCULINO }
	public enum Pelo { NEGRO, RUBIO, ROJO, MARRON }
	public enum Hobby { CROQUET, TENNIS, ALPINISMO }
	public enum Auto { MOTO, CONVERTIBLE, LIMUSINA }
	public enum MarcaPersonal { ANILLO, TATUAJE, CICATRIZ, JOYAS }
	
	private String nombre;
	private Sexo sexo;
	private Pelo pelo;
	private Hobby hobby;
	private Auto auto;
	private MarcaPersonal marcaPersonal;
	
	public Ladron(String nombre, Sexo sexo, Pelo pelo, Hobby hobby, Auto auto, MarcaPersonal marcaPersonal) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.pelo = pelo;
		this.hobby = hobby;
		this.auto = auto;
		this.marcaPersonal = marcaPersonal;
	}

    public String getNombre() {
        return this.nombre;
    }
	
	public boolean tieneEstaCaracteristica(Sexo sexo) {
		return this.sexo == sexo;
	}
	
	public boolean tieneEstaCaracteristica(Pelo pelo) {
		return this.pelo == pelo;
	}
	
	public boolean tieneEstaCaracteristica(Hobby hobby) {
		return this.hobby == hobby;
	}
	
	public boolean tieneEstaCaracteristica(Auto auto) {
		return this.auto == auto;
	}
	
	public boolean tieneEstaCaracteristica(MarcaPersonal marcaPersonal) {
		return this.marcaPersonal == marcaPersonal;
	}
}