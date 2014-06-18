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
	private boolean tieneOrdenDeArresto;
	private boolean estaArrestado;
	
	public Ladron(String nombre, Sexo sexo, Pelo pelo, Hobby hobby, Auto auto, MarcaPersonal marcaPersonal) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.pelo = pelo;
		this.hobby = hobby;
		this.auto = auto;
		this.marcaPersonal = marcaPersonal;
		this.tieneOrdenDeArresto = false;
		this.estaArrestado = false; 
	}
	
	//SETTERS:
	public void recibirArresto() {
		this.estaArrestado = true;
	}
	
	public void recibirOrdenDeArresto() {
		this.tieneOrdenDeArresto = true;
	}
	
	//GETTERS:
    public String getNombre() {
        return this.nombre;
    }
	
	public boolean estaArrestado() {
		return this.estaArrestado;
	}
	
	public boolean tieneOrdenDeArresto() {
		return this.tieneOrdenDeArresto;
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