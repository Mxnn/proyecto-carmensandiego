package fiuba.algo3.modelo;

public class Ladron {
	public enum Sexo { FEMENINO("femenino"), MASCULINO("masculino");
		
		private String representacionComoString;
		
		private Sexo(String representacionComoString) {
			this.representacionComoString = representacionComoString;
		}
		
		public String toString() {
			return this.representacionComoString;
		}
	}
	
	public enum Pelo { NEGRO("negro"), RUBIO("rubio"), ROJO("rojo"), MARRON("marron");
		
		private String representacionComoString;
		
		private Pelo(String representacionComoString) {
			this.representacionComoString = representacionComoString;
		}
		
		public String toString() {
			return this.representacionComoString;
		}
	}
	
	public enum Hobby { CROQUET("croquet"), TENNIS("tennis"), ALPINISMO("alpinismo");
	
		private String representacionComoString;
		
		private Hobby(String representacionComoString) {
			this.representacionComoString = representacionComoString;
		}
		
		public String toString() {
			return this.representacionComoString;
		}
	}
	
	public enum Auto { MOTO("una moto"), CONVERTIBLE("un convertible"), LIMUSINA("una limusina");
	
	private String representacionComoString;
		
		private Auto(String representacionComoString) {
			this.representacionComoString = representacionComoString;
		}
		
		public String toString() {
			return this.representacionComoString;
		}
	}
	
	public enum MarcaPersonal { ANILLO("un anillo"), TATUAJE("un tatuaje"), CICATRIZ("una cicatriz");
	
		private String representacionComoString;
		
		private MarcaPersonal(String representacionComoString) {
			this.representacionComoString = representacionComoString;
		}
		
		public String toString() {
			return this.representacionComoString;
		}
	}
	
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
	
	public String generarUnaPistaSobreElSexo() {
		return this.sexo.toString();
	}
	
	public String generarUnaPistaSobreElPelo() {
		return "Tenia el pelo " + this.pelo.toString();
	}
	
	public String generarUnaPistaSobreElHobby() {
		return "Dijo que era bueno en " + this.hobby.toString();
	}
	
	public String generarUnaPistaSobreElAuto() {
		return "Conducia " + this.auto.toString();
	}
	
	public String generarUnaPistaSobreLaMarcaPersonal() {
		return "Vi que llevaba " + this.marcaPersonal.toString();
	}
}