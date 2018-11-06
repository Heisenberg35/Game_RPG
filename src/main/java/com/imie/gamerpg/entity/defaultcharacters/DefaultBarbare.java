/**
 *
 */

package com.imie.gamerpg.entity.defaultcharacters;

import com.imie.gamerpg.entity.interfaceclass.Barbare;
import com.imie.gamerpg.entity.personnage.Personnage;

/**
 * @author Romain
 *
 */
public class DefaultBarbare extends DefaultFighter implements Barbare {

	/**
	 * Constructeur de la classe (par défaut)
	 */
	public DefaultBarbare() {
		super();
	}

	/**
	 * Fonction qui permet d'attaquer l'adversaire passé en paramètres
	 */
	public void fight(Personnage defender) {
		int degats = 0;
		int temp = 0;
		int tempPa = me.getPtsAction();

		while (tempPa >= (me.getArme().getPtsAction() + me.getsecondaryWeapon().getPtsAction() / 2)) {
			temp = me.getArme().getPtsAttaquePhysique() - defender.getArmure().getPtsArmurePhysique();
			if (temp  > 0) {
				degats += temp;
			}
			temp = me.getArme().getPtsAttaqueMagique() - defender.getArmure().getPtsArmureMagique();
			if (temp > 0) {
				degats += temp;
			}
			tempPa -= me.getArme().getPtsAction();

			temp = me.getsecondaryWeapon().getPtsAttaquePhysique()
					- defender.getArmure().getPtsArmurePhysique();
			if (temp  > 0) {
				degats += temp;
			}
			temp = me.getsecondaryWeapon().getPtsAttaqueMagique()
					- defender.getArmure().getPtsArmureMagique();
			if (temp > 0) {
				degats += temp;
			}
			tempPa -= me.getsecondaryWeapon().getPtsAction() / 2;
		}
		defender.setPtsVie(defender.getPtsVie() - degats);
	}
}
