/**
 * 
 */
package com.imie.gamerpg.entity.arme;

import com.imie.gamerpg.database.DBItem;

/**
 * @author Fabrice
 *
 */
public abstract class Arme extends DBItem {

	private String nom;
	private int ptsAttaquePhysique;
	private int ptsAttaqueMagique;
	private int ptsAction;
	
	/**
	 * @return the ptsAction
	 */
	public int getPtsAction() {
		return ptsAction;
	}
	/**
	 * @param ptsAction the ptsAction to set
	 */
	public void setPtsAction(int ptsAction) {
		this.ptsAction = ptsAction;
	}
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
	 * @return the ptsAttaquePhysique
	 */
	public int getPtsAttaquePhysique() {
		return ptsAttaquePhysique;
	}
	/**
	 * @param ptsAttaquePhysique the ptsAttaquePhysique to set
	 */
	public void setPtsAttaquePhysique(int ptsAttaquePhysique) {
		this.ptsAttaquePhysique = ptsAttaquePhysique;
	}
	/**
	 * @return the ptsAttaqueMagique
	 */
	public int getPtsAttaqueMagique() {
		return ptsAttaqueMagique;
	}
	/**
	 * @param ptsAttaqueMagique the ptsAttaqueMagique to set
	 */
	public void setPtsAttaqueMagique(int ptsAttaqueMagique) {
		this.ptsAttaqueMagique = ptsAttaqueMagique;
	}
	/**
	 * @param nom
	 * @param ptsAttaquePhysique
	 * @param ptsAttaqueMagique
	 * @param ptsAction
	 */
	public Arme(String nom, int ptsAttaquePhysique, int ptsAttaqueMagique, int ptsAction) {
		super();
		this.nom = nom;
		this.ptsAttaquePhysique = ptsAttaquePhysique;
		this.ptsAttaqueMagique = ptsAttaqueMagique;
		this.ptsAction = ptsAction;
	}
}
