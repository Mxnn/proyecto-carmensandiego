package fiuba.algo3;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
public class Pista {
	public final static String PISTA_POR_DEFECTO = "No se nada sobre ese sujeto.";
	
	private String pista;

	public Pista() {
		this.pista = PISTA_POR_DEFECTO;
	}
	
    public Pista(String pista) {
        this.pista = pista;
    }

    public String getPista() {
        return this.pista;
    }
	public static Pista hidratar(Node elementoPista) {
		
		Pista pista=new Pista(((Element)elementoPista).getAttribute("String"));
		return pista;
	}
}
