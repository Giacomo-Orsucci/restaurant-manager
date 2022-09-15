
package Model;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che definisce i metodi e gli attributi per gli Ordini.
*/
public class Ordine {
    
    private Pietanza p;
    
    private int numeroOrdini;

    /**
     * Costruttore parametrizzato
     * @param numeroOrdini, numero dell'ordine
     * @param p, riferimento della pietanza ordinata 
     */
    public Ordine(int numeroOrdini, Pietanza p) {
        this.numeroOrdini = numeroOrdini;
        this.p = p;
    }

	/**
	 * @return the p
	 */
	public Pietanza getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(Pietanza p) {
		this.p = p;
	}

	/**
	 * @return the numeroOrdini
	 */
	public int getNumeroOrdini() {
		return numeroOrdini;
	}

	/**
	 * @param numeroOrdini the numeroOrdini to set
	 */
	public void setNumeroOrdini(int numeroOrdini) {
		this.numeroOrdini = numeroOrdini;
	}
}
