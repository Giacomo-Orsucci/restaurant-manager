
package Model;

import java.io.Serializable;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Classe che definisce i metodi e gli attributi per i Tavoli.
 */
public class Tavolo implements Serializable{
    /**
     * Serial Version UID.
    */
    private static final long serialVersionUID = 5481038063138035704L;
    
    public static final int NUMERO_MASSIMO = 10;   
    public static final int LIBERO = 0;   //costanti pubbliche per lo stato del tavolo
    public static final int OCCUPATO = 1;
    public static final int ATTESA_CONTO = 2;
    public static final int ATTESA_PAGAMENTO = 3;
    
    private String id;
    
    private int numeroPosti;
    private int stato;
    /*
    STATO:
        0) LIBERO 
        1) OCCUPATO
        2) IN ATTESA DI CONTO
        3) IN ATTESA DI PAGAMENTO
    */

    public String getStatoString() {
        if(stato == LIBERO) {
            return "Libero";
        }else if(stato == OCCUPATO) {
            return "Occupato";
        }else if(stato == ATTESA_CONTO) {
            return "In attesa Conto";
        }else {
            return "In attesa pagamento";
        }
    }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the numeroPosti
	 */
	public int getNumeroPosti() {
		return numeroPosti;
	}

	/**
	 * @param numeroPosti the numeroPosti to set
	 */
	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	/**
	 * @return the stato
	 */
	public int getStato() {
		return stato;
	}

	/**
	 * @param stato the stato to set
	 */
	public void setStato(int stato) {
		this.stato = stato;
	}
}
