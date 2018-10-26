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
public class Hero extends Personnage {
	/**
	 * 
	 * @param nom
	 * @param ptsVie
	 * @param ptsAction
	 * @param arme
	 * @param armure
	 * @param classe
	 */
	public Hero(String nom, int ptsVie, int ptsAction, Arme arme, Armure armure, ClasseRPG classe) {
		super(nom, ptsVie, ptsAction, arme, armure, classe);
	}
	public Hero() {}
}
