
package Model;

import java.io.Serializable;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che definisce i metodi e gli attributi per le Pietanze.
*/
public class Pietanza implements Serializable{
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = 954755859354939026L;
    
    public static int ANTIPASTO = 0; //costanti pubbliche per il reparto della pietanza
    public static int PRIMO_PIATTO = 1;
    public static int SECONDO_PIATTO = 2;
    public static int DOLCE = 3;
    public static int BIBITA = 4;
    
    private String nome;
    private String descrizione;
    
    private int reparto;
    
    private float costo;
    
    /**
     * Costruttore parametrizzato
     * @param nome, nome della pietanza
     * @param costo, costo della pietanza
     * @param descrizione, descrizione della pietanza
     * @param reparto, reparto della pietanza (antipasto, primo, etc...). 
     */
    public Pietanza(String nome, float costo, String descrizione, int reparto) {
        this.nome = nome;
        this.costo = costo;
        this.descrizione = descrizione;
        this.reparto = reparto;
    }
    
    public Pietanza() {
        
    }

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the costo
	 */
	public float getCosto() {
		return costo;
	}

	/**
	 * @param costo the costo to set
	 */
	public void setCosto(float costo) {
		this.costo = costo;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the reparto
	 */
	public int getReparto() {
		return reparto;
	}

	/**
	 * @param reparto the reparto to set
	 */
	public void setReparto(int reparto) {
		this.reparto = reparto;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
