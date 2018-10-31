/**
 * 
 */
package com.imie.gamerpg.entity.armure;

import com.imie.gamerpg.database.DBItem;

/**
 * @author Fabrice
 *
 */
public abstract class Armure extends DBItem {

	private String nom;
	private int ptsArmurePhysique;
	private int ptsArmureMagique;
	
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
	 * @return the ptsArmureMagique
	 */
	public int getPtsArmureMagique() {
		return ptsArmureMagique;
	}

	/**
	 * @param ptsArmureMagique the ptsArmureMagique to set
	 */
	public void setPtsArmureMagique(int ptsArmureMagique) {
		this.ptsArmureMagique = ptsArmureMagique;
	}

	/**
	 * @return the ptsArmurePhysique
	 */
	public int getPtsArmurePhysique() {
		return ptsArmurePhysique;
	}

	/**
	 * @param ptsArmurePhysique the ptsArmurePhysique to set
	 */
	public void setPtsArmurePhysique(int ptsArmurePhysique) {
		this.ptsArmurePhysique = ptsArmurePhysique;
	}

	/**
	 * @param nom
	 * @param ptsArmureMagique
	 * @param ptsArmurePhysique
	 */
	public Armure(String nom, int ptsArmurePhysique, int ptsArmureMagique) {
		super();
		this.nom = nom;
		this.ptsArmurePhysique = ptsArmurePhysique;
		this.ptsArmureMagique = ptsArmureMagique;
	}
	public Armure() {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Armure [nom=" + nom + ", ptsArmureMagique=" + ptsArmureMagique + ", ptsArmurePhysique="
				+ ptsArmurePhysique + "]";
	}
	
}
