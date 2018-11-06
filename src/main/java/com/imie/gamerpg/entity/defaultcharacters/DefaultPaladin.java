/**
 *
 */

package com.imie.gamerpg.entity.defaultcharacters;

import com.imie.gamerpg.entity.interfaceclass.Paladin;
import com.imie.gamerpg.entity.personnage.Personnage;

/**
 * @author Romain
 *
 */
public class DefaultPaladin extends DefaultFighter implements Paladin {

	/**
	 * Constructeur par défaut
	 */
	public DefaultPaladin() {}

	/**
	 * Surcharge de la fonction défendre déclarée dans le DefaultFighter
	 */
	public void defendre(Personnage me) {
		me.setbonusArmureMag(me.getbonusArmureMag() + me.getArmure().getPtsArmurePhysique()
				+ me.getArmure().getPtsArmurePhysique() / 2);
		me.setbonusArmureMag(me.getbonusArmureMag() + me.getArmure().getPtsArmureMagique()
				+ me.getArmure().getPtsArmureMagique() / 2);
	}
}
