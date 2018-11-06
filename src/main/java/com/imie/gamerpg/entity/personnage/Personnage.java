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
	private Arme secondaryWeapon;
	private Armure armure;
	private ClasseRPG classe;
	private int bonusArmurePhy;
	private int bonusArmureMag;

	/**
	 * Constructeur utilisé pour le Personnage
	 * @param nom
	 * @param ptsVie
	 * @param ptsAction
	 * @param classe
	 */
	public Personnage(String nom, int ptsVie, int ptsAction, ClasseRPG classe) {
		this.nom = nom;
		this.ptsVie = ptsVie;
		this.ptsAction = ptsAction;
		this.classe = classe;
		this.bonusArmurePhy = 0;
		this.bonusArmureMag = 0;
	}

	public int getbonusArmurePhy() {
		return bonusArmurePhy;
	}

	public void setbonusArmurePhy(int bonusArmurePhy) {
		this.bonusArmurePhy = bonusArmurePhy;
	}

	public int getbonusArmureMag() {
		return bonusArmureMag;
	}

	public void setbonusArmureMag(int bonusArmureMag) {
		this.bonusArmureMag = bonusArmureMag;
	}

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

	public Arme getsecondaryWeapon() {
		return secondaryWeapon;
	}

	public void setsecondaryWeapon(Arme secondaryWeapon) {
		this.secondaryWeapon = secondaryWeapon;
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
	 * Permet de définir si le personnage est toujours en vie ou non
	 * @return
	 */
	public boolean isAlive() {
		boolean isAlive = true;

		if (this.getPtsVie() <= 0) {
			isAlive = false;
		}
		return isAlive;
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
