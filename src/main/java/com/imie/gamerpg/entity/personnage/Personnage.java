/**
 * 
 */
package com.imie.gamerpg.entity.personnage;

import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.armure.Armure;
import com.imie.gamerpg.entity.interfaceclass.ClasseRPG;

/**
 * @author Fabrice
 *
 */
public abstract class Personnage {

	private String nom;
	private int ptsVie;
	private int ptsAction;
	private Arme arme;
	private Armure armure;
	private ClasseRPG classe;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom.toUpperCase();
	}

	/**
	 * @return the classe
	 */
	public ClasseRPG getClasse() {
		return classe;
	}

	/**
	 * @param classe the classe to set
	 */
	public void setClasse(ClasseRPG classe) {
		this.classe = classe;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the ptsVie
	 */
	public int getPtsVie() {
		return ptsVie;
	}

	/**
	 * @param ptsVie the ptsVie to set
	 */
	public void setPtsVie(int ptsVie) {
		this.ptsVie = ptsVie;
	}

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
	 * @return the arme
	 */
	public Arme getArme() {
		return arme;
	}

	/**
	 * @param arme the arme to set
	 */
	public void setArme(Arme arme) {
		this.arme = arme;
	}

	/**
	 * @return the armure
	 */
	public Armure getArmure() {
		return armure;
	}

	/**
	 * @param armure the armure to set
	 */
	public void setArmure(Armure armure) {
		this.armure = armure;
	}

	/**
	 * @param nom
	 * @param ptsVie
	 * @param ptsAction
	 * @param arme
	 * @param armure
	 */
	public Personnage(String nom, int ptsVie, int ptsAction, Arme arme, Armure armure, ClasseRPG classe) {
		this.nom = nom;
		this.ptsVie = ptsVie;
		this.ptsAction = ptsAction;
		this.arme = arme;
		this.armure = armure;
		this.classe = classe;
	}

	public Personnage(String nom, int ptsVie, int ptsAction, ClasseRPG classe) {
		this.nom = nom;
		this.ptsVie = ptsVie;
		this.ptsAction = ptsAction;
		this.classe = classe;
	}
	public boolean isAlive() {
		boolean isAlive = true;

		if (this.getPtsVie() <= 0) {
			isAlive = false;
		}
		return isAlive;
	}

	public Personnage() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", ptsVie=" + ptsVie + ", ptsAction=" + ptsAction + ", arme=" + arme
				+ ", armure=" + armure + ", classe=" + classe + "]";
	}

}
