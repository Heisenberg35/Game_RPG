/**
 * 
 */
package com.imie.gamerpg.entity.armure;

/**
 * @author Fabrice
 *
 */
public abstract class Armure {

	private String nom;
	private int ptsArmure;

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
	 * @return the ptsArmure
	 */
	public int getPtsArmure() {
		return ptsArmure;
	}

	/**
	 * @param ptsArmure the ptsArmure to set
	 */
	public void setPtsArmure(int ptsArmure) {
		this.ptsArmure = ptsArmure;
	}

	/**
	 * @param nom
	 * @param ptsArmure
	 */
	public Armure(String nom, int ptsArmure) {
		super();
		this.nom = nom;
		this.ptsArmure = ptsArmure;
	}

}
