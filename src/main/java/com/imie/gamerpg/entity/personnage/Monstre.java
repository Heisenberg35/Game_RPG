/**
 *
 */

package com.imie.gamerpg.entity.personnage;

import com.imie.gamerpg.entity.interfaceclass.ClasseRPG;

/**
 * @author Fabrice
 *
 */
public class Monstre extends Personnage {

	public Monstre(String nom, int ptsVie, int ptsAction, ClasseRPG classe) {
		super(nom, ptsVie, ptsAction, classe);
	}
}
