/**
 * 
 */
package com.imie.gamerpg.entity.arme;

/**
 * @author Fabrice
 *
 */
public abstract class Arme {

	private String nom;
	private int ptsAttaque;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the ptsAttaque
	 */
	public int getPtsAttaque() {
		return ptsAttaque;
	}

	/**
	 * @param ptsAttaque the ptsAttaque to set
	 */
	public void setPtsAttaque(int ptsAttaque) {
		this.ptsAttaque = ptsAttaque;
	}

	/**
	 * @param nom
	 * @param ptsAttaque
	 */
	public Arme(String nom, int ptsAttaque) {
		super();
		this.nom = nom;
		this.ptsAttaque = ptsAttaque;
	}

}
